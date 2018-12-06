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
public class LogEntry {
    public int LogEntryID;
    public int UserID;
    public int RecieverID;
    public int DonorID;
    public Date EntryDate;

    public int getLogEntryID() {
        return LogEntryID;
    }

    public void setLogEntryID(int LogEntryID) {
        this.LogEntryID = LogEntryID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public int getRecieverID() {
        return RecieverID;
    }

    public void setRecieverID(int RecieverID) {
        this.RecieverID = RecieverID;
    }

    public int getDonorID() {
        return DonorID;
    }

    public void setDonorID(int DonorID) {
        this.DonorID = DonorID;
    }

    public Date getEntryDate() {
        return EntryDate;
    }

    public void setEntryDate(Date EntryDate) {
        this.EntryDate = EntryDate;
    }
    
    
}
