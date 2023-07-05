package com.InventoStock.InventoStock.repository;

import com.InventoStock.InventoStock.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Override
    List<Client> findAll();

    @Override
    List<Client> findAllById(Iterable<Long> longs);


    List<Client> findByCpf(String cpf);
}
