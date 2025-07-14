package com.desafio.matera_java.controller;

import com.desafio.matera_java.dto.AccountDTO;

import com.desafio.matera_java.model.Account;

import com.desafio.matera_java.service.AccountService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

    @Autowired
    private AccountService service;

    @GetMapping("/")
    public synchronized ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{accountId}")
    public synchronized ResponseEntity<Account> getById(@PathVariable Long accountId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(accountId));
    }

    @DeleteMapping("/delete/{accountId}")
    public synchronized ResponseEntity<String> deleteAccountById(@PathVariable Long accountId){
        service.deleteById(accountId);
        return ResponseEntity.status(HttpStatus.OK).body("Conta deletada com sucesso");
    }

    @PostMapping("/cadastrar")
    public synchronized ResponseEntity<Account> createType(@RequestBody @Valid AccountDTO accountDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAccount(accountDTO));
    }

    @PutMapping("/alterar")
    public synchronized ResponseEntity<Account> updateType(@RequestBody @Valid AccountDTO accountDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.saveAccount(accountDTO));
    }
}
