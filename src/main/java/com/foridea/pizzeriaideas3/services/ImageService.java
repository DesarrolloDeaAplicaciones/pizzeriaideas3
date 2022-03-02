package com.foridea.pizzeriaideas3.services;


import com.foridea.pizzeriaideas3.entities.Image;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

public interface ImageService {
    ResponseEntity<Resource> generateImage(Image image);
    void deleteImageByProduct(ResponseEntity<?>  product);
}
