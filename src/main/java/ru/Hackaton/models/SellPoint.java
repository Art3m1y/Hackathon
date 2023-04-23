package ru.Hackaton.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellPoint {
    @Id
    String id;

    String name;

    @OneToOne(cascade = CascadeType.ALL)
    Shop shop;

    @OneToMany
    List<CreditAgent> agents;
}
