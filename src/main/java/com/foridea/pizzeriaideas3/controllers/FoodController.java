
package com.foridea.pizzeriaideas3.controllers;

import com.foridea.pizzeriaideas3.entities.Food;
import com.foridea.pizzeriaideas3.exceptions.ErrorService;
import com.foridea.pizzeriaideas3.services.FoodService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/food")
public class FoodController {
   
	@Autowired
	private FoodService foodService;
	
	@GetMapping("/list") //ruta list todo
	public List list(ModelMap modelo) throws ErrorService {
		List<Food> all = foodService.listFood();				       
		return all;
	}
	
	@GetMapping("/add-food")//ruta a crar comida
	public String formAddFood() {
		return null;
	}
	
	@PostMapping("/add") //post al crar comida
	public String addFood(ModelMap modelo,@RequestParam String name ) {
	           return null;
	}
	
	@GetMapping("/unsubscribefood/{id}")
	public String unsubscribeFood( @PathVariable String id) {
	  return null;
		
	}
	
	@GetMapping("/toregister/{id}")
	public String toRegister(@PathVariable String id) {		
		return null;
	} 
}
