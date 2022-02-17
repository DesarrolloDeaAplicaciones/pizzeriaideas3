
package com.foridea.pizzeriaideas3.controllers;

import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.services.CategoryServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin( origins = "*") //recibo todo los origenes
@RequestMapping(path = "api/category")
public class CategoryController extends BaseControllerImpl<Category, CategoryServiceImpl>{
    
}
