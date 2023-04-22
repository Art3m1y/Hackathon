package ru.Hackaton.dtos;

import lombok.Getter;

@Getter
public class CreditAgentRegisterDto {
    private String username;
    private String password;
    private String name;
    private String surname;
    private String patronymic;
}
