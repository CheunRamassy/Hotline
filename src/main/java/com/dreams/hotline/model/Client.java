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

    @OneToMany(mappedBy = "numeroDocClient")
    private Set<DocumentClient> documentClient;
    public Set<DocumentClient> getDocumentClient() {return documentClient;}
    public void setDocumentClient(Set<DocumentClient> documentClient) {this.documentClient = documentClient;}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String mail;
    private String numero;

    public Categrorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categrorie categorie) {
        this.categorie = categorie;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
