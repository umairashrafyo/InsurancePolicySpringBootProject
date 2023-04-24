package com.example.springbootproject.Repository;

import com.example.springbootproject.Entities.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Integer> {
}
