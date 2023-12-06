package com.example.firstapp.RestControllers;

import com.example.firstapp.Entity.Modeles;
import com.example.firstapp.Services.Model.ModeleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/model")
public class RestControllerModel {

    @Autowired
    private ModeleServiceImp modeleServiceImp;

    @PostMapping("/save")
    public Modeles addClient(@RequestBody Modeles modele){
        return modeleServiceImp.creatModel(modele);
    }


    @GetMapping("/all")
    public List<Modeles> getallModel(){
        return modeleServiceImp.getAllModel();
    }


    @GetMapping("/getone/{id}")
    public Modeles getoneModel(@PathVariable Long id){
        return modeleServiceImp.getModelByID(id);
    }


    @PutMapping("/update/{id}")
    public Modeles updateModel(@PathVariable Long id, @RequestBody Modeles modele){
        Modeles modele1 = modeleServiceImp.getModelByID(id);
        if (modele1 != null){
            modele.setId(id);
            return modeleServiceImp.updateModel(modele);
        }else {
            throw new RuntimeException("Failed !!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteModel(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (modeleServiceImp.getModelByID(id)== null){
            message.put("etat", "model not found");
            return message;
        }
        try {
            modeleServiceImp.deleteModel(id);
            message.put("etat", "model delete");
            return message;
        }catch (Exception e){
            message.put("etat", "model not deleted");
            return message;
        }
    }

}
