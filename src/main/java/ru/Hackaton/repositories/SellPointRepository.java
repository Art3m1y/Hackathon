package ru.Hackaton.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.Hackaton.models.SellPoint;

@Repository
public interface SellPointRepository extends JpaRepository<SellPoint, Long> {
}
