package ru.Hackaton.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.Hackaton.dtos.CreditAgentAuthDto;
import ru.Hackaton.dtos.CreditAgentRegisterDto;
import ru.Hackaton.dtos.mappers.CreditAgentMapper;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.services.CreditAgentService;

@RequestMapping("/api/admin")
@RestController
@RequiredArgsConstructor
public class AdminController {
    private final CreditAgentService creditAgentService;
    private final CreditAgentMapper creditAgentMapper;

    @PostMapping("/register/agent")
    public ResponseEntity<?> registerCreditAgent(@RequestBody CreditAgentRegisterDto creditAgentRegisterDto) {
        CreditAgent creditAgent = creditAgentMapper.mapToCreditAgent(creditAgentRegisterDto);

        return ResponseEntity.ok(creditAgentService.registerCreditAgent(creditAgent));
    }
}
