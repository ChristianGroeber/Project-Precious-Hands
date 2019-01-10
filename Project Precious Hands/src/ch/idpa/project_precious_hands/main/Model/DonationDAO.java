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
public class DonationDAO implements DAO<Donation>{
    List<Donation> donations = new ArrayList<>();

    @Override
    public List<Donation> findAll() {
        return donations;
    }

    @Override
    public List<Donation> findById(int id) {
        List<Donation> temp = new ArrayList<>();

        for (Donation donation : donations) {
            if (donation.getDonationID() == id) {
                temp.add(donation);
            }
        }
        return temp;
    }

    @Override
    public List<Donation> findByName(String name) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public boolean update(Donation t) {
        try {
            donations.set(donations.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(Donation t) {
        try {
            donations.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Donation t) {
        try {
            donations.remove(t);
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