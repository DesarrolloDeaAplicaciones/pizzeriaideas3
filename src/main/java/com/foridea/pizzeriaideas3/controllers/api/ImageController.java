package com.foridea.pizzeriaideas3.controllers.api;

import com.foridea.pizzeriaideas3.entities.ImageProfile;
import com.foridea.pizzeriaideas3.repositories.ImageRepository;
import com.foridea.pizzeriaideas3.abstraction.ImageService;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/images")
public class ImageController {
    private final ImageService imageService;
    private final ImageRepository imageRepository;

    @GetMapping("/profileimage/{id}")
    public ResponseEntity<Resource> findImageProfileById(@PathVariable(name = "id") String id){
        ImageProfile image = (ImageProfile) imageRepository.findById(id).get();
        return imageService.generateImage(image);
    }


}
