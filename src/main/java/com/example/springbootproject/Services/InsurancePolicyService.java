package com.example.springbootproject.Services;

import com.example.springbootproject.Entities.InsurancePolicy;
import com.example.springbootproject.Repository.InsurancePolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyService {
    private InsurancePolicyRepository insurancePolicyRepository;

    public InsurancePolicyService(InsurancePolicyRepository insurancePolicyRepository) {
        this.insurancePolicyRepository = insurancePolicyRepository;

    }
    public List<InsurancePolicy> getAllInsurancePolicy() {
        return insurancePolicyRepository.findAll();
    }
    public InsurancePolicy getInsurancePolicyById(int id) {
        return insurancePolicyRepository.findById(id).get();
    }
    public InsurancePolicy createInsurancePolicy(InsurancePolicy insurancePolicy) {

        return insurancePolicyRepository.save(insurancePolicy);
    }
    public InsurancePolicy updateInsurancePolicy(InsurancePolicy insurancePolicy) {

        return insurancePolicyRepository.save(insurancePolicy);
    }
    public void deleteInsurancePolicyById(int id) {

        insurancePolicyRepository.deleteById(id);
        return;
    }


}
