
package com.foridea.pizzeriaideas3.mapper;

import com.foridea.pizzeriaideas3.dto.CategoryImage;
import com.foridea.pizzeriaideas3.dto.CategoryResponse;
import com.foridea.pizzeriaideas3.dto.ModelImage;
import com.foridea.pizzeriaideas3.entities.Category;
import org.modelmapper.ModelMapper;


public class GenericModelMapper {
    //Singleton 
    private final ModelMapper mapper=new ModelMapper();
    private static GenericModelMapper instance;

    private GenericModelMapper() {
    }
    
    public static GenericModelMapper singleInstance(){
    return (instance==null ? new GenericModelMapper(): instance);
    }
    //method mix
     public CategoryImage mapToCategorySimppleDto(Category entity, ModelImage image){  
         CategoryImage mixDto=new  CategoryImage();
         mapper.map(image,mixDto);
         mapper.map(entity,mixDto);
        return mixDto;
    }
     //method entity
     public Category mapDtoCategory(CategoryResponse entity){    
         entity.setNamecategory(entity.getNamecategory().toUpperCase());
        return mapper.map(entity, Category.class);
     }
     
}
