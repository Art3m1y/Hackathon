package ru.Hackaton.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreditAgent {
    @Id
    String username;
    String password;
    String name;
    String surname;
    String patronymic;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
