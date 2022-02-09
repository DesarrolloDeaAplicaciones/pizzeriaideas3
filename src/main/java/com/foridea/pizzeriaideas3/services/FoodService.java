
package com.foridea.pizzeriaideas3.services;
import com.foridea.pizzeriaideas3.entities.Food;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class FoodService {
    @Transactional
    public void modifyFood()  {
        //modificar comida
        //buscar comida por id modificar datos     

    }

    @Transactional
    public void unsubscribeFood() {
        //dar de baja comida
        //buscar por id dar de baja

    }

    @Transactional
    public void dischargeFood() {
        //dar de alta comida
        //buscar por id dar de alta
       
    }

    @Transactional
    public List<Food> listFood() {
        //lista todos devuelve lista de comida
        return null;

     
    }

    public void validateData()  {
       //validar datos que ingresan
    } 
}
