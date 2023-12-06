package com.example.firstapp.Services.Model;

import com.example.firstapp.Entity.Modeles;

import java.util.List;

public interface ModelService {

        Modeles getModelByNom(String Nom);

        List<Modeles> getAllModel();

        Modeles creatModel(Modeles modeles);

        Modeles getModelByID(Long id);

        Modeles updateModel(Modeles voiture_id);

        void deleteModel(Long id);
    }


