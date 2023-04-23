package ru.Hackaton.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellPointDto {
    String id;
    String name;
    ShopDto shop;
    List<CreditAgentDto> agents;
}
