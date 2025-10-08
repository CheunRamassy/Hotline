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
}
