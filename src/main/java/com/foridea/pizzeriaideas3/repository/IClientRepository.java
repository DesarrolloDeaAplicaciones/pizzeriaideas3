package com.foridea.pizzeriaideas3.repository;


import com.foridea.pizzeriaideas3.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String username);
}
