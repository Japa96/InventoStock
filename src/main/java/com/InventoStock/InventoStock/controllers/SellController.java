package com.InventoStock.InventoStock.controllers;

import com.InventoStock.InventoStock.models.SellDTO;
import com.InventoStock.InventoStock.services.SellService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/sell")
public class SellController {

    private final SellService sellService;

    @Autowired
    public SellController(SellService sellService) {
        this.sellService = sellService;
    }

    @PostMapping("/registerSell")
    public ResponseEntity<Map<String, Object>> registerSell(@Valid @RequestBody SellDTO sellDTO){
        return sellService.registerSell(sellDTO);
    }
}
