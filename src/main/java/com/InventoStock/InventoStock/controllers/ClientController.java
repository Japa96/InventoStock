package com.InventoStock.InventoStock.controllers;

import com.InventoStock.InventoStock.models.AddressDTO;
import com.InventoStock.InventoStock.models.Client;
import com.InventoStock.InventoStock.models.ClientDTO;
import com.InventoStock.InventoStock.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<String> registerClient(@Valid @RequestBody ClientDTO clientDTO){
        return clientService.registerClient(clientDTO);
    }
}
