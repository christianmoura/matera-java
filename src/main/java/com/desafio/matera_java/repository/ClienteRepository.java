package com.desafio.matera_java.repository;

import com.desafio.matera_java.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Cliente findOneByCpf(String cpf);
}
