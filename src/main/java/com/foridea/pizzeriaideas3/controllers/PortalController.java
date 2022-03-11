
package com.foridea.pizzeriaideas3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PortalController {
  @RequestMapping("/")
  public String hola(Model modelo) {
    
    
    modelo.addAttribute("mensaje","hola desde thymeleaf");
    return "index";
  }
}
