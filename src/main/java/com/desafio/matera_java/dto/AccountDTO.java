package com.desafio.matera_java.dto;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Set;

public record AccountDTO(Long id, @NotBlank String agency
        , String agencyVerificationDigit, @NotBlank String accountNumber
        , String accountVeficationDigit, ClienteDTO clientId
        , Set<AccountMovimentDTO> accountMoviment, BigDecimal currentBalance) {
}
