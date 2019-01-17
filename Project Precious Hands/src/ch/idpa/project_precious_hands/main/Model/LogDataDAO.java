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
public class LogDataDAO implements DAO<LogData>{

    private List<LogData> logData = new ArrayList<>();
    
    @Override
    public List<LogData> findAll() {
        return logData;
    }

    @Override
    public List<LogData> findById(int id) {
        List<LogData> temp = new ArrayList<>();

        for (LogData loggedData : logData) {
            if (loggedData.getLogID() == id) {
                temp.add(loggedData);
            }
        }
        return temp;
    }

    @Override
    public List<LogData> findByName(String name) {
        throw new UnsupportedOperationException("Not supported");
    }

    @Override
    public boolean update(LogData t) {
        try {
            logData.set(logData.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(LogData t) {
        try {
            logData.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(LogData t) {
        try {
            logData.remove(t);
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
