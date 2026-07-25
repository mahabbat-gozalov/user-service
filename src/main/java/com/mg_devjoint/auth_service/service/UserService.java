package com.mg_devjoint.auth_service.service;

import com.mg_devjoint.auth_service.dto.response.CreateUserResponse;
import com.mg_devjoint.auth_service.model.User;

import java.util.UUID;

public interface UserService {

    User findUserByEmail(String email);

    User findUserById(UUID userId);

    CreateUserResponse createUser(User user);

}
