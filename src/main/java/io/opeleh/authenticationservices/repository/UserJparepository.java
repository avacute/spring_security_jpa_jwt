package io.opeleh.authenticationservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.opeleh.authenticationservices.model.User;

public interface UserJparepository extends JpaRepository<User, Integer>{

    // Find user from database by username
    Optional <User> findByUsername(String username);

}