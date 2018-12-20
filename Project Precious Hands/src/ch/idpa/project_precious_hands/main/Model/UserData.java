/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

/**
 *
 * @author olive
 */
public class UserData {
    private int userID;
    private String name;
    private String ListName;
    private String password;

    public UserData(int userID, String name, String ListName, String password) {
        this.userID = userID;
        this.name = name;
        this.ListName = ListName;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListName() {
        return ListName;
    }

    public void setListName(String ListName) {
        this.ListName = ListName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
