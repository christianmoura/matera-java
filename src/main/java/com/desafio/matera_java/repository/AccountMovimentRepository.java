package com.desafio.matera_java.repository;

import com.desafio.matera_java.model.AccountMoviment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMovimentRepository extends JpaRepository<AccountMoviment, Long> {
}
