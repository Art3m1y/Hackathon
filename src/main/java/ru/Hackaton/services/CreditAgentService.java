package ru.Hackaton.services;

import ru.Hackaton.models.CreditAgent;

import java.util.List;
import java.util.Optional;

public interface CreditAgentService {
    List<CreditAgent> findAll();
    CreditAgent findByLogin(String login);
    CreditAgent save(CreditAgent newCreditAgent);
    CreditAgent upgrade(CreditAgent creditAgentToUpdate);
    void delete(String login);

}
