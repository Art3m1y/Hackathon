package ru.Hackaton.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditAgent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String login;

    String name;
}
