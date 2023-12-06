package com.example.firstapp.Services.Voiture;

import com.example.firstapp.Entity.Voiture;
import com.example.firstapp.Repository.Voiture.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  VoitureServiceImp implements VoitureService {

    private final VoitureRepository voitureRepository;

    @Autowired
    public VoitureServiceImp(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    @Override
    public List<Voiture> getAllVoitures() {
        return voitureRepository.findAll();
    }

    @Override
    public Voiture getVoitureById(Long id) {
        return voitureRepository.findById(id).orElse(null);
    }

    @Override
    public Voiture createVoiture(Voiture voiture) {
        return voitureRepository.save(voiture);
    }

    @Override
    public  Voiture updateVoiture(Long id, Voiture updatedVoiture) {
        if (voitureRepository.existsById(id)) {
            updatedVoiture.setId(id);
            return voitureRepository.saveAndFlush(updatedVoiture);
        }
        return null;
    }

    @Override
    public void deleteVoiture(Long id) {
        voitureRepository.deleteById(id);
    }
}
