package com.desafio.matera_java.model;

import com.desafio.matera_java.enums.MovimentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "accountmoviment")
public class AccountMoviment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany
    private Set<Account> accountId;

    @NotNull
    private MovimentType movimentType;

    @NotNull
    private BigDecimal valueAccount;

    @NotNull
    private BigDecimal previousBalance;

    @NotNull
    private BigDecimal currentBalance;

    @NotNull
    private Date atualDate;
}
