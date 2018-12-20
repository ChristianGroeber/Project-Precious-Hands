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
public class LogData {
    private int logEntryID;
    private int logID;

    public LogData(int logEntryID, int logID) {
        this.logEntryID = logEntryID;
        this.logID = logID;
    }

    public int getLogEntryID() {
        return logEntryID;
    }

    public void setLogEntryID(int logEntryID) {
        this.logEntryID = logEntryID;
    }

    public int getLogID() {
        return logID;
    }

    public void setLogID(int logID) {
        this.logID = logID;
    }
    
    
}
