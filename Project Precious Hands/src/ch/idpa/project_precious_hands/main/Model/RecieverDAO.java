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
public class RecieverDAO implements DAO<Reciever> {

    private final List<Reciever> recievers = new ArrayList<>();
    private static RecieverDAO instance;

    public RecieverDAO() throws SQLException, FileNotFoundException, ClassNotFoundException {
        Database.getInstance().openConnection("", "");
        ResultSet rs = Database.getInstance().getTable("SELECT * FROM preciousdb.donation;");
        while (rs.next()) {
            Reciever c = new Reciever(rs.getInt("ID_Receiver"), rs.getInt("ID_Donor"), rs.getInt("ID_Child"), rs.getInt("ID_DonationPlan"));
            recievers.add(c);
        }
        Database.getInstance().closeConnection();
    }
    
    public static RecieverDAO getInstance(){
        if(instance == null){
            try {
                instance = new RecieverDAO();
            } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
                Logger.getLogger(RecieverDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }

    @Override
    public List<Reciever> findAll() {
        return recievers;
    }

    @Override
    public Reciever findById(int id) {
        for (Reciever reciever : recievers) {
            if (reciever.getDonorID() == id) {
                return reciever;
            }
        }
        return null;
    }

    @Override
    public List<Reciever> findByName(String name) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public boolean update(Reciever t) {
        try {
            recievers.set(recievers.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(Reciever t) {
        try {
            recievers.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Reciever t) {
        try {
            recievers.remove(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int getOpenId() {
        Reciever rec = null;
        for (Reciever i : recievers) {
            rec = i;
        }
        return rec.getRecieverID();
    }

}
