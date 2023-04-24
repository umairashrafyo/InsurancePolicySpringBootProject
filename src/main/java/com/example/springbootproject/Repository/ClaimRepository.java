package com.example.springbootproject.Repository;

import com.example.springbootproject.Entities.Claim;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClaimRepository extends JpaRepository<Claim,Integer> {
}
