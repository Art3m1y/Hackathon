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
public class CreditAgent {
    @Id
    @NotNull
    @Size(max = 50)
    String username;
    @NotNull
    @Size(max = 60)
    String password;
    @NotNull
    @Size(max = 32)
    String name;
    @NotNull
    @Size(max = 32)
    String surname;
    @NotNull
    @Size(max = 32)
    String patronymic;
    boolean isAdmin;
    @OneToOne(mappedBy = "creditAgent", cascade = CascadeType.REMOVE)
    private RefreshToken refreshToken;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @ManyToMany
    List<SellPoint> points;
}
