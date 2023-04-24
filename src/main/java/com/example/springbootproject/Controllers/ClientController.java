package com.example.springbootproject.Controllers;

import com.example.springbootproject.Entities.Client;
import com.example.springbootproject.HelperClasses.ClientHelper;
import com.example.springbootproject.Services.ClientService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Controller
@RequestMapping(value="/client")
public class ClientController {

    final private ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }
    @GetMapping()
    public String getClient(Model model){
        model.addAttribute("clients",clientService.getAllClient());
        return "client";

    }

    @GetMapping(path="/{clientID}")
    public String getClient(@PathVariable Integer clientID,Model model){
        Client client=clientService.getClientById(clientID);

        ClientHelper clientHelper=client.toHelper();
        model.addAttribute("clientHelper",clientHelper);
        return "update_client";
    }
    @GetMapping("/new")
    public String createClientForm(Model model) {

        // create student object to hold student form data
        ClientHelper clientHelper = new ClientHelper();
        model.addAttribute("clientHelper", clientHelper);
        return "create_client";

    }
    //    @GetMapping
//    public String getClient(@RequestParam(value="page") int pageNo,@RequestParam(value="limit") int limitNo){
//        return "client sent: "+pageNo+"limit: "+limitNo;
//    }
    @PostMapping
    public String createClient(@ModelAttribute( "clientHelper") ClientHelper clientHelper,Model model){
        Client client=clientHelper.toClient();

        clientService.createClient(client);
        model.addAttribute("clients", (clientService.getAllClient()));
        return "redirect:/client";
    }
    @PostMapping(path="/{clientID}")
    public String updateClient(@PathVariable Integer clientID,@ModelAttribute("clientHelper") ClientHelper clientHelper,Model model){
//        get client from database by id


        clientHelper.setId(clientID);
        Client cl=clientHelper.toClient();
        clientService.updateClient(cl);
        model.addAttribute("clients", clientService.getAllClient());
        return "redirect:/client";
    }
    @GetMapping(path="/delete/{clientID}")
    public String deleteClient(@PathVariable Integer clientID,Model model){

        clientService.deleteClientById(clientID);
        model.addAttribute("clients", clientService.getAllClient());
        return "redirect:/client";
    }
//    @GetMapping("/students/{id}")
//    public String deleteStudent(@PathVariable Long id) {
//        studentService.deleteStudentById(id);
//        return "redirect:/students";
//    }


}
