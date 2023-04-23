package ru.Hackaton.validators;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.Hackaton.models.CreditAgent;
import ru.Hackaton.services.CreditAgentService;

@Component
@RequiredArgsConstructor
public class UsernameValidator implements Validator {
    private final CreditAgentService creditAgentService;
    @Override
    public boolean supports(Class<?> clazz) {
        return CreditAgent.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CreditAgent creditAgent = (CreditAgent) target;

        if (creditAgentService.existByEmail(creditAgent.getUsername())) {
            errors.rejectValue("username", "", "Имя пользователя уже используется.");
        }
    }
}
