package com.example.firstapp.Entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Location {

    public Location() {

    }

    public Location(Long id, Date date_debut, Date date_retour, int prix_jour, int prix, Client client, Voiture voiture) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_retour = date_retour;
        this.prix_jour = prix_jour;
        this.prix = prix;
        this.client = client;
        this.voiture = voiture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_retour() {
        return date_retour;
    }

    public void setDate_retour(Date date_retour) {
        this.date_retour = date_retour;
    }

    public int getPrix_jour() {
        return prix_jour;
    }

    public void setPrix_jour(int prix_jour) {
        this.prix_jour = prix_jour;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Location(Long id, Date date_debut, Date date_retour, int prix_jour, int prix) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_retour = date_retour;
        this.prix_jour = prix_jour;
        this.prix = prix;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;







    @Column(name = "date_debut")
    private Date date_debut;

    @Column(name = "date_retour")
    private Date date_retour;

    @Column(name = "prix_jour")
    private int prix_jour;

    @Column(name = "prix")
    private int prix;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @ManyToOne
    @JoinColumn(name = "voiture_id")
    private Voiture voiture;

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }
}
