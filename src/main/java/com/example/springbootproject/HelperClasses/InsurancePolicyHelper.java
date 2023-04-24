package com.example.springbootproject.HelperClasses;

import com.example.springbootproject.Entities.InsurancePolicy;
import com.example.springbootproject.Repository.ClientRepository;
import com.example.springbootproject.Services.ClientService;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsurancePolicyHelper {

    public InsurancePolicyHelper(int ipId, String name, String type, int amount, boolean premium, String startDate, String endDate,int clientId) {
        this.ipId = ipId;
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.premium = premium;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clientId=clientId;
    }

    private int ipId;

        private String name;

        private String type;

        private int amount;

        private boolean premium;

        private String startDate;

        private String endDate;
        private int clientId;
        @Autowired
        private ClientService clientService;

    public InsurancePolicyHelper() {
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getIpId() {
        return ipId;
    }

    public void setIpId(int ipId) {
        this.ipId = ipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
    public InsurancePolicy iphToIp( ){
        InsurancePolicy ip=new InsurancePolicy();
        ip.setEndDate(stringToDate(this.getEndDate()));
        ip.setInsurancePolicyAmount(this.getAmount());
        ip.setInsurancePolicyName(this.getName());
        ip.setStartDate(stringToDate(this.getStartDate()));
        ip.setInsurancePolicyPremium(this.isPremium());
        ip.setInsurancePolicyType(this.getType());
//        System.out.println(this.getClientId());
//        ip.setClient(this.clientService.getClientById(this.getClientId()));
        return ip;
    }
}
