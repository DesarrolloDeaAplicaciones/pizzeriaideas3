
package com.foridea.pizzeriaideas3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Food {
 @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid",strategy = "uuid2")
  private String id; 
  @Column(unique = true, nullable = false)
  private String name; 
  private Double price; 
  private Integer discount; 
  private boolean condition;
  @OneToOne()
  private Category category;
    //agregar si ves que necesitamos algo mas
}
