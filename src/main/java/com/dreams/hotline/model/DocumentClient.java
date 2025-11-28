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
    private String objet;
    private Long type;
    public enum Status {
        EN_COURS_DE_TRAITEMENT,
        EN_ATTENTE_DE_TRAITEMENT,
        TERMINEE,

    }
    @Enumerated
    private Status status;
    private String message;

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

    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
