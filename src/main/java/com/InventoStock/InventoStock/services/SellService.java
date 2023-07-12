package com.InventoStock.InventoStock.services;

import com.InventoStock.InventoStock.models.*;
import com.InventoStock.InventoStock.repository.ClientRepository;
import com.InventoStock.InventoStock.repository.ProductRepository;
import com.InventoStock.InventoStock.repository.SellRepository;
import com.InventoStock.InventoStock.repository.SellerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SellService {

    private final SellRepository sellRepository;
    private final ClientRepository clientRepository;
    private final SellerRepository sellerRepository;
    private final ProductRepository productRepository;

    public SellService(SellRepository sellRepository, ClientRepository clientRepository, SellerRepository sellerRepository, ProductRepository productRepository) {

        this.sellRepository = sellRepository;
        this.clientRepository = clientRepository;
        this.sellerRepository = sellerRepository;
        this.productRepository = productRepository;
    }

    public ResponseEntity<Map<String, Object>> registerSell(SellDTO sellDTO){
        Map<String, Object> response = new HashMap<>();

        Optional<Product> optionalProduct = productRepository.findById(sellDTO.getProductId());
        if (optionalProduct.isEmpty()) {
            response.put("message", "Fail to find the productId " + sellDTO.getProductId());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Product product = optionalProduct.get();

        Optional<Seller> optionalSeller = sellerRepository.findById(sellDTO.getSellerId());
        if (optionalSeller.isEmpty()) {
            response.put("message", "Fail to find the sellerId " + sellDTO.getSellerId());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Seller seller = optionalSeller.get();

        Optional<Client> optionalClient = clientRepository.findById(sellDTO.getClientId());
        if (optionalClient.isEmpty()) {
            response.put("message", "Fail to find the clientId " + sellDTO.getClientId());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        Client client = optionalClient.get();

        try {
            Sell sell = new Sell();
            sell.setClient(client);
            sell.setSeller(seller);
            sell.setProduct(product);
            sell.setQuantity(sellDTO.getQuantity());
            sell.setKindPayment(sellDTO.getKindPayment());
            sell.setTotalValue(sellDTO.getTotalValue());

            sellRepository.save(sell);

            response.put("id", sell.getId());
            response.put("message", "Sell registered successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            response.put("message", "Fail to register sell");
            response.put("error", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
}
