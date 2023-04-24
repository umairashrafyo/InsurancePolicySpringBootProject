package com.example.springbootproject.Entities;

import com.example.springbootproject.HelperClasses.ClaimHelper;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="claims_table")
public class Claim {


    @Id
    @Column(name="claim_id")
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int claimId;
    @Column(name="claimNumber")
    private int claimNumber;
    @Column(name="claimDescription")
    private String claimDescription;
    @Column(name="claimDate")
    private Date claimDate;
    @Column(name="status")
    private String status;
     @ManyToOne
     @JoinColumn(name="ip_id")
     private InsurancePolicy insurancePolicy;

    public InsurancePolicy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public Claim(int claimNumber, String claimDescription, Date claimDate, String status, InsurancePolicy insurancePolicy) {
        this.claimNumber = claimNumber;
        this.claimDescription = claimDescription;
        this.claimDate = claimDate;
        this.status = status;
        this.insurancePolicy = insurancePolicy;
    }

    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public int getClaimNumber() {
        return claimNumber;
    }

    public void setClaimNumber(int claimNumber) {
        this.claimNumber = claimNumber;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = Claim.this.claimDescription;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Claim() {

    }

    public ClaimHelper helper(){
        ClaimHelper helper=new ClaimHelper();
        helper.setDate(helper.dateToString(this.getClaimDate()));
        helper.setDescription(this.getClaimDescription());
        helper.setNumber(this.getClaimNumber());
        helper.setInsurancePolicyId((this.getInsurancePolicy()).getIpId());
        helper.setStatus(this.getStatus());
        return helper;
    }
}
