package ru.Hackaton.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.Hackaton.models.Shop;
import ru.Hackaton.repositories.ShopRepository;
import ru.Hackaton.services.ShopService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ShopServiceImpl implements ShopService {

    ShopRepository shopRepository;

    @Override
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }

    @Override
    public Optional<Shop> findById(long id) {
        return shopRepository.findById(id);
    }

    @Override
    public Shop save(Shop newShop) {
        return shopRepository.save(newShop);
    }

    @Override
    public Shop upgrade(Shop shopToUpgrade) {

        Optional<Shop> shop = shopRepository.findById(shopToUpgrade.getId());

        if(shop.isPresent()) {
            return shopRepository.save(shopToUpgrade);
        } else {
            throw new NullPointerException("Can't save null");
        }
    }
}
