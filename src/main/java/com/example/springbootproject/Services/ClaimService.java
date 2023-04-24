package com.example.springbootproject.Services;

import com.example.springbootproject.Entities.Claim;
import com.example.springbootproject.Repository.ClaimRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class ClaimService {
    private ClaimRepository claimRepository;

    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;

    }
    public List<Claim> getAllClaim() {
        return claimRepository.findAll();
    }
    public Claim getClaimById(int id) {
        return claimRepository.findById(id).get();
    }
    public Claim createClaim(Claim claim) {

        return claimRepository.save(claim);
    }
    public Claim updateClaim(Claim claim) {

        return claimRepository.save(claim);
    }
    public void deleteClaimById(int id) {

        claimRepository.deleteById(id);
        return;
    }


}