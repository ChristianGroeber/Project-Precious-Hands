/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author olive
 */
public class Donationplan {

    private int donationPlanID;
    private int amount;
    private int donorID;
    private int childID;
    private Date duration;
    private String interval;
    private Date dateCreated;
    private String sql;

    public Donationplan(int donationPlanID) {
        this.donationPlanID = donationPlanID;
    }

    public Donationplan(int donationPlanID, int amount, int donorID, int childID, Date duration, String interval, Date dateCreated) {
        this.donationPlanID = donationPlanID;
        this.amount = amount;
        this.donorID = donorID;
        this.childID = childID;
        this.duration = duration;
        this.interval = interval;
        this.dateCreated = dateCreated;
    }

    public Donationplan(int amount, int donorID, int childID, Date duration, String interval) {
        this.amount = amount;
        this.donorID = donorID;
        this.childID = childID;
        this.duration = duration;
        this.interval = interval;
        try {
            this.donationPlanID = DonationplanDAO.getInstance().getOpenId(0);
        } catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
        }
    }
    
    public int getDonationPlanID() {
        return donationPlanID;
    }

    public void setDonationPlanID(int donationPlanID) {
        this.donationPlanID = donationPlanID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    String getSql() {
        if(dateCreated == null){
            dateCreated = new java.sql.Date(new java.util.Date().getTime());
        }
        sql = "INSERT INTO `preciousdb`.`donationplan` (`ID_DonationPlan`, `Amount`, `ID_Donor`, `ID_Child`, `Duration`, `Interval`, `DateCreated`) "
                + "VALUES ('" + donationPlanID + "', '" + amount + "', '" + donorID + "', '" + childID + "', '" + duration + "', '," + interval + "', '" + dateCreated + "');";
        return this.sql;
    }

}
