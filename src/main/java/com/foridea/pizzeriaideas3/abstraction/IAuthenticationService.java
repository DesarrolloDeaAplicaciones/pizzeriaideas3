package com.foridea.pizzeriaideas3.abstraction;

import com.foridea.pizzeriaideas3.dto.UserAuthenticatedRequest;
import com.foridea.pizzeriaideas3.dto.UserAuthenticatedResponse;

public interface IAuthenticationService {
    UserAuthenticatedResponse authentication(UserAuthenticatedRequest request);
}
