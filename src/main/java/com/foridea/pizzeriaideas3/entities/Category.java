
package com.foridea.pizzeriaideas3.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE Category SET soft_delete = true WHERE id=?")
@Where(clause = "soft_deleted = false")
@Entity
public class Category extends Base {

    @NotEmpty(message = "Nombre Obligatorio")
    @Column(name = "name", nullable = false, updatable = true, unique = true)
    private String name;

    @Column(name = "description")
    private String description;
 
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH})
    @JoinColumn(name="imageProfile")
    private ImageProfile imageProfile;
    
    @Column(name = "soft_deleted")
    private boolean softDeleted = Boolean.FALSE;    
 
    public boolean isEnabled() {
        return !this.softDeleted;
    }
}
