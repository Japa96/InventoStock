package com.InventoStock.InventoStock.controllers;

import com.InventoStock.InventoStock.models.SellerDTO;
import com.InventoStock.InventoStock.services.SellerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {this.sellerService = sellerService;}

    @PostMapping("/registerSeller")
    public ResponseEntity<Map<String, Object>> registerSeller(@Valid @RequestBody SellerDTO sellerDTO){
        return sellerService.registerSeller(sellerDTO);
    }

    @GetMapping("/allSellers")
    public ResponseEntity<?> allSellers (){
        return sellerService.allSellers();
    }

    @GetMapping("/byEmail/{email}")
    public ResponseEntity<?> byEmail(@PathVariable String email){
        return sellerService.byEmail(email);
    }
}
