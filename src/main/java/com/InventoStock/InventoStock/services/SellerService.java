package com.InventoStock.InventoStock.services;

import com.InventoStock.InventoStock.models.Seller;
import com.InventoStock.InventoStock.models.SellerDTO;
import com.InventoStock.InventoStock.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public ResponseEntity<Map<String, Object>> registerSeller(SellerDTO sellerDTO){

        try{
            Seller seller = new Seller();
            seller.setName(sellerDTO.getName());
            seller.setLastName(sellerDTO.getLastName());
            seller.setEmail(sellerDTO.getEmail());
            seller.setPhone(sellerDTO.getPhone());

            sellerRepository.save(seller);

            Map<String, Object> response = new HashMap<>();
            response.put("id", seller.getId());
            response.put("message", "Seller registered successfully");

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        }catch (Exception e){

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Fail to register Seller");
            response.put("error", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);

        }
    }
}
