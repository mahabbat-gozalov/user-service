package com.mg_devjoint.library_management.dto.response;

import com.mg_devjoint.library_management.model.enums.UserRole;

import java.util.UUID;

public record CreateUserResponse(
        UUID userId,
        String email,
        String name,
        String surname,
        String phoneNumber,
        String role
) {
}
