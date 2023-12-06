package com.example.firstapp.Services.Model;

import com.example.firstapp.Entity.Modeles;
import com.example.firstapp.Repository.Model.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeleServiceImp implements ModelService{

    @Autowired
    private ModelRepository modelRepository;
    @Override
    public Modeles getModelByNom(String nom) {
        return modelRepository.getModelByNom(nom);
    }

    @Override
    public List<Modeles> getAllModel() {
        return modelRepository.findAll();
    }

    @Override
    public Modeles creatModel(Modeles modele) {
        return modelRepository.save(modele);
    }

    @Override
    public Modeles getModelByID(Long id) {
        return modelRepository.findById(id).get();
    }

    @Override
    public Modeles updateModel(Modeles modele) {
        return modelRepository.saveAndFlush(modele);
    }

    @Override
    public void deleteModel(Long id) {
        modelRepository.deleteById(id);
    }
}
