
package com.foridea.pizzeriaideas3.entities;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE Category SET soft_delete = true WHERE id=?")
//@Where(clause = "soft_deleted = false")
@FilterDef(
        name = "deletedCategoryFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedCategoryFilter",
        condition = "deleted = :isDeleted"
)
@Entity
public class Category extends Base {

    @NotEmpty(message = "Nombre Obligatorio")
    @Column(name = "name_category", nullable = false, updatable = true, unique = true)
    private String namecategory;

    @Column(name = "description")
    private String description;
 
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumn(name="imageProfile")
    private ImageProfile imageProfile;
    
    @OneToMany
    @JoinTable(
    name = "category_food", 
    joinColumns = @JoinColumn(name = "category_id"), 
    inverseJoinColumns = @JoinColumn(name = "food_id"))
    @Column(name = "food_id", updatable = true, nullable = true)
    private List<Food> categories = new ArrayList<Food>();
    
    @Column(name = "soft_deleted")
    private boolean softDeleted = Boolean.FALSE;    
 
    public boolean isEnabled() {
        return !this.softDeleted;
    }
}
