package com.example.firstapp.RestControllers;

import com.example.firstapp.Entity.Client;
import com.example.firstapp.Entity.Location;
import com.example.firstapp.Entity.Voiture;
import com.example.firstapp.Services.Client.ClientServiceImp;
import com.example.firstapp.Services.Location.LocationServiceImp;
import com.example.firstapp.Services.Voiture.VoitureServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/location")
public class RestControllerLocation {

    @Autowired
    private LocationServiceImp locationServiceImp;

    @Autowired
    private ClientServiceImp clientServiceImp;

    @Autowired
    private VoitureServiceImp voitureServiceImp;

    @PostMapping("/save/{idclient}/{idvoiture}")
    public Location addLocation(@RequestBody Location location, @PathVariable Long idclient, @PathVariable Long idvoiture){

        Client c1 = clientServiceImp.getClientByID(idclient);
        location.setClient(c1);
        Voiture v1 = voitureServiceImp.getVoitureById(idvoiture);
        location.setVoiture(v1);
        int prixJour = 100; // Fixed prix_jour value
        long days = ChronoUnit.DAYS.between(location.getDate_debut(), location.getDate_retour());
        int prix = (int) (days * prixJour);
        location.setPrix(prix);
        return locationServiceImp.createLocation(location);
    }


    @GetMapping("/all")
    public List<Location> getallLocation(){
        return locationServiceImp.getAllLocations();
    }


    @GetMapping("/getone/{id}")
    public Location getoneLocation(@PathVariable Long id){
        return locationServiceImp.getLocationByID(id);
    }


    @PutMapping("/update/{id}")
    public Location updateLocation(@PathVariable Long id, @RequestBody Location location){
        Location location1 = locationServiceImp.getLocationByID(id);
        if (location1 != null){
            location.setId(id);
            return locationServiceImp.updateLocation(id, location);
        }else {
            throw new RuntimeException("Failed !!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteLocation(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (locationServiceImp.getLocationByID(id)== null){
            message.put("etat", "location not found");
            return message;
        }
        try {
            locationServiceImp.deleteLocation(id);
            message.put("etat", "location delete");
            return message;
        }catch (Exception e){
            message.put("etat", "loccation not deleted");
            return message;
        }
    }
}
