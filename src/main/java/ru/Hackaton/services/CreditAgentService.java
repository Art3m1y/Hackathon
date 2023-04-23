package ru.Hackaton.services;

import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.models.Order;
import ru.Hackaton.models.SellPoint;

import java.util.List;
import java.util.Optional;

public interface CreditAgentService {
    List<CreditAgent> findAll();
    CreditAgent findByLogin(String login);
    CreditAgent upgrade(CreditAgent creditAgentToUpdate);
    void delete(String login);
    CreditAgent registerCreditAgent(CreditAgent creditAgent);
    boolean existByEmail(String username);
    List<SellPoint> getPoints(String login);
    List<Order> getOrders(String username);
}
