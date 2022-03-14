
package com.foridea.pizzeriaideas3.controllers;

import com.foridea.pizzeriaideas3.dto.ModelFood;
import com.foridea.pizzeriaideas3.services.FileUploadService;
import com.foridea.pizzeriaideas3.services.FoodService;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@CrossOrigin( origins = "*") //recibo todo los origenes
@RequestMapping(path = "api/v1/food")
public class FoodController {
    
    @Autowired
    private  FileUploadService fileUploadService; 
    @Autowired
    private FoodService service;
    
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createFood(
            @RequestPart(value = "image", required = false) MultipartFile image,
            @RequestPart(value = "food", required = true) ModelFood food)
            throws URISyntaxException { 
        ResponseEntity<?> response = service.addFood(food, fileUploadService.uploadImageProfileToDB(image));
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
	
}
