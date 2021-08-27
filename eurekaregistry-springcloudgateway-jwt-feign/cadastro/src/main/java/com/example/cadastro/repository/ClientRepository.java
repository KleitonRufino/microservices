package com.example.cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.cadastro.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
