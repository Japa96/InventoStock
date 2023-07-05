package com.InventoStock.InventoStock.controllers;

import com.InventoStock.InventoStock.models.Client;
import com.InventoStock.InventoStock.models.ClientDTO;
import com.InventoStock.InventoStock.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @GetMapping("/allClients")
    public ResponseEntity<?> allClients(){
        return clientService.searchAllClients();
    }

    @GetMapping("/byCpf/{cpf}")
    public ResponseEntity<?> byCpf(@PathVariable String cpf){
        return clientService.searchByCpf(cpf);
    }
}
