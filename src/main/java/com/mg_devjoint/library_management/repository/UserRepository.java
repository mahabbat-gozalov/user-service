package com.mg_devjoint.library_management.repository;

import com.mg_devjoint.library_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.OpAnd;

import java.util.*;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmail(String email);
}
