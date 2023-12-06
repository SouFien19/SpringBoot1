package com.example.firstapp.Services.Voiture;

import com.example.firstapp.Entity.Voiture;
import java.util.List;

public interface VoitureService {
    List<Voiture> getAllVoitures();
    Voiture getVoitureById(Long id);
    Voiture createVoiture(Voiture voiture);
    Voiture updateVoiture(Long id, Voiture updatedVoiture);
    void deleteVoiture(Long id);
}
