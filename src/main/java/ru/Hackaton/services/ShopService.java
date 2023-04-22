package ru.Hackaton.services;

import ru.Hackaton.models.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    List<Shop> findAll();
    Shop findById(long id);
    Shop save(Shop newShop);
    Shop upgrade(Shop shopToUpgrade);
    void delete(long id);
}
