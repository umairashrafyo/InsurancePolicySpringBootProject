package com.example.springbootproject.Controllers;

import com.example.springbootproject.Entities.Claim;
import com.example.springbootproject.Services.ClaimService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/claim")
public class ClaimController {
    private ClaimService claimService;
    public ClaimController(ClaimService claimService){
        this.claimService=claimService;
    }
    @GetMapping
    public String getClaim(Model model){
        model.addAttribute("claims",claimService.getAllClaim());
        return "claim";
    }
    @GetMapping(path="/{claimID}")
    public String getClaim(@PathVariable Integer claimID,Model model){
        model.addAttribute("claim",claimService.getClaimById(claimID));
        return "claim";
    }
    @GetMapping("/new")
    public String createClaimForm(Model model) {

        // create student object to hold student form data
        Claim claim = new Claim();
        model.addAttribute("claim", claim);
        return "create_claim";

    }
//    @GetMapping
//    public String getClaim(@RequestParam(value="page") int pageNo,@RequestParam(value="limit") int limitNo){
//        return "claim sent: "+pageNo+"limit: "+limitNo;
//    }
    @PostMapping
    public String createClaim(@ModelAttribute( "claim") Claim claim){
        System.out.println(claim.getClaimDescription());
        claimService.createClaim(claim);
        return "redirect:/claim";
    }
    @PutMapping(path="/{claimID}")
    public String updateClaim(@PathVariable Integer claimID,@ModelAttribute("claim") Claim claim,Model model){
//        get claim from database by id
        Claim existingClaim=claimService.getClaimById(claimID);
        existingClaim.setClaimDate(claim.getClaimDate());
        existingClaim.setClaimNumber(claim.getClaimNumber());
        existingClaim.setClaimDescription(claim.getClaimDescription());
        existingClaim.setStatus(claim.getStatus());
        claimService.updateClaim(existingClaim);
        return "redirect:/claim";
    }
    @DeleteMapping(path="/{claimID}")
    public String deleteClaim(@PathVariable Integer claimID){
        claimService.deleteClaimById(claimID);

        return "redirect:/claim";
    }

}
