package com.dreams.hotline.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Client {

    @OneToOne
    @JoinColumn(name="id_Categorie", nullable=false )
    private Categrorie categorie;

    @OneToMany(mappedBy = "numeroClient")
    private Set<Contact> contact;
    public Set<Contact> getContact() {return contact;}
    public void setContact(Set<Contact> contact) {this.contact = contact;}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String mail;
    private String numero;

}
