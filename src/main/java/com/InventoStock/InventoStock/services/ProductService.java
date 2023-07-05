package com.InventoStock.InventoStock.services;

import com.InventoStock.InventoStock.models.Product;
import com.InventoStock.InventoStock.models.ProductDTO;
import com.InventoStock.InventoStock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity<Map<String, Object>> registerProduct(ProductDTO productDTO){

        try{
            Product product = new Product();
            product.setProductName(productDTO.getProductName());
            product.setContainer(productDTO.getContainer());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setQuantity(productDTO.getQuantity());
            product.setSku(productDTO.getSku());
            product.setSupplierCode(productDTO.getSupplierCode());
            product.setSupplierName(productDTO.getSupplierName());

            productRepository.save(product);

            Map<String, Object> response = new HashMap<>();
            response.put("id", product.getId());
            response.put("message", "Product registered successfully");

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        }catch (Exception e){

            Map<String, Object> response = new HashMap<>();
            response.put("message", "Fail to register product");
            response.put("error", e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    public ResponseEntity<?> searchAllProducts(){

        try{

            List<Product> productList = new ArrayList<>();
            productList = productRepository.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(productList);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail to search all Products");
        }
    }

    public ResponseEntity<?> searchBySku(String sku){

        try{

            List<Product> productList = new ArrayList<>();
            productList = productRepository.findBySku(sku);
            return ResponseEntity.status(HttpStatus.OK).body(productList);

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Fail to find product by SKU");
        }
    }
}
