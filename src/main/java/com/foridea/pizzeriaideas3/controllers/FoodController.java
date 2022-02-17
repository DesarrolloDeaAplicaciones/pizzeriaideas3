
package com.foridea.pizzeriaideas3.controllers;

import com.foridea.pizzeriaideas3.entities.Food;
import com.foridea.pizzeriaideas3.services.FoodServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin( origins = "*") //recibo todo los origenes
@RequestMapping(path = "api/food")
public class FoodController extends BaseControllerImpl<Food, FoodServiceImpl> {
   
	
}
