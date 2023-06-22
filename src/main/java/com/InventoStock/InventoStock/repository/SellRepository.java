package com.InventoStock.InventoStock.repository;

import com.InventoStock.InventoStock.models.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellRepository extends JpaRepository<Sell, Long> {

    @Override
    List<Sell> findAll();

    @Override
    List<Sell> findAllById(Iterable<Long> longs);
}
