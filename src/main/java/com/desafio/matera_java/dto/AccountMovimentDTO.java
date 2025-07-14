package com.desafio.matera_java.dto;

import com.desafio.matera_java.enums.MovimentType;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

public record AccountMovimentDTO(Long id, Set<AccountDTO> accountId
        , @NotNull MovimentType movimentType, @NotNull BigDecimal valueAccount
        , @NotNull BigDecimal previousBalance, @NotNull BigDecimal currentBalance
        , @NotNull Date currentDate) {
}
