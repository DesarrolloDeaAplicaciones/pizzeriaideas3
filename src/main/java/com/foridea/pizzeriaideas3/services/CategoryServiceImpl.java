package com.foridea.pizzeriaideas3.services;


import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.repositories.BaseRepository;
import com.foridea.pizzeriaideas3.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//implementacion de servicios Categoria
@Service
public class CategoryServiceImpl extends BaseServiceImpl<Category, String> implements CategoryService{
    @Autowired 
    private  CategoryRepository categoryRepository;  
    public  CategoryServiceImpl(BaseRepository<Category,String> baseRepository){
        super(baseRepository);
    }
    
}
