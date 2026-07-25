package com.mg_devjoint.auth_service.service;

import com.mg_devjoint.auth_service.model.RefreshToken;

import java.util.UUID;

public interface RefreshTokenService {
    String createRefreshToken(UUID userId);

    boolean isRefreshTokenValid(RefreshToken refreshToken);

    void revokeRefreshToken(RefreshToken refreshToken);

    RefreshToken getRefreshTokenByValue(String refreshToken);

    void validateRefreshToken(RefreshToken refreshToken);
}
