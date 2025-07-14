package com.desafio.matera_java.service;


import com.desafio.matera_java.dto.AccountDTO;
import com.desafio.matera_java.dto.AccountMovimentDTO;

import com.desafio.matera_java.dto.ClienteDTO;
import com.desafio.matera_java.dto.MovimentAccountDTO;
import com.desafio.matera_java.enums.MovimentType;
import com.desafio.matera_java.model.Account;
import com.desafio.matera_java.model.AccountMoviment;
import com.desafio.matera_java.repository.AccountMovimentRepository;
import com.desafio.matera_java.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class AccountMovimentService {

    @Autowired
    private AccountMovimentRepository repository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    public List<AccountMoviment> saveAccountMoviment(List<MovimentAccountDTO> movimentAccountDTOS) {

        if (movimentAccountDTOS.isEmpty()) {
            return Collections.emptyList();
        } else {

            List<AccountMoviment> accountMoviments = new ArrayList<>();

            movimentAccountDTOS.forEach( movimentAccountDTO ->{
                AccountMoviment accountMoviment = new AccountMoviment();
                //BeanUtils.copyProperties(accountMovimentDTO, accountMoviment);
                if (movimentAccountDTO.movimentType() == MovimentType.CREDIT) {
                    Long accountId = movimentAccountDTO.accountId().iterator().next().id();

                    BigDecimal accountBalance =  accountService.findById(accountId).getCurrentBalance();

                    accountMoviment.setMovimentType(movimentAccountDTO.movimentType());
                    accountMoviment.setValueAccount(movimentAccountDTO.valueAccount());
                    accountMoviment.setPreviousBalance(accountBalance);
                    accountMoviment.setCurrentBalance(accountBalance.add(movimentAccountDTO.valueAccount()));
                    accountMoviment.setAtualDate(movimentAccountDTO.currentDate());
                    accountMoviments.add(repository.save(accountMoviment));
                    Account account  = accountService.findById(accountId);
                    if (account != null) {
                        account.setCurrentBalance(accountBalance.add(movimentAccountDTO.valueAccount()));
                        accountRepository.save(account);
                    }
                } else {
                    Long accountId = movimentAccountDTO.accountId().iterator().next().id();

                    BigDecimal accountBalance =  accountService.findById(accountId).getCurrentBalance();

                    accountMoviment.setMovimentType(movimentAccountDTO.movimentType());
                    accountMoviment.setValueAccount(movimentAccountDTO.valueAccount());
                    accountMoviment.setPreviousBalance(accountBalance);
                    accountMoviment.setCurrentBalance(accountBalance.subtract(movimentAccountDTO.valueAccount()));
                    accountMoviment.setAtualDate(movimentAccountDTO.currentDate());
                    accountMoviments.add(repository.save(accountMoviment));
                    Account account  = accountService.findById(accountId);
                    if (account != null) {
                        account.setCurrentBalance(accountBalance.subtract(movimentAccountDTO.valueAccount()));
                        accountRepository.save(account);
                    }
                }

            });
            return accountMoviments;
        }
    }

    public AccountMoviment findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<AccountMoviment> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
