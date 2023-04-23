package ru.Hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Hackaton.models.CreditAgent;

import java.util.Optional;

@Repository
public interface CreditAgentRepository extends JpaRepository<CreditAgent, String> {
    Optional<CreditAgent> findByUsername(String username);
    boolean existsByUsername(String username);
}
