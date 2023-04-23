package ru.Hackaton.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreditAgentAuthDto {
    @NotBlank(message = "Логин пользователя не может быть пустым")
    private String username;
    @NotBlank(message = "Пароль пользователя не может быть пустым")
    private String password;

}
