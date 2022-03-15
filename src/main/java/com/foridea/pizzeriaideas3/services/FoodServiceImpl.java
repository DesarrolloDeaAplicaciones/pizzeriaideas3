package com.foridea.pizzeriaideas3.services;

import com.foridea.pizzeriaideas3.dto.ModelFood;
import com.foridea.pizzeriaideas3.dto.ModelFoodList;
import com.foridea.pizzeriaideas3.dto.ModelImage;
import com.foridea.pizzeriaideas3.entities.Food;
import com.foridea.pizzeriaideas3.entities.ImageProfile;
import com.foridea.pizzeriaideas3.mapper.GenericFoodMapper;
import com.foridea.pizzeriaideas3.repository.FoodRepository;
import java.util.ArrayList;
import java.util.List;
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
    public List<ModelFood> findAll() {
        return listZizeFood(foodRepository.findAll());
    }

   

    public List<ModelFood> listZizeFood(List<Food> entities) {     
        
        List<ModelFood> listResponse = new ArrayList<>();
        if (entities.size() == 0) {
            throw new EntityNotFoundException(ERROR_NOT_LIST_FOOD);
        }
        for (Food entity : entities) {           
            listResponse.add(mapper.mapToFoodSimppleDto(entity, 
                    new ModelImage(entity.getImageProfile().getName_image(), url+entity.getImageProfile().getId()) ));
        }
        return listResponse;
    }

//    @Override
//    public List<ModelFoodList> findAll() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
