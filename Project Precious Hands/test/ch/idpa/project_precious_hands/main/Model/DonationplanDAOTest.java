/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class DonationplanDAOTest {

    public DonationplanDAOTest() {
    }

    @Test
    public void testGetInstance() throws Exception {
    }

    @Test
    public void testFindAll() {
    }

    @Test
    public void testFindById() {
    }

    @Test
    public void testFindByName() {
    }

    @Test
    public void testUpdate() {
    }

    @Test
    public void testInsert() {
    }

    @Test
    public void testDelete() {
    }

    @Test
    public void testGetOpenId_int() {
    }

    @Test
    public void testGetOpenId_0args() {
    }

    @Test
    public void testGetOpenDonations() {
        try {
            ArrayList<Donationplan> open = DonationplanDAO.getInstance().getOpenDonations();
            for(Donationplan i : open){
                System.out.println(i.getSql());
            }
        } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
            System.out.println("ex = " + ex.getMessage());
        }
    }

    @Test
    public void testGetThisMonthsDonations() throws Exception {
//        DonationplanDAO.getInstance().getThisMonthsDonations();
    }

    @Test
    public void testWasThisMonth() {
    }

    @Test
    public void testGetNewestDonations() throws Exception {
//        ArrayList<Donation> dons = DonationplanDAO.getInstance().getNewestDonations();
//        for (Donation i : dons) {
//            System.out.println(i.getSql());
//        }
    }

}
