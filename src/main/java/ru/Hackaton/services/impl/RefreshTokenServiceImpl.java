package ru.Hackaton.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.models.RefreshToken;
import ru.Hackaton.repositories.RefreshTokenRepository;
import ru.Hackaton.services.RefreshTokenService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    @Override
    public void saveRefreshToken(RefreshToken refreshToken) {
        refreshTokenRepository.save(refreshToken);
    }

    @Override
    public void updateRefreshToken(CreditAgent creditAgentAuthenticated, RefreshToken refreshTokenUpdated) {
        Optional<RefreshToken> refreshTokenOptional = refreshTokenRepository.findByCreditAgent(creditAgentAuthenticated);

        if (refreshTokenOptional.isPresent()) {
            RefreshToken refreshToken = refreshTokenOptional.get();

            refreshToken.setCreditAgent(creditAgentAuthenticated);

            refreshTokenRepository.save(refreshToken);
        } else {
            refreshTokenRepository.save(refreshTokenUpdated);
        }
    }
}