/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.util.Calendar;
import static java.util.Calendar.DAY_OF_MONTH;
import java.util.Date;

/**
 *
 * @author chris
 */
public class DonationInterval {
    private final String description;
    private final double amountMonths;

    public DonationInterval(String description, double nextPayment) {
        this.description = description;
        this.amountMonths = nextPayment;
    }

    public String getDescription() {
        return description;
    }

    public double getAmountMonths() {
        return amountMonths;
    }
    
    public Date getNextPayment(Date lastDonation){
        Calendar c = Calendar.getInstance();
        c.setTime(lastDonation);
        c.add(Calendar.DATE, (int) (amountMonths * 30));
        Date nextPayment = c.getTime();
        if(c.get(DAY_OF_MONTH) <= 15){
            c.add(Calendar.DATE, - c.get(DAY_OF_MONTH) + 1);
        }else{
            c.add(Calendar.DATE, c.get(DAY_OF_MONTH) - 30);
        }
        return c.getTime();
    }
    
    public boolean isThisInterval(String testDescription){
        return testDescription.equals(description);
    }
    
}
