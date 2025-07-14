package com.desafio.matera_java.dto;

import com.desafio.matera_java.model.Account;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteDTO(Long id, @NotBlank String name, @NotBlank String cpf
        , String phoneNumber
        , @Email String email, String country, String uf, String city, String cep
        , String homeNumber, String street, String neighborhood, String comṕlement
        , Account accountId) {
}
