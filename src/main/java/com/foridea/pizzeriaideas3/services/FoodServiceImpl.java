
package com.foridea.pizzeriaideas3.services;

import com.foridea.pizzeriaideas3.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl implements FoodService{
  @Autowired 
    private  FoodRepository foodRepository;  
   
}
