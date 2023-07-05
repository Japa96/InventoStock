package com.InventoStock.InventoStock.repository;

import com.InventoStock.InventoStock.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Override
    List<Seller> findAll();

    @Override
    List<Seller> findAllById(Iterable<Long> longs);

    List<Seller> findByEmail(String email);
}
