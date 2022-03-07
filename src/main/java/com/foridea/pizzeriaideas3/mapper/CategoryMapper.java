package com.foridea.pizzeriaideas3.mapper;


import com.foridea.pizzeriaideas3.dto.CategoryImage;
import com.foridea.pizzeriaideas3.dto.CategoryResponse;
import com.foridea.pizzeriaideas3.dto.ModelImage;
import com.foridea.pizzeriaideas3.entities.Category;
import org.springframework.stereotype.Component;


@Component
public class CategoryMapper {
    
    //uso
    public Category categoryDtoEntity(CategoryResponse request)  {
        Category category = new Category();
        category.setId(request.getId());
        category.setName(request.getName().toUpperCase());
        category.setDescription(request.getDescription());
        category.setStatus(Boolean.TRUE);       
        category.setImageProfile(request.getImageProfile());
        return category;
    }

    public CategoryResponse categoryEntityDto(Category category) {
       //uso
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        categoryResponse.setDescription(category.getDescription());
        categoryResponse.setStatus(category.getStatus());         
        
        categoryResponse.setImageProfile(category.getImageProfile());        
        return categoryResponse;
    }
  
    //uso
    public CategoryImage categoryImageEntityDto(Category category){
            String url="http://localhost:8080/api/v1/images/profileimage/";
            CategoryImage categoryImageRespose=new CategoryImage();
            categoryImageRespose.setId(category.getId());
            categoryImageRespose.setDescription(category.getDescription());
            categoryImageRespose.setName(category.getName());
            categoryImageRespose.setStatus(category.getStatus());      
           
            ModelImage modelImage=new ModelImage();
            modelImage.setImageName(category.getImageProfile().getName());           
            modelImage.setUrlImage(url+category.getImageProfile().getId());//      
            categoryImageRespose.setImage(modelImage);
        return categoryImageRespose;
    }
 

}
