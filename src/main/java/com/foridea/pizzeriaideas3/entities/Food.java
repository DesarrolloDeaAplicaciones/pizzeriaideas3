
package com.foridea.pizzeriaideas3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food extends  Base{
  
  @Column(unique = true, nullable = false)
  private String name; 
  private Double price; 
  private String description;
  private Integer discount;  
  
  @OneToOne()
  private Category category;
    //agregar si ves que necesitamos algo mas
}
