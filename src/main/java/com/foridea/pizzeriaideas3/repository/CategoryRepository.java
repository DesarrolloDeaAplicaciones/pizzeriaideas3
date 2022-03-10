
package com.foridea.pizzeriaideas3.repository;

import com.foridea.pizzeriaideas3.entities.Category;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
     @Query("SELECT c from Category c WHERE c.status=TRUE")
     public List<Category> listCategoryActive();
     @Query("SELECT c from Category c WHERE c.softDeleted=true")
     public List<Category> listCategoryInactive();
    

    
}
