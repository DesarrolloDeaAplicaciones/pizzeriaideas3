package com.foridea.pizzeriaideas3.services;


import com.foridea.pizzeriaideas3.entities.Category;
import com.foridea.pizzeriaideas3.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryService implements BaseService<Category>{
    @Autowired 
    private  CategoryRepository categoryRepository;
    
    @Override
    @Transactional
    public List<Category> findAll() throws Exception {
        try {
            List<Category> categories=categoryRepository.findAll();
            return categories;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public List<Category> findAllActive() throws Exception {
        try {
            List<Category> categories=categoryRepository.listCategoryActive();
            return categories;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public List<Category> findAllInactive() throws Exception {
        try {
            List<Category> categories=categoryRepository.listCategoryInactive();
            return categories;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Category findById(String id) throws Exception {
        try {
            Optional<Category> categoryForId=categoryRepository.findById(id);
            return categoryForId.get();
            
        } catch (Exception e) {
             throw new Exception(e.getMessage());

        }
           }

    @Override
    @Transactional
    public Category save(Category category) throws Exception {
        try {
            category=categoryRepository.save(category);
            return category;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Category update(String id, Category updateCategory) throws Exception {
        try {
            Optional<Category> categoryById=categoryRepository.findById(id); //Buscar y si existe
            Category category= categoryById.get();//creo categoria
            category=categoryRepository.save(updateCategory); //la salvo
            return category;
        } catch (Exception e) {
             throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(String id) throws Exception {
         try {
             if (categoryRepository.existsById(id)){
                  Optional<Category> categoryById=categoryRepository.findById(id);
                  Category category= categoryById.get();
                  category.setStatus(Boolean.FALSE);
                  category=categoryRepository.save(category); 
                   return true;
             }else{
             throw new Exception();
             }           
        } catch (Exception e) {
             throw new Exception(e.getMessage());
        }
    }

     
}
