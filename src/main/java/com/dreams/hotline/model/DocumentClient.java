package com.dreams.hotline.model;

import jakarta.persistence.*;

@Entity
public class DocumentClient {

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client numeroClient;
    public Client getNumeroClient() {return numeroClient;}
    public void setNumeroClient(Client numeroClient) {this.numeroClient = numeroClient;}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numeroDocument;
    private Long type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumeroDocument() {
        return numeroDocument;
    }

    public void setNumeroDocument(Long numeroDocument) {
        this.numeroDocument = numeroDocument;
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }
}
