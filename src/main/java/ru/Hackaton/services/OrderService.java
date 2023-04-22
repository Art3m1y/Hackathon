package ru.Hackaton.services;

import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> findAll();
    Order findById(long id);
    Order save(Order newOrder);
    Order upgrade(Order orderToUpgrade);
    void delete(long id);
}
