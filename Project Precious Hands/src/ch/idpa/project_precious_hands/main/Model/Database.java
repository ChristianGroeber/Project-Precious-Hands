/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import com.mysql.jdbc.ResultSetMetaData;
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
import java.sql.Types;
import java.util.ArrayList;
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
    private final static String DRIVER_ONLINE = "com.mysql.jdbc.Driver";
    private static Connection connection;
    private static Statement stmt;
    private String query;
    private static ResultSet result;
    private User activeUser;
    private static String username = "";
    private static String password = "";

    private static final String LOCALE_DIRECTORY = "C:/sqlite/db/local.db";
    private static final ArrayList<String> TABLES = new ArrayList<>();

    private Database() throws SQLException {

    }

    public static Database getInstance() throws SQLException, FileNotFoundException, ClassNotFoundException {
        if (instance == null) {
//            try {
//                File data = new File("password");
//                FileReader reader = new FileReader(data);
//                BufferedReader br = new BufferedReader(reader);
//            
//                username = br.readLine();
//                password = br.readLine();
//                br.close();
//            } catch (IOException e) {
//                System.out.println("IOException in Database Class= " + e.getMessage());
//            }
            username = "preciousdb";
            password = "Os1t~T6E!5wi";
            try {
                Class.forName(DRIVER_ONLINE).newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
            connection = DriverManager.getConnection("jdbc:mysql://" + DB_URL, username, password);
            stmt = connection.createStatement();
            instance = new Database();
            fillArray();
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

    public void openConnection(String user, String pass) throws SQLException, ClassNotFoundException {
        try {
            //        connection = DriverManager.getConnection("", "", "");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection = DriverManager.getConnection("jdbc:mysql://" + DB_URL + "/preciousdb", username, password);
        stmt = connection.createStatement();
    }

    public void relog(String user, String pass) throws SQLException, ClassNotFoundException {
        closeConnection();
        openConnection(user, pass);
    }

    public void closeConnection() throws SQLException {
        if (result != null) {
            result.close();
        }
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

    public void connectToDB() {
        try {
            Class.forName(DRIVER_ONLINE).newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://" + DB_URL);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    public void createDatabase(int run) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:" + LOCALE_DIRECTORY);
            DatabaseMetaData meta = conn.getMetaData();
            System.out.println("The driver name is " + meta.getDriverName());
            System.out.println("A new database has been created.");
            createTables(conn);
        } catch (SQLException e) {
            System.out.println("sqlExc: " + e.getMessage());
            try {
                new File(LOCALE_DIRECTORY).mkdirs();
                if (run == 0) {
                    createDatabase(1);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn.close();
        } catch (SQLException | NullPointerException ex) {
        }

    }

    public void createTables(Connection conn) throws SQLException, ClassNotFoundException {
        ArrayList<ResultSetMetaData> meta = getColums();
        for (ResultSetMetaData i : meta) {
            String table = i.getTableName(1);
            ArrayList<String> cols = new ArrayList<>();
            String sql = "CREATE TABLE IF NOT EXISTS " + table + " (\n";
            for (int x = 1; x <= i.getColumnCount(); x++) {
                String col = i.getColumnName(x);
                sql += col;
                int colType = i.getColumnType(x);
                if (colType == Types.VARCHAR || colType == Types.CHAR) {
                    sql += " VARCHAR";
                } else if (colType == Types.BOOLEAN) {
                    sql += " BOOLEAN";
                } else if (colType == Types.INTEGER) {
                    sql += " INTEGER";
                }
                int length = i.getColumnDisplaySize(x);
                sql += "(" + length + ")\n";
            }
            sql += ")";
            System.out.println(sql);
            try {
                stmt = conn.createStatement();
                // create a new table
                stmt.execute(sql);
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        closeConnection();
    }

    private ArrayList<ResultSetMetaData> getColums() throws SQLException, ClassNotFoundException {
        openConnection("", "");
        ArrayList<ResultSetMetaData> meta = new ArrayList<>();
        for (String i : TABLES) {
            try {
                result = stmt.executeQuery("SELECT * FROM " + i);
                ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
                meta.add(rsmd);
                String name = rsmd.getColumnName(1);
            } catch (SQLException e) {
                System.out.println("e = " + e.getMessage());
            }

        }

        return meta;
    }

    private static void fillArray() {
        TABLES.add("child");
        TABLES.add("donation");
        TABLES.add("donationplan");
        TABLES.add("donor");
        TABLES.add("logdata");
        TABLES.add("logentry");
        TABLES.add("receiver");
        TABLES.add("userdata");
    }
}
