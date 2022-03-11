
package com.foridea.pizzeriaideas3.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
  private String name_food; 
  @Column(name = "price")
  private Double price;   
  @Column(name = "description")
  private String description;
  @Column(name = "discount")
  private Integer discount;  
  @OneToOne()
  private Category category;
  @OneToOne
  @JoinColumn(name="imageProfile")
  private ImageProfile imageProfile;  

  @OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
  @JoinColumn(name="listReports")
  private List<PurchaseReport> listReports = new ArrayList<PurchaseReport>();
}
