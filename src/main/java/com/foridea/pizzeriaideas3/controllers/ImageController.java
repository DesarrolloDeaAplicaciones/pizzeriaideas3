package com.foridea.pizzeriaideas3.controllers;

import com.foridea.pizzeriaideas3.services.ImageService;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/images")
public class ImageController {
//    private final ImageService imageService;
 //   private final ImageRepository imageRepository;

//    @GetMapping("/profileimage/{id}")
//    public ResponseEntity<Resource> findImageProfileById(@PathVariable(name = "id") String id){
//        ImageProfile image = (ImageProfile) imageRepository.findById(id);
//        return imageService.generateImage(image);
//    }


}
