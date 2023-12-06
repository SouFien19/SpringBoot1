package com.example.firstapp.Controllers.Location;

import com.example.firstapp.Entity.Client;
import com.example.firstapp.Entity.Location;
import com.example.firstapp.Entity.Voiture;
import com.example.firstapp.Services.Client.ClientService;
import com.example.firstapp.Services.Location.LocationService;
import com.example.firstapp.Services.Voiture.VoitureService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationController {
    private final LocationService locationService;
    private final ClientService clientService;
    private final VoitureService voitureService;

    public LocationController(LocationService locationService, ClientService clientService, VoitureService voitureService) {
        this.locationService = locationService;
        this.clientService = clientService;
        this.voitureService = voitureService;
    }

    @GetMapping("/add")
    public String createLocation(Model model) {
        List<Client> clients = clientService.getAllClient();
        List<Voiture> voitures = voitureService.getAllVoitures();
        model.addAttribute("location", new Location());
        model.addAttribute("clients", clients);
        model.addAttribute("voitures", voitures);
        return "new_location";
    }

    @PostMapping("/save")
    public String saveLocation(@ModelAttribute Location location) {

        int prixJour = 100; // Fixed prix_jour value
        long days = ChronoUnit.DAYS.between(location.getDate_debut(), location.getDate_retour());
        int prix = (int) (days * prixJour);
        location.setPrix(prix);

        locationService.createLocation(location);
        return "redirect:/locations/liste_locations";
    }

    @GetMapping("/liste_locations")
    public String getAllLocations(Model model) {
        List<Location> locations = locationService.getAllLocations();
        model.addAttribute("locations", locations);
        return "liste_locations";
    }


    @GetMapping("/edit/{id}")
    public String updateLocation(@PathVariable("id") Long id, Model model) {
        Location location = locationService.getLocationByID(id);
        List<Client> clients = clientService.getAllClient();
        List<Voiture> voitures = voitureService.getAllVoitures();
        model.addAttribute("location", location);
        model.addAttribute("clients", clients);
        model.addAttribute("voitures", voitures);
        return "update_location";
    }
    @PostMapping("/update/{id}")
    public String updateLocation(@PathVariable("id") long id, @Valid @ModelAttribute("location") Location location, BindingResult result) {
        if (result.hasErrors()) {
            return "update_location";
        }

        locationService.updateLocation(id, location);
        return "redirect:/locations/liste_locations";
    }
    @GetMapping("/{id}/delete")
    public String deleteLocation(@PathVariable Long id) {
        locationService.deleteLocation(id);
        return "redirect:/locations/liste_locations";
    }



}
