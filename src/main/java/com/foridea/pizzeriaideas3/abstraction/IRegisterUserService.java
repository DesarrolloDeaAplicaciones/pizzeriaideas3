package com.foridea.pizzeriaideas3.abstraction;

import com.foridea.pizzeriaideas3.dto.UserRegisterRequest;
import com.foridea.pizzeriaideas3.dto.UserRegisterResponse;

public interface IRegisterUserService {

    UserRegisterResponse register(UserRegisterRequest request);
}
