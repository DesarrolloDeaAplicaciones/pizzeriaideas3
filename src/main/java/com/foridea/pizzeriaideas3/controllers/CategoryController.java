
package com.foridea.pizzeriaideas3.controllers;

import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.entities.Food;
import com.foridea.pizzeriaideas3.exceptions.ErrorService;
import com.foridea.pizzeriaideas3.services.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list") //ruta list todo
	public List list(ModelMap modelo) throws ErrorService {
		List<Category> all = categoryService.listCategories();				       
		return all;
	}
	
	@GetMapping("/add-category")//ruta a crar categoria
	public String formAddCategory() {
		return null;
	}
	
	@PostMapping("/add") //post al crar categoria
	public String addCategory(ModelMap modelo,@RequestParam String name ) {
	           return null;
	}
	
	@GetMapping("/unsubscribecategory/{id}")
	public String unsubscribeCategory( @PathVariable String id) {
	  return null;
		
	}
	
	@GetMapping("/toregister/{id}")
	public String toRegister(@PathVariable String id) {		
		return null;
	} 
}
