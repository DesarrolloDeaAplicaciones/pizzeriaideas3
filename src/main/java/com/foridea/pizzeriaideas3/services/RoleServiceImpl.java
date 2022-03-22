package com.foridea.pizzeriaideas3.services;

import com.foridea.pizzeriaideas3.abstraction.IRoleService;
import com.foridea.pizzeriaideas3.entities.Role;
import com.foridea.pizzeriaideas3.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Role findBy(String name) {
        return roleRepository.findByName(name);
    }
}
