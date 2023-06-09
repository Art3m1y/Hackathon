package ru.Hackaton.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.Hackaton.models.SellPoint;
import ru.Hackaton.repositories.SellPointRepository;
import ru.Hackaton.services.SellPointService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SellPointServiceImpl implements SellPointService {

    SellPointRepository sellPointRepository;

    @Override
    public List<SellPoint> findAll() {
        return sellPointRepository.findAll();
    }

    @Override
    public SellPoint findById(long id) {
        return sellPointRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Не существует троговой точки с таким id"));
    }

    @Override
    public SellPoint save(SellPoint newSellPoint) {
        return sellPointRepository.save(newSellPoint);
    }

    @Override
    public SellPoint upgrade(SellPoint sellPointToUpgrade) {
        Optional<SellPoint> sellPoint = sellPointRepository.findById(sellPointToUpgrade.getId());

        if(sellPoint.isPresent()) {
            return sellPointRepository.save(sellPointToUpgrade);
        } else {
            throw new NullPointerException("Can't save null");
        }
    }

    @Override
    public void delete(long id) {
        sellPointRepository.deleteById(id);
    }
}
