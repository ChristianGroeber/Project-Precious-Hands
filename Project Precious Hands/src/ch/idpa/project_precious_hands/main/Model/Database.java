/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olive
 */
public class Database {

    private static Database instance;

    private static String DB_URL = "den1.mysql3.gear.host";
    private static Connection connection;
    private static Statement stmt;
    private String query;
    private ResultSet result;
    private User activeUser;
    private static String username = "";
    private static String password = "";

    private static final String LOCALE_DIRECTORY = "C:/sqlite/db/local.db";

    private Database() throws SQLException {

    }

    public static Database getInstance() throws SQLException, FileNotFoundException, ClassNotFoundException {
        if (instance == null) {
            try {
                File data = new File("password");
                FileReader reader = new FileReader(data);
                BufferedReader br = new BufferedReader(reader);
            
                username = br.readLine();
                password = br.readLine();
                br.close();
            } catch (IOException e) {
                System.out.println("IOException in Database Class= " + e.getMessage());
            }
            Class.forName("com.mysql.jdbc.Driver"); 
            connection = DriverManager.getConnection(DB_URL, username, password);
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

    public void openConnection(String user, String pass) throws SQLException {
        connection = DriverManager.getConnection("", "", "");
        stmt = connection.createStatement();
        connection = DriverManager.getConnection(DB_URL, user, pass);
    }

    public void relog(String user, String pass) throws SQLException {
        closeConnection();
        openConnection(user, pass);
    }

    public void closeConnection() throws SQLException {
        result.close();
        stmt.close();
        connection.close();
    }

    public ResultSet getTable(String query) throws SQLException {
        result = stmt.executeQuery(query);
        return result;
    }

    public void donate(Donor donor, Reciever reciever, double sum) throws SQLException {
        query = "UPDATE donor SET" + sum + "WHERE name = '" + donor.getName() + "' AND surname ='" + donor.getLastName() + "'";
        result = stmt.executeQuery(query);

        query = "";
        result = stmt.executeQuery("");
    }

    public void createDatabse() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + LOCALE_DIRECTORY);
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println("sqlExc: " + e.getMessage());
            try {
                new File(LOCALE_DIRECTORY).mkdirs();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void createTables() throws SQLException {
        result = stmt.executeQuery("Select * From sys.tables");
        while (result.next()) {
            System.out.println(result.next());
        }
    }
}
