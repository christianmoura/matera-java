package com.desafio.matera_java.controller;

import com.desafio.matera_java.dto.ClienteDTO;
import com.desafio.matera_java.model.Cliente;
import com.desafio.matera_java.service.ClienteService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/")
    public synchronized ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

    @GetMapping("/{clienteId}")
    public synchronized ResponseEntity<Cliente> getById(@PathVariable Long clientId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findById(clientId));
    }

    @DeleteMapping("/delete/{clienteId}")
    public synchronized ResponseEntity<String> deleteClienteById(@PathVariable Long clienteId){
        service.deleteById(clienteId);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso");
    }

    @PostMapping("/cadastrar")
    public synchronized ResponseEntity<Cliente> createType(@RequestBody @Valid ClienteDTO clienteDTO){
        if (service.findByCPF(clienteDTO.cpf())!= null) return  ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveCliente(clienteDTO));
    }

    @PutMapping("/alterar")
    public synchronized ResponseEntity<Cliente> updateType(@RequestBody @Valid ClienteDTO clienteDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.saveCliente(clienteDTO));
    }

}
