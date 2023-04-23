package ru.Hackaton.models;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "agent_username", referencedColumnName = "username")
    private CreditAgent creditAgent;

    public RefreshToken(CreditAgent creditAgent) {
        this.creditAgent = creditAgent;
    }
}
