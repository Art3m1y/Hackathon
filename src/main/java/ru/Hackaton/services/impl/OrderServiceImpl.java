package ru.Hackaton.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.Hackaton.models.Order;
import ru.Hackaton.repositories.OrderRepository;
import ru.Hackaton.services.OrderService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(long id) {
        return orderRepository.findById(id).orElseThrow(()->new RuntimeException("Не существует заказа с таким id"));
    }

    @Override
    public Order save(Order newOrder) {
        return orderRepository.save(newOrder);
    }

    @Override
    public Order upgrade(Order orderToUpgrade) {

        Optional<Order> order = orderRepository.findById(orderToUpgrade.getId());

        if(order.isPresent()) {
            return orderRepository.save(orderToUpgrade);
        } else {
            throw new RuntimeException("Не существует заказа с таким id");
        }
    }

    @Override
    public void delete(long id) {
        orderRepository.deleteById(id);
    }
}
