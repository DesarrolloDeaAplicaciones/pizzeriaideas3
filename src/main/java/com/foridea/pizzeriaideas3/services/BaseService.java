
package com.foridea.pizzeriaideas3.services;

import java.util.List;


public interface BaseService <E> {
    public List<E> findAll() throws Exception;
    public List<E> findAllActive() throws Exception;
     public List<E> findAllInactive() throws Exception;
    public E findById(String id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(String id, E entity) throws Exception;
    public boolean delete(String id) throws Exception;
    
}
