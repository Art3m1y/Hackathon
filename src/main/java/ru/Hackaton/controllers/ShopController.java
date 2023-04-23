package ru.Hackaton.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Hackaton.dtos.ShopDto;
import ru.Hackaton.dtos.mappers.ShopMapper;
import ru.Hackaton.services.ShopService;

@RestController
@RequestMapping("/api/shop")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ShopController {

    ShopService shopService;
    ShopMapper shopMapper;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(shopMapper.mapToShopDtoList(shopService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> create(ShopDto newShopDto) {
        return ResponseEntity.ok(shopMapper.mapToShopDto(shopService.save(shopMapper.mapToShop(newShopDto))));
    }

    @PutMapping()
    public ResponseEntity<?> upgrade(@RequestBody ShopDto shopDto) {
        return ResponseEntity.ok(shopMapper.mapToShopDto(shopService.upgrade(shopMapper.mapToShop(shopDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(shopMapper.mapToShopDto(shopService.findById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        shopService.delete(id);

        return ResponseEntity.ok().build();
    }
}
