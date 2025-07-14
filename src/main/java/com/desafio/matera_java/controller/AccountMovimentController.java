package com.desafio.matera_java.controller;

import com.desafio.matera_java.dto.AccountDTO;
import com.desafio.matera_java.dto.AccountMovimentDTO;
import com.desafio.matera_java.dto.MovimentAccountDTO;
import com.desafio.matera_java.model.Account;
import com.desafio.matera_java.model.AccountMoviment;
import com.desafio.matera_java.service.AccountMovimentService;
import com.desafio.matera_java.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/accountmoviment")
public class AccountMovimentController {

    @Autowired
    private AccountMovimentService service;

    @GetMapping("/")
    public synchronized ResponseEntity<List<AccountMoviment>> getAllAccountMoviments(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{accountMovimentId}")
    public synchronized ResponseEntity<AccountMoviment> getById(@PathVariable Long accountMovimentId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(accountMovimentId));
    }

    @DeleteMapping("/delete/{accountMovimentId}")
    public synchronized ResponseEntity<String> deleteAccountById(@PathVariable Long accountMovimentId){
        service.deleteById(accountMovimentId);
        return ResponseEntity.status(HttpStatus.OK).body("Movimento de conta deletada com sucesso");
    }

    @PostMapping("/cadastrar")
    public synchronized ResponseEntity<List<AccountMoviment>> createType(@RequestBody @Valid List<MovimentAccountDTO> accountMovimentDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAccountMoviment(accountMovimentDTO));
    }

    @PutMapping("/alterar")
    public synchronized ResponseEntity<List<AccountMoviment>> updateType(@RequestBody @Valid List<MovimentAccountDTO> accountMovimentDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.saveAccountMoviment(accountMovimentDTO));
    }

}
