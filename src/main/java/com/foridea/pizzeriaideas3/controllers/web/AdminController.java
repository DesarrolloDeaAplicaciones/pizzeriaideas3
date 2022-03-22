
package com.foridea.pizzeriaideas3.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

  @RequestMapping("/admin")
  public String admin(Model modelo) {    
    modelo.addAttribute("mensaje","hola desde admin");
    return "admin/layout";
  }
  
}
