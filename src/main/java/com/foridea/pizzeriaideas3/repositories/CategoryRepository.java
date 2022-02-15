
package com.foridea.pizzeriaideas3.repositories;

import com.foridea.pizzeriaideas3.entities.Category;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<Category, String> {
     @Query("SELECT c from Category c WHERE c.status=true")
     public List<Category> listCategoryActive();
     @Query("SELECT c from Category c WHERE c.status=false")
     public List<Category> listCategoryInactive();
//    @Query("SELECT a from Category a WHERE a.id= :id")
//    public Category searchCategoryId(@Param("id") String id);
    
}
