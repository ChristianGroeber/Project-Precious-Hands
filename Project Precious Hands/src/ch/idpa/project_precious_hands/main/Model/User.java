/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.sql.Date;

/**
 *
 * @author olive
 */
public class User {
    private int userID;
    private String name;
    private String surname;
    private String password;
    private boolean isAdmin;
    private final Date dateAdded;

    public User(int UserID, String name, String surname, String password, Date dateAdded, boolean isAdmin) {
        this.userID = UserID;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.isAdmin = isAdmin;
        this.dateAdded = dateAdded;
    }

    public User(int UserID, String name, String surname, Date dateAdded, boolean isAdmin) {
        this.userID = UserID;
        this.name = name;
        this.surname = surname;
        this.isAdmin = isAdmin;
        this.dateAdded = dateAdded;
    }

    public User(String name, String surname, String password, Date dateAdded, boolean isAdmin) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.isAdmin = isAdmin;
        this.dateAdded = dateAdded;
        userID = UserDAO.getInstance().getOpenId(1);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int UserID) {
        this.userID = UserID;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    
    public Date getDateAdded(){
        return this.dateAdded;
    }
    
    public String getSql(){
        String adm = "0";
        if(isAdmin){
            adm = "1";
        }
        return "INSERT INTO `preciousdb`.`userdata` (`ID_User`, `Name`, `LastName`, `Passwort`, `Is_Admin`, `DateAdded`) "
                + "VALUES ('" + userID + "', '" + surname + "', '" + name + "', '" + password + "', '" + adm + "', '" + dateAdded + "');";
    }
}
