package com.dreams.hotline.service;

import com.dreams.hotline.model.DocumentClient;
import com.dreams.hotline.repository.DocumentClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentClientService {

    private final DocumentClientRepository documentClientRepository;

    @Autowired
    public DocumentClientService(final DocumentClientRepository documentClientRepository) {
        this.documentClientRepository = documentClientRepository;
    }

    public List<DocumentClient> getAllDocumentClients() {return documentClientRepository.findAll();}

    public Optional<DocumentClient> getDocumentClientById(final Long id) {return documentClientRepository.findById(id);}

    public DocumentClient saveDocumentClient(DocumentClient documentClient) {
        return documentClientRepository.save(documentClient);
    }

    public boolean deleteDocumentClient(Long id) {
        if(documentClientRepository.existsById(id)){
            documentClientRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
