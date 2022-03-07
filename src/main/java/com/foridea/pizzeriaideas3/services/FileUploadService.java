package com.foridea.pizzeriaideas3.services;

import com.foridea.pizzeriaideas3.entities.ImageProfile;

import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    public ImageProfile uploadImageProfileToDB(MultipartFile image);  
  
   
}
