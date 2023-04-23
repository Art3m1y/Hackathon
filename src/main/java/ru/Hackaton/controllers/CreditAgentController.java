package ru.Hackaton.controllers;

import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Hackaton.dtos.CreditAgentDto;
import ru.Hackaton.dtos.CreditAgentRegisterDto;
import ru.Hackaton.dtos.mappers.CreditAgentMapper;
import ru.Hackaton.dtos.mappers.SellPointMapper;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.services.CreditAgentService;
import ru.Hackaton.validators.UsernameValidator;

import static ru.Hackaton.controllers.Validation.validateRequestBody;

@RestController
@RequestMapping("/api/agent")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CreditAgentController {

    CreditAgentService creditAgentService;
    CreditAgentMapper creditAgentMapper;
    SellPointMapper sellPointMapper;
    UsernameValidator usernameValidator;

    @GetMapping()
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(creditAgentMapper.mapToCreditAgentDtoList(creditAgentService.findAll()));
    }

    @PostMapping()
    public ResponseEntity<?> register(@Valid @RequestBody CreditAgentRegisterDto creditAgentRegisterDto, BindingResult bindingResult) {
        CreditAgent creditAgent = creditAgentMapper.mapToCreditAgent(creditAgentRegisterDto);

        usernameValidator.validate(creditAgent, bindingResult);

        validateRequestBody(bindingResult);

        return ResponseEntity.ok(creditAgentService.registerCreditAgent(creditAgent));
    }

    @PutMapping()
    public ResponseEntity<?> upgrade(@Valid @RequestBody CreditAgentDto creditAgentDto, BindingResult bindingResult) {
        validateRequestBody(bindingResult);

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
