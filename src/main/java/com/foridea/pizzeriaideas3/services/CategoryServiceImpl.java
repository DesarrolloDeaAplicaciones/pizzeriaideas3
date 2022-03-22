package com.foridea.pizzeriaideas3.services;

import com.foridea.pizzeriaideas3.abstraction.CategoryService;
import com.foridea.pizzeriaideas3.dto.CategoryImage;
import com.foridea.pizzeriaideas3.dto.CategoryResponse;
import com.foridea.pizzeriaideas3.dto.ModelImage;
import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.entities.ImageProfile;
import com.foridea.pizzeriaideas3.mapper.GenericModelMapper;
import com.foridea.pizzeriaideas3.repository.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String ERROR_FIND_ID = "No se econtro la categoria";
    private static final String ERROR_CONECTION = "Error al intentar conectar con la BD";
    private static final String ERROR_NOT_LIST_CATEGORY = "No se encontro categorias";
    private String url="http://localhost:8080/api/v1/images/profileimage/";
    @Autowired
    private CategoryRepository categoryRepository;   
    static GenericModelMapper mapper=GenericModelMapper.singleInstance();

    @Transactional
    @Override
    public ResponseEntity<?> addCategory(
            CategoryResponse category,
            ImageProfile image) {
        ResponseEntity<?> controlFieldsEmpty = controlFieldsEmpty(category);
        if (controlFieldsEmpty != null) {
            return controlFieldsEmpty;
        }

        category.setImageProfile(image);
        try {
            categoryRepository.save(mapper.mapDtoCategory(category)) ;
            return new ResponseEntity<>("Category created succesfully!",
                    HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(ERROR_CONECTION,
                    HttpStatus.CONFLICT);
        }
    }

    private ResponseEntity<?> controlFieldsEmpty(CategoryResponse category) {
        final ResponseEntity<?> messageFieldsEmpty
                = new ResponseEntity<>("The fields Name can't be empty",
                        HttpStatus.NOT_ACCEPTABLE);
        return (category.getNamecategory()== null
                || category.getNamecategory().trim().isEmpty()) ? messageFieldsEmpty : null;
    }

    @Transactional
    @Override
    public ResponseEntity<?> update(Long id, CategoryResponse entity, ImageProfile image) {
        Optional<Category> entityById = categoryRepository.findById(id);
        if (entityById.isPresent()) {
            ResponseEntity<?> controlFieldsEmpty = controlFieldsEmpty(entity);
            if (controlFieldsEmpty != null) {
                return controlFieldsEmpty;
            }
        }
        entity.setImageProfile(image);
        try {
            categoryRepository.save(mapper.mapDtoCategory(entity));
            return new ResponseEntity<>("Category updated succesfully!",
                    HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Ups something was wrong..!",
                    HttpStatus.CONFLICT);
        }
    }

    @Transactional
    @Override
    public CategoryImage findById(Long id) {
        try {
            Optional<Category> entityById = categoryRepository.findById(id);
            if (entityById.isPresent()) {                
                return mapper.mapToCategorySimppleDto(entityById.get(),
                        new ModelImage(entityById.get().getImageProfile().getName_image(), 
                                url+entityById.get().getImageProfile().getId()));
            } else {
                throw new EntityNotFoundException(ERROR_FIND_ID);
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(ERROR_CONECTION);
        }
    }

    @Transactional
    @Override
    public List<CategoryImage> findAll() {
        return listZizeCategory(categoryRepository.findAll());
    }

    @Transactional
    @Override
    public List<CategoryImage> listCategoryActive() {
        return listZizeCategory(categoryRepository.listCategoryActive());
    }

    @Transactional
    @Override
    public List<CategoryImage> listCategoryInactive() {
        return listZizeCategory(categoryRepository.listCategoryInactive());
    }

    public List<CategoryImage> listZizeCategory(List<Category> entities) {     
        
        List<CategoryImage> listResponse = new ArrayList<>();
        if (entities.size() == 0) {
            throw new EntityNotFoundException(ERROR_NOT_LIST_CATEGORY);
        }
        for (Category entity : entities) {           
            listResponse.add(mapper.mapToCategorySimppleDto(entity, 
                    new ModelImage(entity.getImageProfile().getName_image(), url+entity.getImageProfile().getId()) ));
        }
        return listResponse;
    }

    @Transactional
    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Category category = getCategory(id);
        category.setSoftDeleted(true);
        category.setStatus(Boolean.FALSE);
        categoryRepository.save(category);
    }

    private Category getCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);

        if (!category.isPresent() || category.get().isSoftDeleted()) {
            throw new EntityNotFoundException(ERROR_FIND_ID);
        }
        return category.get();
    }

}
