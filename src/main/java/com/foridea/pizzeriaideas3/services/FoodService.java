package com.foridea.pizzeriaideas3.services;


import com.foridea.pizzeriaideas3.dto.ModelFood;
import com.foridea.pizzeriaideas3.dto.ModelFoodList;
import com.foridea.pizzeriaideas3.entities.ImageProfile;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface FoodService {

    public ResponseEntity<?> addFood(ModelFood food, ImageProfile profileImage);
    public List<ModelFoodList> findAll();
    public ResponseEntity<?> update(Long id, ModelFood food, ImageProfile profileImage);
    public ModelFoodList findById(Long id);

//    public List<CategoryImage> listCategoryActive();
//
//    public List<CategoryImage> listCategoryInactive();
//
    void delete(Long id);
}
