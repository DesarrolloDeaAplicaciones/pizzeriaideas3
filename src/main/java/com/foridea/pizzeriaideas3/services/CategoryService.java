
package com.foridea.pizzeriaideas3.services;

import com.foridea.pizzeriaideas3.dto.CategoryImage;
import com.foridea.pizzeriaideas3.dto.CategoryResponse;
import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.entities.ImageProfile;
import java.util.List;
import org.springframework.http.ResponseEntity;


public interface CategoryService{
    
     public ResponseEntity<?> addCategory(CategoryResponse category,ImageProfile profileImage );

     public List<CategoryImage> findAll();
//
//    public ResponseEntity<?> update(Long id, CategoryResponse category,ImageProfile profileImage);
//
//    public CategoryImage findById(Long id);
//    
//    public List<CategoryImage> listCategoryActive();
//    
//    public List<CategoryImage> listCategoryInactive();
//
//    void delete(Long id);
}
