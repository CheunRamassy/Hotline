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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }
}
