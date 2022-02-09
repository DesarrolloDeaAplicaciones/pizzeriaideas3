package com.foridea.pizzeriaideas3.repositories;

import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.entities.Food;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, String>{
     @Query("SELECT c from Food c")
    public List<Food> listFood();
    @Query("SELECT a from Category a WHERE a.id= :id")
    public Category searchFoodId(@Param("id") String id);
}
