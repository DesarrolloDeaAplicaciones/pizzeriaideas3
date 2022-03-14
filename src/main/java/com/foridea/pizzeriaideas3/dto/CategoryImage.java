
package com.foridea.pizzeriaideas3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryImage {
    private Long id;
    private String namecategory;  
    private String description;
    private Boolean status;  
    private ModelImage image;
}
