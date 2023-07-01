package com.InventoStock.InventoStock.services;

import com.InventoStock.InventoStock.models.Sell;
import com.InventoStock.InventoStock.models.SellDTO;
import com.InventoStock.InventoStock.repository.SellRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SellService {

    private final SellRepository sellRepository;

    public SellService(SellRepository sellRepository) {
        this.sellRepository = sellRepository;
    }

    public ResponseEntity<Map<String, Object>> registerSell(SellDTO sellDTO){


        try {
            Sell sell = new Sell();
            sell.setClient(sellDTO.getClient());
            sell.setProduct(sellDTO.getProduct());
            sell.setSeller(sellDTO.getSeller());
            sell.setQuantity(sellDTO.getQuantity());
            sell.setKindPayment(sellDTO.getKindPayment());
            sell.setTotalValue(sellDTO.getTotalValue());

            sellRepository.save(sell);

            Map<String, Object> response = new HashMap<>();
            response.put("id", sell.getId());
            response.put("message", "Sell registered successfully");

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        }catch (Exception e){
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Fail to register sell");
            response.put("error", e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
