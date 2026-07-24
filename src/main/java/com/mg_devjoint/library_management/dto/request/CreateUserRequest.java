package com.mg_devjoint.library_management.dto.request;

import com.mg_devjoint.library_management.model.enums.UserRole;

//TODO: ADD VALIDATIONS
public record CreateUserRequest(
        String email,
        String name,
        String surname,
        String phoneNumber,
        UserRole role
) {
}
