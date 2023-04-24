package com.example.springbootproject.Controllers;

import com.example.springbootproject.Entities.Client;
import com.example.springbootproject.Entities.InsurancePolicy;
import com.example.springbootproject.HelperClasses.ClientHelper;
import com.example.springbootproject.HelperClasses.InsurancePolicyHelper;
import com.example.springbootproject.Services.ClientService;
import com.example.springbootproject.Services.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.lang.*;


@Controller
@RequestMapping("/insurancepolicy")
public class InsurancePolicyController {
    private InsurancePolicyService insurancePolicyService;
    private final ClientService clientService;

    @Autowired
    public InsurancePolicyController(InsurancePolicyService insurancePolicyService, ClientService clientService){
        this.insurancePolicyService=insurancePolicyService;
        this.clientService = clientService;
    }
    @GetMapping
    public String getInsurancePolicy(Model model){
        model.addAttribute("insurancepolcies",insurancePolicyService.getAllInsurancePolicy());
        return "insurancepolicy";
    }
    @GetMapping(path="/{insurancePolicyID}")
    public String getInsurancePolicy(@PathVariable Integer insurancePolicyID,Model model){
        InsurancePolicy insurancePolicy=insurancePolicyService.getInsurancePolicyById(insurancePolicyID);
        InsurancePolicyHelper insurancePolicyHelper=insurancePolicy.ipToiph();
        model.addAttribute("insurancePolicyHelper",insurancePolicyHelper);
        return "update_insurancepolicy";
    }
    @GetMapping(path="/new/{clientID}")
    public String getClient(@PathVariable("clientID") Integer clientID,Model model){
        InsurancePolicyHelper insurancePolicyHelper=new InsurancePolicyHelper();
        insurancePolicyHelper.setClientId(clientID);
        System.out.println(insurancePolicyHelper.getClientId());
        model.addAttribute("insurancePolicyHelper",insurancePolicyHelper);


//        model.addAttribute("clientID",clientID);
//        model.addAttribute("clientName",clientName);
        return "create_insurancepolicy";
    }


    @PostMapping("/create/{clientID}")
    public String createInsurancePolicy(@PathVariable("clientID") Integer clientID,@ModelAttribute( "insurancePolicyHelper") InsurancePolicyHelper insurancePolicyHelper,Model model){
        System.out.println(clientID);
        InsurancePolicy insurancePolicy=insurancePolicyHelper.iphToIp();
        System.out.println(insurancePolicy.getInsurancePolicyName());
        System.out.println(clientID);

        try {
            insurancePolicy.setClient(clientService.getClientById(clientID));
            System.out.println(clientID);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        insurancePolicyService.createInsurancePolicy(insurancePolicy);

        model.addAttribute("insurancePolicy",insurancePolicyService.getAllInsurancePolicy());
        return "redirect:/insurancepolicy";
    }
    @PostMapping(path="/{insurancePolicyID}")
    public String updateInsurancePolicy(@PathVariable Integer insurancePolicyID,@ModelAttribute("insurancePolicyHelper") InsurancePolicyHelper insurancePolicyHelper,Model model){
//        get insurancePolicy from database by id
        InsurancePolicy existingInsurancePolicy=insurancePolicyService.getInsurancePolicyById(insurancePolicyID);

        insurancePolicyHelper.setIpId(insurancePolicyID);
        InsurancePolicy insurancePolicy=insurancePolicyHelper.iphToIp();

        insurancePolicyService.updateInsurancePolicy(insurancePolicy);
        model.addAttribute("insurancePolicy",insurancePolicyService.getAllInsurancePolicy());
        return "redirect:/insurancePolicy";
    }
    @GetMapping(path="/delete/{insurancePolicyID}")
    public String deleteInsurancePolicy(@PathVariable Integer insurancePolicyID,Model model){
        insurancePolicyService.deleteInsurancePolicyById(insurancePolicyID);
        model.addAttribute("insurancePolicy",insurancePolicyService.getAllInsurancePolicy());
        return "redirect:/insurancePolicy";
    }

}
