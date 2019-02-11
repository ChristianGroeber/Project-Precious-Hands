/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class DonationIntervalTest {
    
    public DonationIntervalTest() {
    }

    @Test
    public void testGetDescription() {
    }

    @Test
    public void testGetAmountMonths() {
    }

    @Test
    public void testGetNextPayment() {
        Date testing = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            testing = sdf.parse("16-01-2019");
        } catch (ParseException ex) {
            Logger.getLogger(DonationIntervalTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        DonationInterval inter = new DonationInterval("monthly", 1);
        System.out.println(inter.getNextPayment((java.sql.Date) testing));
    }
    
}
