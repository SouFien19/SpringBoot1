package com.example.firstapp.RestControllers;

import com.example.firstapp.Entity.Modeles;
import com.example.firstapp.Entity.Voiture;
import com.example.firstapp.Services.Voiture.VoitureServiceImp;
import com.example.firstapp.Services.Model.ModeleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/voiture")
public class RestControllerVoiture {

    @Autowired
    private VoitureServiceImp voitureServiceImp;

    @Autowired
    private ModeleServiceImp modeleServiceImp;

    @PostMapping("/save/{idmodel}")
    public Voiture addVoiture(@RequestBody Voiture voiture, @PathVariable Long idmodel) {
        Modeles m1 = modeleServiceImp.getModelByID(idmodel);
        voiture.setModel(m1);
        return voitureServiceImp.createVoiture(voiture);
    }


    @GetMapping("/all")
    public List<Voiture> getallVoiture(){
        return voitureServiceImp.getAllVoitures();
    }


    @GetMapping("/getone/{id}")
    public Voiture getoneVoiture(@PathVariable Long id){
        return voitureServiceImp.getVoitureById(id);
    }


    @PutMapping("/update/{id}")
    public Voiture updateVoiture(@PathVariable Long id, @RequestBody Voiture voiture){
        Voiture voiture1 = voitureServiceImp.getVoitureById(id);
        if (voiture1 != null){
            voiture.setId(id);
            return voitureServiceImp.updateVoiture(id, voiture);
        }else {
            throw new RuntimeException("Failed !!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteVoiture(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (voitureServiceImp.getVoitureById(id)== null){
            message.put("etat", "voiture not found");
            return message;
        }
        try {
            voitureServiceImp.deleteVoiture(id);
            message.put("etat", "voiture delete");
            return message;
        }catch (Exception e){
            message.put("etat", "voiture not deleted");
            return message;
        }
    }
}
