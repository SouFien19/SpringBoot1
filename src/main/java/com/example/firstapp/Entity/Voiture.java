package com.example.firstapp.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
@Entity
public class Voiture {
    public Voiture(Long id, String serie, Date date_Mise_En_Marche, String model, List<Location> locations) {
        this.id = id;
        Serie = serie;
        this.date_Mise_En_Marche = date_Mise_En_Marche;
        Model = model;
        this.locations = locations;
    }

    public Voiture() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {

        return Serie;
    }

    public void setSerie(String serie) {

        Serie = serie;
    }

    public Date getDate_Mise_En_Marche() {

        return date_Mise_En_Marche;
    }

    public void setDate_Mise_En_Marche(Date date_Mise_En_Marche) {
        this.date_Mise_En_Marche = date_Mise_En_Marche;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public Voiture(Long id, String serie, Date date_Mise_En_Marche, String model) {
        this.id = id;
        Serie = serie;
        this.date_Mise_En_Marche = date_Mise_En_Marche;
        Model = model;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Serie")
    private String Serie;

    @Column( name = "date_Mise_En_Marche")
    private Date date_Mise_En_Marche;

    @Column(name="Model")
    private String Model;

    @OneToMany(mappedBy = "voiture")
    private List<Location> locations;

    public List<Location> getLocations() {

        return locations;
    }

    public void setLocations(List<Location> locations) {

        this.locations = locations;
    }
}
