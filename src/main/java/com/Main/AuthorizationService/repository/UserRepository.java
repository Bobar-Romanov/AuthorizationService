package com.Main.AuthorizationService.repository;

import com.Main.AuthorizationService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByLogin(String login);
    Optional<User> findByLogin(String login);

}