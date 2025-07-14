package com.desafio.matera_java.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String cpf;

    private String phoneNumber;

    @Email
    private String email;

    private String country;
    private String uf;
    private String city;
    private String cep;
    private String homeNumber;
    private String street;
    private String neighborhood;
    private String comṕlement;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Set<Account> account;

}
