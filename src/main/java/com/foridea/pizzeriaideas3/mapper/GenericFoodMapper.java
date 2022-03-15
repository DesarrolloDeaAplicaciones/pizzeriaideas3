
package com.foridea.pizzeriaideas3.mapper;

import com.foridea.pizzeriaideas3.dto.CategoryImage;
import com.foridea.pizzeriaideas3.dto.CategoryResponse;
import com.foridea.pizzeriaideas3.dto.ModelCategoryImage;
import com.foridea.pizzeriaideas3.dto.ModelFood;
import com.foridea.pizzeriaideas3.dto.ModelFoodList;
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
     public ModelFoodList mapToFoodSimppleDto(Food entity, ModelImage image, ModelCategoryImage category){  
         ModelFoodList mixDto=new  ModelFoodList();
        // System.out.println(image.getUrlImage());
         mapper.map(entity,mixDto);
         mapper.map(image,mixDto);
         mapper.map(category,mixDto);
        return mixDto;
    }
     //method entity add & byId
     public Food mapDtoFood(ModelFood entity){    
         entity.setName_food(entity.getName_food().toUpperCase());
        return mapper.map(entity, Food.class);
     }
     
}
