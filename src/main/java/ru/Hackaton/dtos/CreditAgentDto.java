package ru.Hackaton.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.Hackaton.models.SellPoint;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditAgentDto {

    String login;

    String name;

    List<SellPointDto> points;
}
