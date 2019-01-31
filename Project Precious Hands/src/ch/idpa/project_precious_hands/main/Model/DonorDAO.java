/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olive
 */
public class DonorDAO implements DAO<Donor> {

    private final List<Donor> donors = new ArrayList<>();
    private static DonorDAO instance;

    public DonorDAO() throws SQLException, FileNotFoundException, ClassNotFoundException {
        Database.getInstance().openConnection("", "");
        ResultSet rs = Database.getInstance().getTable("SELECT * FROM preciousdb.donor;");
        while (rs.next()) {
            Donor c = new Donor(rs.getInt("ID_Donor"), rs.getString("Name"), rs.getString("LastName"), rs.getString("Street"), rs.getString("Postal_Code"), rs.getString("City"), rs.getString("Email"), rs.getString("Phone"));
            donors.add(c);
        }
        Database.getInstance().closeConnection();
    }
    
    public static DonorDAO getInstance(){
        if(instance == null){
            try {
                instance = new DonorDAO();
            } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
                Logger.getLogger(DonorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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
