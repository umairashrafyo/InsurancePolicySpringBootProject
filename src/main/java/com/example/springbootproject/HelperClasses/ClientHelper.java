package com.example.springbootproject.HelperClasses;


import com.example.springbootproject.Entities.Client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHelper {
    public ClientHelper( String name, String dateOfBirth, String address, String contact) {

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.contact = contact;
    }

    private int id;

    private String name;

    private String dateOfBirth;

    private String address;

    private String contact;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public ClientHelper() {
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
    public Client toClient(){
        Client client=new Client();
        client.setClientDOB(this.stringToDate(this.dateOfBirth));
        client.setClientName(this.getName());
        client.setContact(this.getContact());
        client.setClientAddress(this.getAddress());
        return client;
    }
}