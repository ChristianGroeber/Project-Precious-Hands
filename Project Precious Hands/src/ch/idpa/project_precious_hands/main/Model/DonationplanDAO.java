/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olive
 */
public class DonationplanDAO implements DAO<Donationplan> {

    private List<Donationplan> donationplans = new ArrayList<>();
    private static DonationplanDAO instance;

    public DonationplanDAO() throws SQLException, FileNotFoundException, ClassNotFoundException {
        Database.getInstance().openConnection("", "");
        ResultSet rs = Database.getInstance().getTable("SELECT * FROM preciousdb.donationplan WHERE allowed = '1'");
        while (rs.next()) {
            Donationplan c = new Donationplan(rs.getInt("ID_DonationPlan"), rs.getInt("Amount"), rs.getInt("ID_Donor"), rs.getInt("ID_Child"), rs.getDate("Duration"), rs.getString("Interval"), rs.getDate("DateCreated"));
            donationplans.add(c);
        }
        Database.getInstance().closeConnection();
    }

    public static DonationplanDAO getInstance() throws SQLException, FileNotFoundException, ClassNotFoundException {
        if (instance == null) {
            instance = new DonationplanDAO();
        }
        return instance;
    }

    @Override
    public List<Donationplan> findAll() {
        return donationplans;
    }

    @Override
    public Donationplan findById(int id) {
        for (Donationplan donationplan : donationplans) {
            if (donationplan.getDonationPlanID() == id) {
                return donationplan;
            }
        }
        return null;
    }

    @Override
    public List<Donationplan> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Donationplan t) {
        try {
            donationplans.set(donationplans.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(Donationplan t) {
        try {
            donationplans.add(t);
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
    public boolean delete(Donationplan t) {
        try {
            donationplans.remove(t);
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

    public ArrayList<Donationplan> getOpenDonations() throws FileNotFoundException, SQLException, ClassNotFoundException {
        ArrayList<Donationplan> openDonations = new ArrayList<>();
        for (Donation i : getNewestDonations()) {
            Donationplan donP = findById(i.getDonationplanID());
            DonationInterval inter = null;
            System.out.println(donP.getInterval());
            switch (donP.getInterval()) {
                case ("Monthly"):
                    inter = new DonationInterval("Monthly", 1.0);
                    break;
                case ("Every Other Month"):
                    inter = new DonationInterval("Every Other Month", 2.0);
                    break;
                case ("Quarterly"):
                    inter = new DonationInterval("Quarterly", 3.0);
                    break;
                case ("Semesterly"):
                    inter = new DonationInterval("Semesterly", 6.0);
                    break;
            }
            java.util.Date nextDonation = inter.getNextPayment((Date) i.getReceptionDate());
            System.out.println(nextDonation.before(new java.util.Date()));
            if (nextDonation.before(new java.util.Date())) {
                openDonations.add(findById(i.getDonationplanID()));
            }
        }
        return openDonations;
    }

    public ArrayList<Donation> getNewestDonations() throws SQLException, FileNotFoundException, ClassNotFoundException {
        Database db = Database.getInstance();
        ArrayList<Donation> newestDonations = new ArrayList<>();
        try {
            int count = 1;
            db.openConnection("", "");
            ResultSet rsRows = db.getTable("Select ID_Donationplan FROM preciousdb.donation ORDER By ID_Donationplan DESC LIMIT 1");
            rsRows.next();
            int rows = rsRows.getInt("ID_Donationplan");
            System.out.println("rows = " + rows);
            while (count <= rows) {
                System.out.println("Executing query for count " + count);
                String query = "select * from preciousdb.donation where ID_Donationplan = " + count + " order by ReceptionDate DESC LIMIT 1";
                ResultSet rs = db.getTable(query);
                while (rs.next()) {
                    newestDonations.add(DonationDAO.getInstance().findById(rs.getInt("ID_Donation")));
                    System.out.println(rs);
                }
                count++;
            }
        } catch (Exception e) {
            System.out.println("Exception thrown, closing connection\n" + e.getMessage());
            db.closeConnection();
        }
        return newestDonations;
    }

    public ArrayList<Donation> getThisMonthsDonations() throws SQLException, FileNotFoundException, ClassNotFoundException {
        ArrayList<Donation> doneThisMonth = new ArrayList<>();

        String query = "SELECT * FROM preciousdb.donation WHERE (SELECT month(ReceptionDate)) = MONTH(CURRENT_TIMESTAMP)";
        Database db = Database.getInstance();
        db.openConnection("", "");
        ResultSet rs = db.getTable(query);
        while (rs.next()) {
            doneThisMonth.add(DonationDAO.getInstance().findById(rs.getInt("ID_Donation")));
            System.out.println(rs.getInt("ID_Donation"));
        }
        return doneThisMonth;
    }

}
