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
public class UserDAO implements DAO<User> {

    List<User> users = new ArrayList<>();
    private static UserDAO instance;

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    public boolean correctValues(String username, String password) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String query = "SELECT ID_User FROM preciousdb.userdata WHERE Passwort = '" + password + "' AND Name = '" + username + "'";
        Database db = Database.getInstance();
        db.openConnection("", "");
        ResultSet rs = Database.getInstance().getTable(query);
        rs.next();
        try {
            System.out.println(rs.getInt("ID_User"));
            db.closeConnection();
            return true;
        } catch (SQLException e) {
            System.out.println("Error while logging in " + e.getMessage());
            return false;
        }
    }

    @Override
    public User findById(int id) {
        for (User user : users) {
            if (user.getUserID() == id) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> temp = new ArrayList<>();

        for (User user : users) {
            if (user.getName().equals(name)) {
                temp.add(user);
            }
        }
        return temp;
    }

    @Override
    public boolean update(User t) {
        try {
            users.set(users.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(User t) {
        try {
            users.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(User t) {
        try {
            users.remove(t);
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
