
package com.foridea.pizzeriaideas3.dto;

import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.entities.ImageProfile;
import com.foridea.pizzeriaideas3.entities.PurchaseReport;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModelFoodAll {
  private Long id;
  private String name_food; 
  private Double price; 
  private String description;  
  private Integer discount;  
  private Category idcategory; 
  private ImageProfile imageProfile;   
  private Double status;
  private List<PurchaseReport> listReports = new ArrayList<PurchaseReport>();
}
