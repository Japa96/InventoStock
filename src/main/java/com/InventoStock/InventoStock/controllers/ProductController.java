package com.InventoStock.InventoStock.controllers;

import com.InventoStock.InventoStock.models.ProductDTO;
import com.InventoStock.InventoStock.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {this.productService = productService;}

    @PostMapping("/registerProduct")
    public ResponseEntity<Map<String, Object>> registerProduct(@Valid @RequestBody ProductDTO productDTO){
        return productService.registerProduct(productDTO);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<?> allProducts(){
        return productService.searchAllProducts();
    }

    @GetMapping("/bySku/{sku}")
    public ResponseEntity<?> allBySku(@PathVariable String sku){
        return productService.searchBySku(sku);
    }
}
