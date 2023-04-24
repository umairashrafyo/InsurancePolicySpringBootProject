package com.example.springbootproject.Controllers;

import com.example.springbootproject.Entities.Client;
import com.example.springbootproject.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring6.SpringTemplateEngine;



@RestController
@RequestMapping("/")
public class HomeController {


    @GetMapping
    public String getClient(Model model){

        return "home";
    }


}
