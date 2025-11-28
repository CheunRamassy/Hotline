package com.dreams.hotline.service;

import com.dreams.hotline.model.Client;
import com.dreams.hotline.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {return clientRepository.findAll();}

    public Optional<Client> getClientById(final Long id) {return clientRepository.findById(id);}

    public Client saveClient(Client client) {return clientRepository.save(client);}

    public boolean deleteClient(Long id){
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
