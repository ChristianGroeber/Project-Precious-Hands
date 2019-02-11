/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olive
 */
public class Donation {

    private int donationID;
    private int donationplanID;
    private Date receptionDate;
    private String sql;

    public Donation() {
    }

    public Donation(int donationID, int donationplanID, Date receptionDate) {
        this.donationID = donationID;
        this.donationplanID = donationplanID;
        this.receptionDate = receptionDate;
    }

    public Donation(int donationplanID, Date receptionDate) {
        this.donationplanID = donationplanID;
        this.receptionDate = receptionDate;
        this.donationID = DonationDAO.getInstance().getOpenId(1);
    }
    

    public int getDonationID() {
        return donationID;
    }

    public void setDonationID(int donationID) {
        this.donationID = donationID;
    }

    public int getDonationplanID() {
        return donationplanID;
    }

    public void setDonationplanID(int donationplanID) {
        this.donationplanID = donationplanID;
    }

    public Date getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public String getSql() {
        sql = "INSERT INTO `preciousdb`.`donation` ('ID_Donation', 'ReceptionDate', 'ID_Donationplan') VALUES ('" + donationID + "', '" + receptionDate + "', '" + donationplanID + "');";
        return sql;
    }

}
