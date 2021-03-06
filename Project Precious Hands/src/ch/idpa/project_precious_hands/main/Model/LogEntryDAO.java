/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olive
 */
public class LogEntryDAO implements DAO<LogEntry>{
    List<LogEntry> logEntries = new ArrayList<>();

    @Override
    public List<LogEntry> findAll() {
        return logEntries;
    }

    @Override
    public LogEntry findById(int id) {
        for (LogEntry logEntry : logEntries) {
            if (logEntry.getLogEntryID() == id) {
                return logEntry;
            }
        }
        return null;
    }

    @Override
    public List<LogEntry> findByName(String name) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean update(LogEntry t) {
        try {
            logEntries.set(logEntries.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(LogEntry t) {
        try {
            logEntries.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(LogEntry t) {
        try {
            logEntries.remove(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int getOpenId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
