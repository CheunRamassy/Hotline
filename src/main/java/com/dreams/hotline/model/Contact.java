package com.dreams.hotline.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Contact {

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client numeroClient;
    public Client getNumeroClient() {return numeroClient;}
    public void setNumeroClient(Client numeroClient) {this.numeroClient = numeroClient;}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private Long telephone;
}
