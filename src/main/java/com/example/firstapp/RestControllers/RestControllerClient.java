package com.example.firstapp.RestControllers;

import com.example.firstapp.Entity.Client;
import com.example.firstapp.Services.Client.ClientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/client")
public class RestControllerClient {

    @Autowired
    private ClientServiceImp clientServiceImp;

    @PostMapping("/save")
    public Client addClient(@RequestBody Client client){
        return clientServiceImp.creatClient(client);
    }

    @PostMapping("/save2")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        try{
            clientServiceImp.creatClient(client);
            return new ResponseEntity<Client>(client, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<Client>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/all")
    public List<Client> getallclient1(){
        return clientServiceImp.getAllClient();
    }

    @GetMapping("/all2")
    public ResponseEntity<List<Client>> getallClient2(){
        try {
            List<Client> clients = clientServiceImp.getAllClient();

            if (clients.isEmpty()){
                return new ResponseEntity<List<Client>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<List<Client>>(clients, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<List<Client>>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/getone/{id}")
    public Client getoneClient(@PathVariable Long id){
        return clientServiceImp.getClientByID(id);
    }

    @GetMapping("/getclient/{id}")
    public ResponseEntity<Client> getclientById(@PathVariable("id") long id){
        Client client = clientServiceImp.getClientByID(id);

        if (client != null){
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        }else {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client){
        Client client1 = clientServiceImp.getClientByID(id);
        if (client1 != null){
            client.setId(id);
            return clientServiceImp.updateClient(client);
        }else {
            throw new RuntimeException("Failed !!!");
        }
    }

    @DeleteMapping("/delete/{id}")
    public HashMap<String, String> deleteClient(@PathVariable Long id){
        HashMap<String, String> message = new HashMap<>();

        if (clientServiceImp.getClientByID(id)== null){
            message.put("etat", "client not found");
            return message;
        }
        try {
            clientServiceImp.deleteClient(id);
            message.put("etat", "client delete");
            return message;
        }catch (Exception e){
            message.put("etat", "client not deleted");
            return message;
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<HttpStatus> deleteclient2(@PathVariable("id") long id){
        try {
            clientServiceImp.deleteClient(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
