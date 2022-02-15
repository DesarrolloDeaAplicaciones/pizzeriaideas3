
package com.foridea.pizzeriaideas3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Category extends Base{    
   @Column(unique = true, nullable = false) //Obligatory field
    private String name;
    private String description;
  
    
}
