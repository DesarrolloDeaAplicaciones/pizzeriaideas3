
package com.foridea.pizzeriaideas3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Category {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;   
    @Column(unique = true, nullable = false) //Obligatory field
    private String name;
    private Boolean condition; //default true
    
}
