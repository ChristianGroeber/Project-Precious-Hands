/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.util.Date;

/**
 *
 * @author olive
 */
public class Donation {
    private int donationID;
    private int donorID;
    private int recieverID;
    private int amount;
    private Date receptionDate;

    public Donation(int donationID, int donorID, int recieverID, int amount, Date receptionDate) {
        this.donationID = donationID;
        this.donorID = donorID;
        this.recieverID = recieverID;
        this.amount = amount;
        this.receptionDate = receptionDate;
    }
    
    public int getDonationID() {
        return donationID;
    }

    public void setDonationID(int donationID) {
        this.donationID = donationID;
    }

    public int getDonorID() {
        return donorID;
    }

    public void setDonorID(int donorID) {
        this.donorID = donorID;
    }

    public int getRecieverID() {
        return recieverID;
    }

    public void setRecieverID(int recieverID) {
        this.recieverID = recieverID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }
    
    
}
