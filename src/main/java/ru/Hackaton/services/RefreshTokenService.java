package ru.Hackaton.services;

import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.models.RefreshToken;

public interface RefreshTokenService {
    void saveRefreshToken(RefreshToken refreshToken);
    void updateRefreshToken(CreditAgent creditAgentAuthenticated, RefreshToken refreshTokenUpdated);
}
