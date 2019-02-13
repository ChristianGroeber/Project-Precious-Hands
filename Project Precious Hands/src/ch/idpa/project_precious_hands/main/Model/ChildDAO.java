/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olive
 */
public class ChildDAO implements DAO<Child> {

    private List<Child> children = new ArrayList<>();
    private static ChildDAO instance;

    public ChildDAO() throws SQLException, FileNotFoundException, ClassNotFoundException {
        Database.getInstance().openConnection("", "");
        ResultSet rs = Database.getInstance().getTable("SELECT * FROM preciousdb.child WHERE allowed = '1'");
        while (rs.next()) {
            //            InputStream in = rs.getBlob("Image").getBinaryStream();
            InputStream in = null;
            BufferedImage img = null;
            //                img = ImageIO.read(in);
            Child c = new Child(rs.getInt("ID_Child"), rs.getString("Name"), rs.getString("LastName"), rs.getString("Gender").charAt(0), rs.getDate("Birthday"), img);
            children.add(c);
        }
        Database.getInstance().closeConnection();
    }
    
    public static ChildDAO getInstance() throws ParseException{
        if(instance == null){
            try {
                instance = new ChildDAO();
            } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
                Logger.getLogger(ChildDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return instance;
    }

    @Override
    public List<Child> findAll() {
        return children;
    }

    @Override
    public Child findById(int id) {
        for (Child child : children) {
            if (child.getChildID() == id) {
                return child;
            }
        }
        return null;
    }

    @Override
    public List<Child> findByName(String name) {
        List<Child> temp = new ArrayList<>();

        for (Child child : children) {
            if (child.getName().equals(name)) {
                temp.add(child);
            }
        }
        return temp;
    }

    @Override
    public boolean update(Child t) {
        try {
            children.set(children.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(Child t) {
        try {
            children.add(t);
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
    public boolean delete(Child t) {
        try {
            children.remove(t);
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
