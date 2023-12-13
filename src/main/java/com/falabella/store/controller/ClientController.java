package com.falabella.store.controller;

import com.falabella.store.dto.ClientDto;
import com.falabella.store.dto.IdClientDto;
import com.falabella.store.dto.MessageDto;

import com.falabella.store.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping("/newClient")
    public ResponseEntity<MessageDto> createUser(@RequestBody @Valid ClientDto clientDto){

        return new ResponseEntity<>(clientService.createClient(clientDto), HttpStatus.CREATED);
    }


    @GetMapping("/clients")
    public ResponseEntity<List<ClientDto>> listClients(){
        return new ResponseEntity<>(clientService.listarClientes(),HttpStatus.OK);
    }

    @PutMapping("/editUser/{id}")
    public ResponseEntity<MessageDto> editClient(@RequestBody @Valid ClientDto clientDto,@PathVariable Long id){
        return new ResponseEntity<>(clientService.edit(clientDto,id),HttpStatus.OK);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<MessageDto> deleteClient(@PathVariable  Long id){
        IdClientDto idClientDto = new IdClientDto(id);
        return new ResponseEntity<>(clientService.delete(idClientDto),HttpStatus.OK);
    }
}
