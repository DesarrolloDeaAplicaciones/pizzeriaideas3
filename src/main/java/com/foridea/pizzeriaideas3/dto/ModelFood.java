
package com.foridea.pizzeriaideas3.dto;

import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.entities.ImageProfile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelFood {
  private Long id;  
  private String name_food; 
  private Double price; 
  private String description;  
  private Integer discount;   
  private ImageProfile imageProfile;  
  private boolean status;
  private Category category_id;
}
