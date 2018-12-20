/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.util.Date;

/**
 *
 * @author chris
 */
public class Donation {
    private Child toDonate;
    private Donor donor;
    private double amount;
    private Date dateCreated;

    public Donation(Child toDonate, Donor donor, double amount) {
        this.toDonate = toDonate;
        this.donor = donor;
        this.amount = amount;
    }

    public Donation() {
    }
    
    

    public Child getToDonate() {
        return toDonate;
    }

    public void setToDonate(Child toDonate) {
        this.toDonate = toDonate;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    
    
    
}
