package com.example.springbootproject.Entities;

import com.example.springbootproject.HelperClasses.ClientHelper;
import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="client_table")
public class Client {
    public Client(int clientId, String clientName, Date clientDOB, String clientAddress, String contact) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientDOB = clientDOB;
        this.clientAddress = clientAddress;
        this.contact = contact;
    }

    @Id
    @Column(name="client_id")
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int clientId;
    @Column(name="clientName")
    private String clientName;
    @Column(name="clientDOB")
    private Date clientDOB;
    @Column(name="clientAddress")
    private String clientAddress;
    @Column(name="contact")
    private String contact;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private List<InsurancePolicy> insurancePolicyList=new ArrayList<>();


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Date getClientDOB() {
        return clientDOB;
    }

    public void setClientDOB(Date clientDOB) {
        this.clientDOB = clientDOB;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Client() {

    }
    public ClientHelper toHelper(){
        ClientHelper helper=new ClientHelper();
        helper.setAddress(this.getClientAddress());
        helper.setContact(this.getContact());
        helper.setName(this.getClientName());
        helper.setDateOfBirth(helper.dateToString(this.getClientDOB()));
        return helper;
    }
}