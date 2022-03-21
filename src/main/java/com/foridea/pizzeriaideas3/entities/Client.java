package com.foridea.pizzeriaideas3.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE Client SET soft_delete = true WHERE id=?")
@FilterDef(
        name = "deletedCategoryFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedCategoryFilter",
        condition = "deleted = :isDeleted"
)
@Entity
@PrimaryKeyJoinColumn(name = "id")
@ApiModel("Model Client")
public class Client extends User  {

    @NotNull
    @ApiModelProperty(value = "the Client name", required = true)
    private String name;

    @NotNull
    @ApiModelProperty(value = "the Client surname", required = true)
    private String surname;
   
    @ApiModelProperty(value = "the Client city", required = true)
    private String city;

    @ApiModelProperty(value = "the Client country", required = true)
    private String country;
    
    @ApiModelProperty(value = "the Client state", required = true)
    private String state;

    // Constructor para Test de cliente
    public Client(Long id, String username, String password, String email, Timestamp timestamp, boolean softDeleted, List<Role> roles,
                  String name) {
        super(id, username, password, email, timestamp, softDeleted, roles);
    }

    /*Relationsip!!!*/
//    @OneToOne
//    @JoinColumn(name = "profile_image")
//    private ImageProfile imageProfile;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "buyer", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
//    private List<Cart> cart = new ArrayList<Cart>();

//    @JsonManagedReference
//    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
//    private List<Product> product = new ArrayList<Product>();



}