package com.mg_devjoint.auth_service.service.impl;

import com.mg_devjoint.auth_service.exception.InvalidTokenException;
import com.mg_devjoint.auth_service.exception.NotFoundException;
import com.mg_devjoint.auth_service.model.RefreshToken;
import com.mg_devjoint.auth_service.model.User;
import com.mg_devjoint.auth_service.repository.RefreshTokenRepository;
import com.mg_devjoint.auth_service.service.RefreshTokenService;
import com.mg_devjoint.auth_service.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final UserService userService;

    @Value("${security.refresh-token.expiration-milliseconds}")
    private long expirationMilliseconds;

    public RefreshTokenServiceImpl(RefreshTokenRepository refreshTokenRepository, UserService userService) {
        this.refreshTokenRepository = refreshTokenRepository;
        this.userService = userService;
    }


    @Override
    public String createRefreshToken(UUID userId) {

        User user = userService.findUserById(userId);

        String refreshTokenValue = UUID.randomUUID().toString();

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime expiryDate = now.plus(Duration.ofMillis(expirationMilliseconds));

        RefreshToken refreshTokenEntity = new RefreshToken(refreshTokenValue, user, expiryDate, now, false);

        refreshTokenRepository.save(refreshTokenEntity);

        return refreshTokenValue;

    }


    @Override
    public void revokeRefreshToken(RefreshToken refreshToken) {
        refreshToken.setRevoked(true);

        refreshTokenRepository.save(refreshToken);
    }

    @Override
    public RefreshToken getRefreshTokenByValue(String refreshToken) {

        return refreshTokenRepository.findByRefreshToken(refreshToken)
                .orElseThrow(() -> new NotFoundException("Refresh token not found"));
    }

    @Override
    public boolean isRefreshTokenValid(RefreshToken refreshToken) {
        return !refreshToken.isRevoked() && !refreshToken.getExpiresAt().isBefore(LocalDateTime.now());
    }

    @Override
   public void validateRefreshToken(RefreshToken refreshToken) {
        boolean isRefreshTokenValid = isRefreshTokenValid(refreshToken);

        if (!isRefreshTokenValid) {
            throw new InvalidTokenException("Invalid refresh token");
        }
    }
}
