
package com.foridea.pizzeriaideas3.mapper;

import com.foridea.pizzeriaideas3.dto.CategoryImage;
import com.foridea.pizzeriaideas3.dto.CategoryResponse;
import com.foridea.pizzeriaideas3.dto.ModelFood;
import com.foridea.pizzeriaideas3.dto.ModelImage;
import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.entities.Food;
import org.modelmapper.ModelMapper;


public class GenericFoodMapper {
    //Singleton 
    private final ModelMapper mapper=new ModelMapper();
    private static GenericFoodMapper instance;

    private GenericFoodMapper() {
    }
    
    public static GenericFoodMapper singleInstance(){
    return (instance==null ? new GenericFoodMapper(): instance);
    }
    //method mix list
     public ModelFood mapToFoodSimppleDto(Food entity, ModelImage image){  
         ModelFood mixDto=new  ModelFood();
         mapper.map(image,mixDto);
         mapper.map(entity,mixDto);
        return mixDto;
    }
     //method entity add & byId
     public Food mapDtoFood(ModelFood entity){    
         entity.setName_food(entity.getName_food().toUpperCase());
        return mapper.map(entity, Food.class);
     }
     
}
