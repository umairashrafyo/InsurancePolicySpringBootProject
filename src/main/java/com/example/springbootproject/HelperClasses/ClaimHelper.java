package com.example.springbootproject.HelperClasses;


import com.example.springbootproject.Entities.Claim;
import com.example.springbootproject.Entities.Client;
import com.example.springbootproject.Services.InsurancePolicyService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClaimHelper {


    public ClaimHelper( int number, String description, String date, String status ,int insurancePolicyId) {

        Number = number;
        Description = description;
        this.date = date;
        this.status = status;
        this.insurancePolicyId=insurancePolicyId;
    }

    private int Id;

    private int Number;

    private String Description;
    private String date;

    private String status;
    private int insurancePolicyId;


    public int getInsurancePolicyId() {
        return insurancePolicyId;
    }

    public void setInsurancePolicyId(int insurancePolicyId) {
        this.insurancePolicyId = insurancePolicyId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClaimHelper() {
    }
    public static String dateToString(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateOfbirth = dateFormat.format(date);
        return dateOfbirth;
    }
    public static Date stringToDate(String date){
        try {
            Date dateOfBirth=new SimpleDateFormat("dd-MM-yyyy").parse(date);
            return dateOfBirth;
        } catch (ParseException e) {
            return null;
        }

    }

    public InsurancePolicyService getInsurancePolicyService() {
        return insurancePolicyService;
    }

    public void setInsurancePolicyService(InsurancePolicyService insurancePolicyService) {
        this.insurancePolicyService = insurancePolicyService;
    }

    private InsurancePolicyService insurancePolicyService;
    public Claim toClaim(){
        Claim claim=new Claim();
        claim.setClaimDate(this.stringToDate(this.getDate()));
        claim.setClaimNumber(this.getNumber());
        claim.setClaimDescription(this.getDescription());
        claim.setStatus(this.getStatus());

        claim.setInsurancePolicy((this.getInsurancePolicyService()).getInsurancePolicyById(this.insurancePolicyId));
        return claim;
    }
}