package ru.Hackaton.dtos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.Hackaton.utils.PaymentMethod;

@Data
@FieldDefaults(level = AccessLevel.PACKAGE)
public class OrderDto {
    String id;
    PaymentMethod paymentMethod;

    String phoneNumber;

    String category;

    double price;
}
