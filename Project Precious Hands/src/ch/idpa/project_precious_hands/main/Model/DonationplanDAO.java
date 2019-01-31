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

/**
 *
 * @author olive
 */
public class DonationplanDAO implements DAO<Donationplan>{
    
    private List<Donationplan> donationplans = new ArrayList<>();
    private static DonationplanDAO instance;
    
    public DonationplanDAO() throws SQLException, FileNotFoundException, ClassNotFoundException {
        Database.getInstance().openConnection("", "");
        ResultSet rs = Database.getInstance().getTable("SELECT * FROM preciousdb.donationplan;");
        while (rs.next()) {
            Donationplan c = new Donationplan(rs.getInt("ID_DonationPlan"), rs.getInt("Amount"), rs.getInt("ID_Donor"), rs.getInt("ID_Child"), rs.getDate("Duration"), rs.getString("Interval"), rs.getDate("DateCreated"));
            donationplans.add(c);
        }
        Database.getInstance().closeConnection();
    }

    
    public static DonationplanDAO getInstance() throws SQLException, FileNotFoundException, ClassNotFoundException{
        if(instance == null){
            instance = new DonationplanDAO();
        }
        return instance;
    }

    @Override
    public List<Donationplan> findAll() {
        return donationplans;
    }

    @Override
    public Donationplan findById(int id) {
        for (Donationplan donationplan : donationplans) {
            if (donationplan.getDonationPlanID() == id) {
                return donationplan;
            }
        }
        return null;
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
            String sql = t.getSql();
            Database db = Database.getInstance();
            db.openConnection("", "");
            db.getStatement().executeUpdate(sql);
            db.closeConnection();
            return true;
        } catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
            System.out.println("Error while inserting: " + e.toString());
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

    public int getOpenId(int id) {
        if(findById(id) != null){
            id++;
            return getOpenId(id);
        }
        return id;
    }

    @Override
    public int getOpenId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
