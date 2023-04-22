package ru.Hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.models.RefreshToken;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByCreditAgent(CreditAgent creditAgentAuthenticated);
}
