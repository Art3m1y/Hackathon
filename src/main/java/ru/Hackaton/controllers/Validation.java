package ru.Hackaton.controllers;

import org.springframework.validation.BindingResult;

public class Validation {
    public static void validateRequestBody(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            StringBuilder errors = new StringBuilder();
            bindingResult.getFieldErrors().forEach(error -> errors.append(error.getDefaultMessage()).append("; "));
            throw new RuntimeException(errors.toString());
        }
    }

    public static void validateStringForLong(String maybeNumber) {
        try {
            Long numberConverted = Long.parseLong(maybeNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Не удалось преобразовать стровку в числовой формат");
        }
    }
}
