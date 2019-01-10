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
public class DonorDAO implements DAO<Donor>{
    
    private List<Donor> donors = new ArrayList<>();
    private static DonorDAO instance;
    
    public static DonorDAO getInstance(){
        if(instance == null){
            instance = new DonorDAO();
        }
        return instance;
    }

    @Override
    public List<Donor> findAll() {
        return donors;
    }

    @Override
    public List<Donor> findById(int id) {
        List<Donor> temp = new ArrayList<>();
        
        for (Donor donor : donors) {
            if (donor.getDonorID() == id) {
                temp.add(donor);
            }
        }
        return temp;
    }

    @Override
    public List<Donor> findByName(String name) {
        List<Donor> temp = new ArrayList<>();
        
        for (Donor donor : donors) {
            if (donor.getName().equals(name)) {
                temp.add(donor);
            }
        }
        return temp;
    }

    @Override
    public boolean update(Donor t) {
        try {
            donors.set(donors.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(Donor t) {
        try {
            donors.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Donor t) {
        try {
            donors.remove(t);
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
