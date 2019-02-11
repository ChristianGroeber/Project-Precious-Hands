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
public class Reciever {
    private int recieverID;
    private int donorID;
    private int childID;
    private int donationPlanID;

    public Reciever(int recieverID, int donorID, int childID, int donationPlanID) {
        this.recieverID = recieverID;
        this.donorID = donorID;
        this.childID = childID;
        this.donationPlanID = donationPlanID;
    }
    
    public int getRecieverID() {
        return recieverID;
    }

    public void setRecieverID(int recieverID) {
        this.recieverID = recieverID;
    }

    public int getDonorID() {
        return donorID;
    }

    public void setDonorID(int donorID) {
        this.donorID = donorID;
    }

    public int getChildID() {
        return childID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
    }
}
