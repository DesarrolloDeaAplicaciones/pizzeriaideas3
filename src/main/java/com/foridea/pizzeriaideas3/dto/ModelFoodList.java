
package com.foridea.pizzeriaideas3.dto;

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
  private ModelImage image;
  private ModelCategoryImage category;
}
