package com.InventoStock.InventoStock.controllers;

import com.InventoStock.InventoStock.models.ClientDTO;
import com.InventoStock.InventoStock.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/registerClient")
    public ResponseEntity<Map<String, Object>> registerClient(@Valid @RequestBody ClientDTO clientDTO){
        return clientService.registerClient(clientDTO);
    }
}
