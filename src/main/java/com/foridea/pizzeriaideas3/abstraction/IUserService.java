package com.foridea.pizzeriaideas3.abstraction;


import com.foridea.pizzeriaideas3.dto.ClientResponse;
import com.foridea.pizzeriaideas3.dto.UserRegisterRequest;
import com.foridea.pizzeriaideas3.dto.UserUpdateResponse;
import com.foridea.pizzeriaideas3.entities.User;
import javassist.NotFoundException;

import javax.persistence.EntityNotFoundException;

public interface IUserService {
    User getInfoUser() throws NotFoundException;

    void delete(Long id)throws EntityNotFoundException;

    UserUpdateResponse update(Long id, UserRegisterRequest request)throws NotFoundException;


    ClientResponse getById(Long id);
}
