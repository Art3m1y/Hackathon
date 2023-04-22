package ru.Hackaton.services;

import ru.Hackaton.models.RefreshToken;
import ru.Hackaton.models.User;

public interface RefreshTokenService {
    void saveRefreshToken(RefreshToken refreshToken);

    void updateRefreshToken(User userAuthenticated, RefreshToken refreshTokenUpdated);
}
