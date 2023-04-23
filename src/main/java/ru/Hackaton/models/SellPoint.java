package ru.Hackaton.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SellPoint {
    @Id
    String id;
    @NotNull
    @Size(max = 50)
    String name;
    @OneToOne(cascade = CascadeType.ALL)
    Shop shop;
    @ManyToMany
    List<CreditAgent> agents;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
