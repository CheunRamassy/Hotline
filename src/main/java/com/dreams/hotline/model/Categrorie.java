package com.dreams.hotline.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Categrorie {

    @OneToOne( mappedBy = "categorie" )
    private Client client;

    @OneToMany
    private List<Contact> contact;
    public List<Contact> getContact() {
        return contact;
    }
    public void setUser(List<Contact> contact) {
        this.contact = contact;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setContact(List<Contact> contact) {
        this.contact = contact;
    }

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
}
