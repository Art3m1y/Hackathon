package ru.Hackaton.services.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.Hackaton.dtos.CreditAgentDto;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.repositories.CreditAgentRepository;
import ru.Hackaton.services.CreditAgentService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CreditAgentServiceImpl implements CreditAgentService {

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

        Optional<CreditAgent> agent = creditAgentRepository.findById(creditAgentToUpdate.getLogin());

        if(agent.isPresent()) {
            return creditAgentRepository.save(creditAgentToUpdate);
        } else {
            throw new NullPointerException("Can't save null");
        }
    }

    @Override
    public void delete(String login) {
        creditAgentRepository.deleteById(login);
    }
}
