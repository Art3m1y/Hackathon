package ru.Hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Hackaton.models.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, String> {
}
