package com.mg_devjoint.auth_service.repository;

import com.mg_devjoint.auth_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmail(String email);

    boolean existsByEmail(String email);
}
