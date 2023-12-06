package com.example.firstapp.Controllers.Client;


import com.example.firstapp.Entity.Client;
import com.example.firstapp.Services.Client.ClientServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private ClientServiceImp clientServiceImp;

    @RequestMapping("/addClient")
    public String addClient(Model model) {
        Client client = new Client();
        model.addAttribute("ClientForm", client);
        return "new_client";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClient(@ModelAttribute("ClientForm") Client client) {
        clientServiceImp.creatClient(client);
        return "redirect:/listClients";
    }

    @RequestMapping("/listClients")
    public String listClients(Model model) {
        List<Client> listClients = clientServiceImp.getAllClient();
        model.addAttribute("listClients", listClients);
        return "liste_clients";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Client client = clientServiceImp.getClientByID(id);
        model.addAttribute("client", client);
        return "update_client";
    }

    @PostMapping("/update/{id}")
    public String updateClient(@PathVariable("id") long id, @Valid @ModelAttribute("client") Client client, BindingResult result) {
        if (result.hasErrors()) {
            return "update_client";
        }

        clientServiceImp.updateClient(client);
        return "redirect:/listClients"; // Redirect to the list of clients after updating.
    }


    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable("id") long id, Model model) {
        clientServiceImp.deleteClient(id);
        model.addAttribute("ListClients", clientServiceImp.getAllClient());
        return "redirect:/listClients";
    }
}
