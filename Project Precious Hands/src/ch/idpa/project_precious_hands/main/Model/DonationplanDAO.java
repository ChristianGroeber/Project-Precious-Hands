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
public class DonationplanDAO implements DAO<Donationplan>{
    
    private List<Donationplan> donationplans = new ArrayList<>();

    @Override
    public List<Donationplan> findAll() {
        return donationplans;
    }

    @Override
    public List<Donationplan> findById(int id) {
        List<Donationplan> temp = new ArrayList<>();

        for (Donationplan donationplan : donationplans) {
            if (donationplan.getDonationPlanID() == id) {
                temp.add(donationplan);
            }
        }
        return temp;
    }

    @Override
    public List<Donationplan> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Donationplan t) {
        try {
            donationplans.set(donationplans.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(Donationplan t) {
        try {
            donationplans.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Donationplan t) {
        try {
            donationplans.remove(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
