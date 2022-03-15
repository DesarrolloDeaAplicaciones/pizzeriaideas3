
package com.foridea.pizzeriaideas3.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;


@Entity 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food extends  Base{
  @NonNull
  @Column(unique = true, nullable = false)
  private String name_food; 
  @Column(name = "price")
  private Double price;   
  @Column(name = "description")
  private String description;
  @Column(name = "discount")
  private Integer discount;   
  @OneToOne
  @JoinColumn(name="imageProfile" )
  private ImageProfile imageProfile; 
  @OneToOne()
  @JoinColumn(name="category_id", updatable = true, nullable = true) 
  private Category category_id; 
  
  @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
  @JoinColumn(name="listReports")
  private List<PurchaseReport> listReports = new ArrayList<PurchaseReport>();
}
