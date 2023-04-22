package ru.Hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Hackaton.models.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
