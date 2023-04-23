package ru.Hackaton.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import ru.Hackaton.utils.PaymentMethod;

import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "OrderTable")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Enumerated(value = EnumType.ORDINAL)
    PaymentMethod paymentMethod;

    String phoneNumber;

    String category;

    double price;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
