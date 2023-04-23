package ru.Hackaton.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.Hackaton.dtos.CreditAgentDto;
import ru.Hackaton.dtos.mappers.CreditAgentMapper;
import ru.Hackaton.dtos.mappers.SellPointMapper;
import ru.Hackaton.services.CreditAgentService;

@RestController
@RequestMapping("/api/agent")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CreditAgentController {

    CreditAgentService creditAgentService;
    CreditAgentMapper creditAgentMapper;
    SellPointMapper sellPointMapper;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(creditAgentMapper.mapToCreditAgentDtoList(creditAgentService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> create(@RequestBody CreditAgentDto newCreditAgentDto) {
        return ResponseEntity.ok(creditAgentMapper.mapToCreditAgentDto(creditAgentService.save(
                creditAgentMapper.mapToCreditAgent(newCreditAgentDto))));
    }

    @PutMapping()
    public ResponseEntity<?> upgrade(@RequestBody CreditAgentDto creditAgentDto) {
        return ResponseEntity.ok(creditAgentMapper.mapToCreditAgentDto(creditAgentService.upgrade(
                creditAgentMapper.mapToCreditAgent(creditAgentDto))));
    }

    @GetMapping("/{login}")
    public ResponseEntity<?> findByLogin(@PathVariable String login) {
        return ResponseEntity.ok(creditAgentMapper.mapToCreditAgentDto(
                creditAgentService.findByLogin(login)));
    }

    @DeleteMapping("/{login}")
    public ResponseEntity<?> delete(@PathVariable String login) {
        creditAgentService.delete(login);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{login}/points")
    public ResponseEntity<?> getPoints(@PathVariable String login) {
        return ResponseEntity.ok(sellPointMapper.mapToSellPointDtoList(
                creditAgentService.getPoints(login)));
    }
}
