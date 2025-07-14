package com.desafio.matera_java.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String agency;

    private String agencyVerificationDigit;

    @NotBlank
    private String accountNumber;

    private String accountVeficationDigit;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    @ManyToMany
    private Set<AccountMoviment> accountMoviment;

    @NotNull
    private BigDecimal currentBalance;
}
