package ru.Hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Hackaton.models.CreditAgent;

@Repository
public interface CreditAgentRepository extends JpaRepository<CreditAgent, String> {
}
