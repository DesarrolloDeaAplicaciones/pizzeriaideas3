package com.foridea.pizzeriaideas3.controllers;

import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") //cualquier origen
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("") //ruta list todo
    public ResponseEntity<?> listAll() {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @GetMapping("active") //ruta list todo
    public ResponseEntity<?> listAllActive() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAllActive());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @GetMapping("inactive") //ruta list todo
    public ResponseEntity<?> listAllInactive() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAllInactive());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @GetMapping("/{id}") //ruta list todo
    public ResponseEntity<?> listCategoryId(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @PostMapping("") //ruta list todo
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.save(category));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }

    @PutMapping("/{id}") //ruta list todo
    public ResponseEntity<?> updateCategory(@PathVariable String id, @RequestBody Category updateCategory) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(categoryService.update(id, updateCategory));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    @DeleteMapping("/{id}") //ruta list todo
    public ResponseEntity<?> deleteCategory(@PathVariable String id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(categoryService.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e);
        }
    }
}
