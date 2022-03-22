package com.foridea.pizzeriaideas3.abstraction;

import com.foridea.pizzeriaideas3.entities.Role;

public interface IRoleService {
    Role findBy(String name);
}
