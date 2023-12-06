package com.example.firstapp.Controllers.Voiture;

import com.example.firstapp.Entity.Modeles;
import com.example.firstapp.Entity.Voiture;
import com.example.firstapp.Services.Model.ModeleServiceImp;
import com.example.firstapp.Services.Voiture.VoitureService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/voitures") // Set a base URL path for all mappings in this controller
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    @Autowired
    private ModeleServiceImp serviceImp;


    @GetMapping("/addVoiture")
    public String addVoiture(Model model) {
        Voiture voiture = new Voiture();
        List<Modeles> listModels = serviceImp.getAllModel();
        model.addAttribute("VoitureForm", voiture);
        model.addAttribute("ModelForm", listModels);
        return "new_voiture";
    }

    @PostMapping("/save")
    public String saveVoiture(@Valid  @ModelAttribute("VoitureForm") Voiture voiture, BindingResult result) {
        if (result.hasErrors()) {
            return "new_voiture";
        }

        voitureService.createVoiture(voiture);
        return "redirect:/voitures/listVoitures";
    }

    @GetMapping("/listVoitures")
    public String listVoitures(Model model) {
        List<Voiture> listVoitures = voitureService.getAllVoitures();
        model.addAttribute("listVoitures", listVoitures);
        return "liste_voitures";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Voiture voiture = voitureService.getVoitureById(id);
        model.addAttribute("voiture", voiture);
        return "update_voiture";
    }

    @PostMapping("/update/{id}")
    public String updateVoiture(@PathVariable("id") long id, @Valid @ModelAttribute("voiture") Voiture voiture, BindingResult result) {
        if (result.hasErrors()) {
            return "update_voiture";
        }

        voitureService.updateVoiture(id,voiture);
        return "redirect:/voitures/listVoitures"; // Redirect to the list of voitures after updating.
    }

    @GetMapping("/delete/{id}")
    public String deleteVoiture(@PathVariable("id") long id) {
        voitureService.deleteVoiture(id);
        return "redirect:/voitures/listVoitures";
    }
}
