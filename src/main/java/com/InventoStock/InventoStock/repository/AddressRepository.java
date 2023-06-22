package com.InventoStock.InventoStock.repository;

import com.InventoStock.InventoStock.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Override
    List<Address> findAll();

    @Override
    List<Address> findAllById(Iterable<Long> longs);
}
