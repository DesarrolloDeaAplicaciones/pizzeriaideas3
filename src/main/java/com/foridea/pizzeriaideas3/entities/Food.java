
package com.foridea.pizzeriaideas3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.GenericGenerator;

@Entity 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {

  @Id 
  @GeneratedValue(generator = "uuid")  
  @GenericGenerator(name = "uuid",strategy = "uuid2")
  private String id; 
  @Column(unique = true, nullable = false)
  private String name; 
  private Double price; 
  private String description;
  private Integer discount;  
  private boolean status;
  @OneToOne()
  private Category category;
    //agregar si ves que necesitamos algo mas
}
