package ru.Hackaton.services;

import ru.Hackaton.models.Order;
import ru.Hackaton.models.SellPoint;

import java.util.List;
import java.util.Optional;

public interface SellPointService {
    List<SellPoint> findAll();
    Optional<SellPoint> findById(long id);
    SellPoint save(SellPoint newSellPoint);
    SellPoint upgrade(SellPoint sellPointToUpgrade);
}
