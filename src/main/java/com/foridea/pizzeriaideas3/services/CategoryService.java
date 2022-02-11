package com.foridea.pizzeriaideas3.services;

import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.exceptions.ErrorService;
import com.foridea.pizzeriaideas3.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void modifyCategory()  {
        //modificar categoria
        //buscar Autor por id modificar datos     

    }

    @Transactional
    public void unsubscribeCategory() {
        //dar de baja categoria
        //buscar por id dar de baja

    }

    @Transactional
    public void dischargeCategory() {
        //dar de alta categoria
        //buscar por id dar de alta
       
    }

    @Transactional
    public List<Category> listCategories() throws ErrorService {
      List<Category> categories = categoryRepository.findAll() ;
            return categories;       
    }
    
    public void validateData(String name) throws ErrorService {
        if (name == null || name.isEmpty()) {
            throw new ErrorService("Debes ingresar un nombre valido");
        }
    }
     
}
