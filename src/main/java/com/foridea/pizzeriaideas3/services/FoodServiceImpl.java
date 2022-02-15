
package com.foridea.pizzeriaideas3.services;

import com.foridea.pizzeriaideas3.entities.Food;
import com.foridea.pizzeriaideas3.repositories.BaseRepository;
import com.foridea.pizzeriaideas3.repositories.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodServiceImpl extends BaseServiceImpl<Food, String> implements FoodService{
  @Autowired 
    private  FoodRepository foodRepository;  
    public  FoodServiceImpl(BaseRepository<Food,String> baseRepository){
        super(baseRepository);
    }
}
