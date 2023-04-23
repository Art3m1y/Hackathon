package ru.Hackaton.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.Hackaton.dtos.CreditAgentAuthDto;
import ru.Hackaton.dtos.CreditAgentRegisterDto;
import ru.Hackaton.dtos.mappers.CreditAgentMapper;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.services.CreditAgentService;
import ru.Hackaton.validators.UsernameValidator;

import static ru.Hackaton.controllers.Validation.validateRequestBody;

@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class AdminController {
    private final CreditAgentService creditAgentService;
    private final CreditAgentMapper creditAgentMapper;
    private final UsernameValidator usernameValidator;
    @PostMapping("/agent/register")
    public ResponseEntity<?> registerCreditAgent(@Valid @RequestBody CreditAgentRegisterDto creditAgentRegisterDto, BindingResult bindingResult) {
        CreditAgent creditAgent = creditAgentMapper.mapToCreditAgent(creditAgentRegisterDto);

        usernameValidator.validate(creditAgent, bindingResult);

        validateRequestBody(bindingResult);

        return ResponseEntity.ok(creditAgentService.registerCreditAgent(creditAgent));
    }

}
