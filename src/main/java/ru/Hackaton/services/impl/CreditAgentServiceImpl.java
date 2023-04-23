package ru.Hackaton.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.models.SellPoint;
import ru.Hackaton.repositories.CreditAgentRepository;
import ru.Hackaton.services.CreditAgentService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreditAgentServiceImpl implements CreditAgentService {
    PasswordEncoder passwordEncoder;

    CreditAgentRepository creditAgentRepository;

    @Override
    public List<CreditAgent> findAll() {
        return creditAgentRepository.findAll();
    }

    @Override
    public CreditAgent findByLogin(String login) {
        return creditAgentRepository.findById(login)
                .orElseThrow(() -> new RuntimeException("Не существует пользователя с таким логином"));
    }

    @Override
    public CreditAgent save(CreditAgent newCreditAgent) {
        return creditAgentRepository.save(newCreditAgent);
    }

    @Override
    public CreditAgent upgrade(CreditAgent creditAgentToUpdate) {

        Optional<CreditAgent> agent = creditAgentRepository.findById(creditAgentToUpdate.getUsername());

        if(agent.isPresent()) {
            return creditAgentRepository.save(creditAgentToUpdate);
        } else {
            throw new RuntimeException("Не существует пользователя с таким логином");
        }
    }

    @Override
    public void delete(String login) {
        creditAgentRepository.deleteById(login);
    }

    @Override
    public CreditAgent registerCreditAgent(CreditAgent creditAgent) {
        creditAgent.setPassword(passwordEncoder.encode(creditAgent.getPassword()));
        creditAgent.setCreatedAt(new Date());

        creditAgentRepository.save(creditAgent);

        return creditAgent;
    }

    @Override
    public List<SellPoint> getPoints(String login) {
        return creditAgentRepository.findById(login).orElseThrow(() -> new RuntimeException("Кредитного агента с таким логином не существует")).getPoints();
    }

    @Override
    public boolean existByEmail(String username) {
        return creditAgentRepository.existsById(username);
    }
}
