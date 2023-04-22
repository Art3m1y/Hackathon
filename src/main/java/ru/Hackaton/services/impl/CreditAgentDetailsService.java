package ru.Hackaton.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.repositories.CreditAgentRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CreditAgentDetailsService implements UserDetailsService  {
    private final CreditAgentRepository creditAgentRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Optional<CreditAgent> creditAgent = creditAgentRepository.findByUsername(username);

        if (creditAgent.isEmpty()) {
            throw new RuntimeException("Неверные учетные данные пользователя");
        }

        return new CreditAgentDetails(creditAgent.get());
    }
}
