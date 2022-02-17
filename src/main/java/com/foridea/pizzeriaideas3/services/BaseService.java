
package com.foridea.pizzeriaideas3.services;

import com.foridea.pizzeriaideas3.entities.Base;
import java.io.Serializable;
import java.util.List;


public interface BaseService <E extends Base , ID extends Serializable> {
    public List<E> findAll() throws Exception;
//    public List<E> findAllActive() throws Exception;
//    public List<E> findAllInactive() throws Exception;
    public E findById(ID id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(ID id, E entity) throws Exception;
    public boolean delete(ID id) throws Exception;
    
}
