package com.falabella.store.service;

import com.falabella.store.MiException.MiException;
import com.falabella.store.dto.ClientDto;
import com.falabella.store.dto.IdClientDto;
import com.falabella.store.dto.MessageDto;
import com.falabella.store.entity.Client;
import com.falabella.store.repository.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //Crear Usuario
    public MessageDto createClient(ClientDto clientDto){
        ObjectMapper mapper = new ObjectMapper();
        Client client = mapper.convertValue(clientDto, Client.class);
        clientRepository.save(client);
        return new MessageDto("Cliente creado");
    }

    //Read Usuarios
    public List<ClientDto> listarClientes(){
        ObjectMapper mapper = new ObjectMapper();
        List<Client> clientes = clientRepository.findAll();
        List<ClientDto> clientesDto = clientes.stream().map(client->{
            ClientDto clientDto = mapper.convertValue(client, ClientDto.class);
            return clientDto;
        }).collect(Collectors.toList());
        return clientesDto;
    }

    //Edit
    public MessageDto edit(Long id, ClientDto clientDto) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        Client client ;

        if (optionalClient.isPresent()){
            client = optionalClient.get();
            client.setName(clientDto.getName());
            client.setEmail(clientDto.getEmail());
            client.setPhoneNumber(clientDto.getPhoneNumber());
            clientRepository.save(client);
        }

        return new MessageDto("Cliente modificado");
    }

    public MessageDto delete(IdClientDto idClientDto) {
        Optional<Client> optionalClient = clientRepository.findById(idClientDto.getIdClientDto());

        if (optionalClient==null){
            throw new MiException("No se encontró el usuario para eliminar");
        }
        if (optionalClient.isPresent()){
             clientRepository.delete(optionalClient.get());
        }

        return new MessageDto("Cliente eliminado");
    }
}
