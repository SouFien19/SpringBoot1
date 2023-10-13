package com.example.firstapp.Entity;


import jakarta.persistence.*;

@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "adresse")
    private String adresse;

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public Long getId() {
        return id;
    }
}