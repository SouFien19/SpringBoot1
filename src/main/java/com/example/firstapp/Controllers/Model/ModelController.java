package com.example.firstapp.Controllers.Model;

import com.example.firstapp.Entity.Modeles;
import com.example.firstapp.Services.Model.ModeleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModeleServiceImp modeleServiceImp;


    @GetMapping("/getoneModele/{Nom}")
    public Modeles getonemodele(@PathVariable("Nom") String nom){
        return modeleServiceImp.getModelByNom(nom);
    }

    @RequestMapping("/addmodel")
    public String addModels(Model model){
        Modeles modele = new Modeles();
        model.addAttribute("ModelForm", modele);
        return "new_model";
    }

    @RequestMapping(value = "/savemodel", method = RequestMethod.POST)
    public String savemodel(@ModelAttribute("ModelForm") Modeles modele) {
        modeleServiceImp.creatModel(modele);

        return "redirect:/models/listmodels";
    }

    @RequestMapping("/listmodels")
    public String getallmodele(Model model){
        List<Modeles> listModels = modeleServiceImp.getAllModel();
        model.addAttribute("listModels", listModels);
        return "liste_model";
    }

    @GetMapping("edit/{id}")
    public String showUpdateModel(@PathVariable("id") long id, Model model){
        Modeles modele = modeleServiceImp.getModelByID(id);
        model.addAttribute("modele", modele);
        return "update_model";
    }

    @PostMapping("update/{id}")
    public String updatemodele(@PathVariable("id") long id, @Validated Modeles modele, BindingResult result, Model model){

        if (result.hasErrors()){
            modele.setId(id);
            return "update_models";
        }
        modeleServiceImp.updateModel(modele);
        model.addAttribute("modele", modeleServiceImp.getAllModel());
        return "redirect:/models/listmodels";
    }



    @GetMapping("deleteModel/{id}")
    public String deletemodele(@PathVariable("id") long id, Model model){

        modeleServiceImp.deleteModel(id);
        model.addAttribute("modele", modeleServiceImp.getAllModel());
        return "redirect:/models/listmodels";
    }

}