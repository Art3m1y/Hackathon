package ru.Hackaton.services;

import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.models.Order;
import ru.Hackaton.models.SellPoint;

import java.util.List;
import java.util.Optional;

public interface SellPointService {
    List<SellPoint> findAll();
    SellPoint findById(String id);
    SellPoint save(SellPoint newSellPoint);
    SellPoint upgrade(SellPoint sellPointToUpgrade);
    void delete(String id);
    List<CreditAgent> getAgents(long id);
}
