package com.desafio.matera_java.service;

import com.desafio.matera_java.dto.AccountDTO;

import com.desafio.matera_java.model.Account;

import com.desafio.matera_java.repository.AccountRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    public Account saveAccount(AccountDTO accountDTO) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDTO, account);

        return repository.save(account);
    }

    public Account findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Account> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
