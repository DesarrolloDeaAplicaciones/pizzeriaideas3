package com.foridea.pizzeriaideas3.controllers.api;

import com.foridea.pizzeriaideas3.dto.CategoryResponse;
import com.foridea.pizzeriaideas3.abstraction.CategoryService;
import com.foridea.pizzeriaideas3.abstraction.FileUploadService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*") //recibo todo los origenes
@RequestMapping(path = "api/v1/category")
public class CategoryController  {

    @Autowired
    private CategoryService service;
    @Autowired
    private  FileUploadService fileUploadService;
    

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createCategory(
            @RequestPart(value = "image", required = false) MultipartFile image,
            @RequestPart(value = "category", required = true) CategoryResponse category)
            throws URISyntaxException {
 
        ResponseEntity<?> response = service.addCategory(category, fileUploadService.uploadImageProfileToDB(image));
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

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,
            @RequestPart(value = "image", required = false) MultipartFile image,
            @RequestPart(value = "category", required = true) CategoryResponse entity)
            throws URISyntaxException {

        ResponseEntity<?> response = service.update(id, entity, fileUploadService.uploadImageProfileToDB(image));
        return new ResponseEntity<>(response.getBody(), response.getStatusCode());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws EntityNotFoundException {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    @GetMapping("/active")
    public ResponseEntity<?> findAllActive() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listCategoryActive());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/inactive")
    public ResponseEntity<?> findAllInactive(@RequestParam(value = 
    "isDeleted", required = false, defaultValue = "false")boolean 
     isDeleted ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.listCategoryInactive());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
