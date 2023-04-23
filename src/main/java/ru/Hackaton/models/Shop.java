package ru.Hackaton.models;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Shop {
    @Id
    String id;
    String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

}
