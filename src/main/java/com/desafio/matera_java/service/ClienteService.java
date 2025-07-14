package com.desafio.matera_java.service;

import com.desafio.matera_java.dto.ClienteDTO;
import com.desafio.matera_java.model.Cliente;
import com.desafio.matera_java.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente saveCliente(ClienteDTO clienteDto) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDto, cliente);

        return repository.save(cliente);
    }

    public Cliente findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Cliente findByCPF(String cpf) {
        return repository.findOneByCpf(cpf);
    }
}
