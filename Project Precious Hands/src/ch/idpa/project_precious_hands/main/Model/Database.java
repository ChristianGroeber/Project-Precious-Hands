/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

/**
 *
 * @author olive
 */
public class Database {
    
    private static Database instance;

    private String DB_URL = "den1.mysql3.gear.host";
    private static Connection connection;
    private static Statement stmt;
    private String query;
    private ResultSet result;
    private User activeUser;

    private Database() throws SQLException {
        
    }
    
    public static Database getInstance() throws SQLException{
        if(instance == null){
            connection = DriverManager.getConnection("", "", "");
            stmt = connection.createStatement();
            instance = new Database();
            return instance;
        }
        return instance;
    }

    private void getUser() throws SQLException {
        query = "select from User";
        result = stmt.executeQuery(query);
        while (result.next()) {

        }

    }
    
    public void openConnection(String user, String pass) throws SQLException{
        connection = DriverManager.getConnection("", "", "");
        stmt = connection.createStatement();
        connection = DriverManager.getConnection(DB_URL,user,pass);
    }
    
    public void relog(String user, String pass) throws SQLException{
        closeConnection();
        openConnection(user, pass);
    }
    
    public void closeConnection() throws SQLException{
        result.close();
        stmt.close();
        connection.close();
    }
    
    public ResultSet getTable(String query) throws SQLException{
        result = stmt.executeQuery(query);
        return result;
    }
    
    public Table findSingleEntryById(String type, HashMap<String, String> arguments){
        int id;
        query = "Select * From '" + type + "' WHERE ";
        if(arguments.containsKey("id")){
            query += "ID" + type + "=" + arguments.get("id") + " ";
        }
        if(arguments.containsKey("name")){
            query += "Name=" + arguments.get("name") + " ";
        }
        query = "SELECT ";
    }
    
    public void donate(Donor donor, Reciever reciever, double sum) throws SQLException{
        query = "UPDATE donor SET" + sum + "WHERE name = '" + donor.getName() +"' AND surname ='" + donor.getLastName() +"'";
        result = stmt.executeQuery(query);
        
        query = "";
        result = stmt.executeQuery("");
    }
}

