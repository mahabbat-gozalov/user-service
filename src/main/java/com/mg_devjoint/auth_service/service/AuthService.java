package com.mg_devjoint.auth_service.service;


import com.mg_devjoint.auth_service.dto.request.*;
import com.mg_devjoint.auth_service.dto.response.*;

public interface AuthService {
    LoginResponse login(LoginRequest request);

    RefreshResponse refresh(RefreshRequest request);

    CreateUserResponse createUser(CreateUserRequest request);
}
