
package com.foridea.pizzeriaideas3.dto;

import com.foridea.pizzeriaideas3.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelFoodList {
  private Long id;  
  private String name_food; 
  private Double price; 
  private String description;  
  private Integer discount;   
  private ModelImage imageProfile;
  private Category category_id;
}
