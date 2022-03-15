
package com.foridea.pizzeriaideas3.controllers;

import com.foridea.pizzeriaideas3.dto.CategoryResponse;
import com.foridea.pizzeriaideas3.dto.ModelFood;
import com.foridea.pizzeriaideas3.services.FileUploadService;
import com.foridea.pizzeriaideas3.services.FoodService;
import java.net.URISyntaxException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
   @GetMapping("")
    public ResponseEntity<?> findAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
     @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
            @RequestPart(value = "image", required = false) MultipartFile image,
            @RequestPart(value = "food", required = true) ModelFood entity)
            throws URISyntaxException {

        ResponseEntity<?> response = service.update(id, entity, fileUploadService.uploadImageProfileToDB(image));
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }
    
      @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    
     @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws EntityNotFoundException {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
