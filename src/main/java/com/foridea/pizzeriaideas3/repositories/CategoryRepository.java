
package com.foridea.pizzeriaideas3.repositories;

import com.foridea.pizzeriaideas3.entities.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
    @Query("SELECT c from Category c")
    public List<Category> listCategory();
    @Query("SELECT a from Category a WHERE a.id= :id")
    public Category searchCategoryId(@Param("id") String id);
    
}
