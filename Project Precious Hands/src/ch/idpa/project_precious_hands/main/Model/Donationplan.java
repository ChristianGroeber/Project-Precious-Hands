/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

/**
 *
 * @author olive
 */
public class Donationplan {
    private int donationPlanID;
    private String description;

    public Donationplan(int donationPlanID, String description) {
        this.donationPlanID = donationPlanID;
        this.description = description;
    }

    public int getDonationPlanID() {
        return donationPlanID;
    }

    public void setDonationPlanID(int donationPlanID) {
        this.donationPlanID = donationPlanID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
