package ru.Hackaton.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.Hackaton.models.RefreshToken;
import ru.Hackaton.models.User;
import ru.Hackaton.repositories.RefreshTokenRepository;

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
    public void updateRefreshToken(User userAuthenticated, RefreshToken refreshTokenUpdated) {
        Optional<RefreshToken> refreshTokenOptional = refreshTokenRepository.findByUserId(userAuthenticated.getId());

        if (refreshTokenOptional.isPresent()) {
            RefreshToken refreshToken = refreshTokenOptional.get();

            refreshToken.setUser(userAuthenticated);

            refreshTokenRepository.save(refreshToken);
        } else {
            refreshTokenRepository.save(refreshTokenUpdated);
        }
    }
}
