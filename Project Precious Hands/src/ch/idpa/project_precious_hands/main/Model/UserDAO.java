/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import ch.idpa.project_precious_hands.main.ShowProgress;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author olive
 */
public class UserDAO implements DAO<User> {

    List<User> users = new ArrayList<>();
    private static UserDAO instance;
    private static User loggedInUser;

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }

    private void usersArray() throws SQLException, FileNotFoundException, ClassNotFoundException {
        Database.getInstance().openConnection("", "");
        ResultSet rs = Database.getInstance().getTable("SELECT * FROM preciousdb.userdata WHERE allowed = '1'");
        while (rs.next()) {
            User c = new User(rs.getInt("ID_User"), rs.getString("Name"), rs.getString("LastName"), rs.getDate("DateAdded"), rs.getBoolean("Is_Admin"));
            users.add(c);
        }
        Database.getInstance().closeConnection();

    }

    private void loginUser(ResultSet rs) throws SQLException {
        User u = new User(rs.getInt("ID_User"), rs.getString("Name"), rs.getString("LastName"), rs.getDate("DateAdded"), rs.getBoolean("Is_Admin"));
        loggedInUser = u;
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    public boolean correctValues(String username, String password) throws SQLException, FileNotFoundException, ClassNotFoundException {
        String query = "SELECT * FROM preciousdb.userdata WHERE Passwort = '" + password + "' AND Name = '" + username + "' AND allowed = '1'";
        Database db = Database.getInstance();
        db.openConnection("", "");
        ResultSet rs = Database.getInstance().getTable(query);
        rs.next();
        try {
            System.out.println(rs.getInt("ID_User") + ", " + rs.getBoolean("Is_Admin"));
            new ShowProgress().showProgress();
            loginUser(rs);
            db.closeConnection();
            if (loggedInUser.isAdmin()) {
                usersArray();
            }
            return true;
        } catch (SQLException e) {
            System.out.println("Error while logging in " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Wrong password or username, please try again.");
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

    public int getOpenId(int id) {
        if (findById(id) != null) {
            id++;
            return getOpenId(id);
        }
        return id;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void logoutUser() {
        loggedInUser = null;
    }

    public void disallowUser(int userID) {
        try {
            String query = "UPDATE `preciousdb`.`userdata` SET `allowed`='0' WHERE `ID_User`='" + userID + "'";
            Database db = Database.getInstance();
            db.openConnection("", "");
            db.getStatement().execute(query);
            db.closeConnection();
        } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
