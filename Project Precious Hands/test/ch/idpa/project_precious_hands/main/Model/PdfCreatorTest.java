/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class PdfCreatorTest {
    
    public PdfCreatorTest() {
    }

    @Test
    public void testCreatePdf() throws Exception {
        new PdfCreator().createPdf(DonationplanDAO.getInstance().findById(4));
    }
    
}
