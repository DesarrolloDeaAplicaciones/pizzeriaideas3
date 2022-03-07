package com.foridea.pizzeriaideas3.services;


import com.foridea.pizzeriaideas3.dto.CategoryResponse;
import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.entities.ImageProfile;
import com.foridea.pizzeriaideas3.mapper.CategoryMapper;
import com.foridea.pizzeriaideas3.repositories.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//implementacion de servicios Categoria

@Service
public class CategoryServiceImpl implements CategoryService {
   

    private static final String ERROR_FIND_ID = "No se econtro la categoria";
    private static final String ERROR_CONECTION = "Error al intentar conectar con la BD";
   
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

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
            categoryRepository.save(categoryMapper.categoryDtoEntity(category));
            return new ResponseEntity<>("Category created succesfully!",
                    HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Ups something was wrong..!",
                    HttpStatus.CONFLICT);
        }
    }

    private ResponseEntity<?> controlFieldsEmpty(CategoryResponse category) {
        final ResponseEntity<?> messageFieldsEmpty
                = new ResponseEntity<>("The fields Name can't be empty",
                        HttpStatus.NOT_ACCEPTABLE);
        return (category.getName() == null
                || category.getName().trim().isEmpty()) ? messageFieldsEmpty : null;
    }

//    @Transactional
//    @Override
//    public List<CategoryImage> findAll() {
//        try {
//            List<CategoryImage> listResponse = new ArrayList<>();
//            List<Category> entities = categoryRepository.findAll();
//            for (Category entity : entities) {
//                listResponse.add(categoryMapper.categoryImageEntityDto(entity));
//            }
//            return listResponse;
//        } catch (EntityNotFoundException e) {
//            throw new EntityNotFoundException(ERROR_CONECTION);
//        }
//
//    }

    @Override
    public List<Category> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Category findById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Category save(Category entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Category update(Long id, Category entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
