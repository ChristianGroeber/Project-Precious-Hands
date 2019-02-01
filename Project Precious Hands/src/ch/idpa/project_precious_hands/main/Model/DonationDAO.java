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
public class DonationDAO implements DAO<Donation> {

    List<Donation> donations = new ArrayList<>();
    private static DonationDAO instance;

    public DonationDAO() throws SQLException, FileNotFoundException, ClassNotFoundException {
        Database.getInstance().openConnection("", "");
        ResultSet rs = Database.getInstance().getTable("SELECT * FROM preciousdb.donation;");
        while (rs.next()) {
            Donation c = new Donation(rs.getInt("ID_Donation"), rs.getInt("ID_Donationplan"), rs.getDate("ReceptionDate"));
            donations.add(c);
        }
        Database.getInstance().closeConnection();
    }

    public static DonationDAO getInstance() {
        if (instance == null) {
            try {
                instance = new DonationDAO();
            } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
                Logger.getLogger(DonationDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }

    @Override
    public List<Donation> findAll() {
        return donations;
    }

    @Override
    public Donation findById(int id) {
        for (Donation donation : donations) {
            if (donation.getDonationID() == id) {
                return donation;
            }
        }
        return null;
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
            String sql = t.getSql();
            Database db = Database.getInstance();
            db.openConnection("", "");
            db.getStatement().executeUpdate(sql);
            db.closeConnection();
            return true;
        } catch (FileNotFoundException | ClassNotFoundException | SQLException e) {
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

    public int getOpenId(int id) {
        if (findById(id) != null) {
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
