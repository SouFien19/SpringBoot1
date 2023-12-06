package com.example.firstapp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;
@Entity
public class Voiture {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="Serie")
    private String Serie;

    @Column( name = "date_Mise_En_Marche")
    private LocalDate date_Mise_En_Marche;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Modeles Model;

    @JsonIgnore
    @OneToMany()
    private List<Location> locations;

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

    public LocalDate getDate_Mise_En_Marche() {
        return date_Mise_En_Marche;
    }

    public void setDate_Mise_En_Marche(LocalDate date_Mise_En_Marche) {
        this.date_Mise_En_Marche = date_Mise_En_Marche;
    }

    public Modeles getModel() {
        return Model;
    }

    public void setModel(Modeles model) {
        Model = model;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}


