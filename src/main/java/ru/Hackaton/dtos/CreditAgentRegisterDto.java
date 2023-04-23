package ru.Hackaton.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreditAgentRegisterDto {
    @NotBlank(message = "Логин пользователя не может быть пустым")
    @Size(min = 5, max = 50, message = "Минимальная длина логина пользователя - 5 символов, максимальная - 50 символов")
    private String username;
    @NotBlank(message = "Пароль пользователя не может быть пустым")
    @Size(min = 5, max = 60, message = "Минимальная длина пароля - 5 символов, максимальная - 60 символов")
    private String password;
    @NotBlank(message = "Имя пользователя не может быть пустым")
    @Size(min = 3, max = 32, message = "Минимальная длина имени пользователя - 3 символов, максимальная - 32 символов")
    private String name;
    @NotBlank(message = "Фамилия пользователя не может быть пустым")
    @Size(min = 3, max = 32, message = "Минимальная длина фамилии пользователя - 3 символов, максимальная - 32 символов")
    private String surname;
    @NotBlank(message = "Отчество пользователя не может быть пустым")
    @Size(min = 3, max = 32, message = "Минимальная длина отчества пользователя - 3 символов, максимальная - 32 символов")
    private String patronymic;
}
