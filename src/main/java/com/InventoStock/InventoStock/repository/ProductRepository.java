package com.InventoStock.InventoStock.repository;

import com.InventoStock.InventoStock.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Override
    List<Product> findAll();

    @Override
    List<Product> findAllById(Iterable<Long> longs);

    List<Product> findBySku(String sku);
}
