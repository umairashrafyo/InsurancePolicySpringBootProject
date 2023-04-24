package com.example.springbootproject.Entities;

import com.example.springbootproject.HelperClasses.InsurancePolicyHelper;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="Insurance_Policy_table")
public class InsurancePolicy {
    public InsurancePolicy(int ipId, String insurancePolicyName, String insurancePolicyType, int insurancePolicyAmount, boolean insurancePolicyPremium, Date startDate, Date endDate) {
        this.ipId = ipId;
        InsurancePolicyName = insurancePolicyName;
        InsurancePolicyType = insurancePolicyType;
        InsurancePolicyAmount = insurancePolicyAmount;
        InsurancePolicyPremium = insurancePolicyPremium;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getIpId() {
        return ipId;
    }

    public void setIpId(int ipId) {
        this.ipId = ipId;
    }

    public String getInsurancePolicyName() {
        return InsurancePolicyName;
    }

    public void setInsurancePolicyName(String insurancePolicyName) {
        InsurancePolicyName = insurancePolicyName;
    }

    public String getInsurancePolicyType() {
        return InsurancePolicyType;
    }

    public void setInsurancePolicyType(String insurancePolicyType) {
        InsurancePolicyType = insurancePolicyType;
    }

    public int getInsurancePolicyAmount() {
        return InsurancePolicyAmount;
    }

    public void setInsurancePolicyAmount(int insurancePolicyAmount) {
        InsurancePolicyAmount = insurancePolicyAmount;
    }

    public boolean isInsurancePolicyPremium() {
        return InsurancePolicyPremium;
    }

    public void setInsurancePolicyPremium(boolean insurancePolicyPremium) {
        InsurancePolicyPremium = insurancePolicyPremium;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Id
    @Column(name="InsurancePolicy_id")
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int ipId;
    @Column(name="InsurancePolicyName")
    private String InsurancePolicyName;
    @Column(name="InsurancePolicyType")
    private String InsurancePolicyType;
    @Column(name="InsurancePolicyAmount")
    private int InsurancePolicyAmount;
    @Column(name="InsurancePolicyPremium")
    private boolean InsurancePolicyPremium;
    @Column(name="StartDate")
    private Date startDate;
    @Column(name="EndDate")
    private Date endDate;
    @ManyToOne
    @JoinColumn(name="cl_id")
    private Client client;
    @OneToMany(mappedBy="insurancePolicy",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Claim> claims=new ArrayList<>();

    public void setClient(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public InsurancePolicy() {

    }
    public InsurancePolicyHelper ipToiph(){
        InsurancePolicyHelper iph=new InsurancePolicyHelper();
        iph.setAmount(this.getInsurancePolicyAmount());
        iph.setName(this.getInsurancePolicyName());
        iph.setPremium(this.isInsurancePolicyPremium());
        iph.setType(this.getInsurancePolicyType());
        iph.setEndDate(iph.dateToString(this.getEndDate()));
        iph.setStartDate(iph.dateToString(this.getStartDate()));

        return iph;

    }
}