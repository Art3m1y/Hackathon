package ru.Hackaton.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Hackaton.dtos.SellPointDto;
import ru.Hackaton.dtos.mappers.CreditAgentMapper;
import ru.Hackaton.dtos.mappers.SellPointMapper;
import ru.Hackaton.services.SellPointService;

@RestController
@RequestMapping("/api/point")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class SellPointController {

    SellPointService sellPointService;
    SellPointMapper sellPointMapper;
    CreditAgentMapper creditAgentMapper;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(sellPointMapper.mapToSellPointDtoList(sellPointService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody SellPointDto sellPointDto) {
        return ResponseEntity.ok(sellPointMapper.mapToSellPointDto(sellPointService.save(
                sellPointMapper.mapToSellPoint(sellPointDto))));
    }

    @PutMapping()
    public ResponseEntity<?> upgrade(@RequestBody SellPointDto sellPointDto) {
        return ResponseEntity.ok(sellPointMapper.mapToSellPointDto(sellPointService.upgrade(
                sellPointMapper.mapToSellPoint(sellPointDto))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        return ResponseEntity.ok(sellPointMapper.mapToSellPointDto(sellPointService.findById(id)));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        sellPointService.delete(id);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/agents")
    public ResponseEntity<?> getAgents(@PathVariable long id) {
        return ResponseEntity.ok(creditAgentMapper.mapToCreditAgentDtoList(
                sellPointService.getAgents(id)));
    }

}
