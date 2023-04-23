package ru.Hackaton.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotNull
    @Size(max = 50)
    String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

}
