package com.foridea.pizzeriaideas3.services;

import com.foridea.pizzeriaideas3.abstraction.FoodService;
import com.foridea.pizzeriaideas3.dto.CategoryImage;
import com.foridea.pizzeriaideas3.dto.ModelCategoryImage;
import com.foridea.pizzeriaideas3.dto.ModelFood;
import com.foridea.pizzeriaideas3.dto.ModelFoodList;
import com.foridea.pizzeriaideas3.dto.ModelImage;
import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.entities.Food;
import com.foridea.pizzeriaideas3.entities.ImageProfile;
import com.foridea.pizzeriaideas3.mapper.GenericFoodMapper;
import com.foridea.pizzeriaideas3.repository.FoodRepository;
import static com.foridea.pizzeriaideas3.services.CategoryServiceImpl.mapper;
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
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodRepository foodRepository;
    private static final String ERROR_FIND_ID = "No se econtro la categoria";
    private static final String ERROR_CONECTION = "Error al intentar conectar con la BD";
    private static final String ERROR_NOT_LIST_FOOD = "No se encontraron comidas";
    private String url="http://localhost:8080/api/v1/images/profileimage/";
    
    @Autowired
     static GenericFoodMapper mapper=GenericFoodMapper.singleInstance();
    
    @Transactional
    @Override
    public ResponseEntity<?> addFood(
            ModelFood food,
            ImageProfile image)  {
        ResponseEntity<?> controlFieldsEmpty = controlFieldsEmpty(food);
        if (controlFieldsEmpty != null) {
            return controlFieldsEmpty;
        }

        food.setImageProfile(image);
        food.setStatus(true);
        try {
            foodRepository.save(mapper.mapDtoFood(food));
            return new ResponseEntity<>("Food created succesfully!",
                    HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(ERROR_CONECTION,
                    HttpStatus.CONFLICT);
        }
    }

    private ResponseEntity<?> controlFieldsEmpty(ModelFood food) {
        final ResponseEntity<?> messageFieldsEmpty
                = new ResponseEntity<>("The fields Name can't be empty",
                        HttpStatus.NOT_ACCEPTABLE);
        return (food.getName_food() == null
                || food.getName_food().trim().isEmpty()) ? messageFieldsEmpty : null;
    }

    
    @Transactional
    @Override
    public List<ModelFoodList> findAll() {
        return listZizeFood(foodRepository.findAll());
    }

   

    public List<ModelFoodList> listZizeFood(List<Food> entities) {  
        List<ModelFoodList> listResponse = new ArrayList<>();
        if (entities.size() == 0) {
            throw new EntityNotFoundException(ERROR_NOT_LIST_FOOD);
        }
        for (Food entity : entities) {           
            listResponse.add(mapper.mapToFoodSimppleDto(entity, 
                    new ModelImage(entity.getImageProfile().getName_image(), url+entity.getImageProfile().getId()),
                    new ModelCategoryImage(entity.getCategory_id().getId(), entity.getCategory_id().getNamecategory())));
        }       
        return listResponse;
    }
    
    @Transactional
    @Override
    public ResponseEntity<?> update(Long id, ModelFood entity, ImageProfile image) {
        Optional<Food> entityById = foodRepository.findById(id);
        if (entityById.isPresent()) {
            ResponseEntity<?> controlFieldsEmpty = controlFieldsEmpty(entity);
            if (controlFieldsEmpty != null) {
                return controlFieldsEmpty;
            }
        }
        entity.setImageProfile(image);
        try {
             foodRepository.save(mapper.mapDtoFood(entity));
            return new ResponseEntity<>("Food updated succesfully!",
                    HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Ups something was wrong..!",
                    HttpStatus.CONFLICT);
        }
    }
    
     @Transactional
    @Override
    public ModelFoodList findById(Long id) {
        try {
            Optional<Food> entityById = foodRepository.findById(id);
            if (entityById.isPresent()) {                
                return mapper.mapToFoodSimppleDto(entityById.get(),
                        new ModelImage(entityById.get().getImageProfile().getName_image(), 
                                url+entityById.get().getImageProfile().getId()), 
                        new ModelCategoryImage(entityById.get().getCategory_id().getId(),entityById.get().getCategory_id().getNamecategory()));
            } else {
                throw new EntityNotFoundException(ERROR_FIND_ID);
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException(ERROR_CONECTION);
        }
    }
    @Transactional
    @Override
    public void delete(Long id) throws EntityNotFoundException {
        Food food = getFood(id);
        //food.setSoftDeleted(true);
        food.setStatus(Boolean.FALSE);
        foodRepository.save(food);
    }

    private Food getFood(Long id) {
        Optional<Food> food = foodRepository.findById(id);
        //|| food.get().isSoftDeleted()
        if (!food.isPresent()) {
            throw new EntityNotFoundException(ERROR_FIND_ID);
        }
        return food.get();
    }
}
