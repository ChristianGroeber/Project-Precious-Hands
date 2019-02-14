/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;

/**
 *
 * @author chris
 */
public class PdfCreator {

    public void createPdf(Donationplan plan) throws ParseException, FileNotFoundException, DocumentException, BadElementException, IOException {
        Donor donor = DonorDAO.getInstance().findById(plan.getDonorID());
        Child child = ChildDAO.getInstance().findById(plan.getChildID());
        Document document = new Document();
        System.out.println(System.getProperty("user.home"));
        PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.home") + "/Desktop/Reminder_" + donor.getName() + "-" + donor.getLastName() + ".pdf"));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Paragraph headerParagraph = new Paragraph();
        Chunk header = new Chunk("Dear " + donor.getName(), font);
        headerParagraph.add(header);
        headerParagraph.setSpacingAfter(25);

        Paragraph bodyParagraph = new Paragraph();
        Chunk body = new Chunk("You have not donated this month, remember that your donation will help children around india.\n"
                + "In your registration you said you would donate on a " + plan.getInterval() + " basis. "
                + "Please remember to transfer the amount of CHF " + plan.getAmount() + " within the next 30 days.\n"
                + "Thank you in advance for your support,\nthe Precious Hands Team", FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK));
        bodyParagraph.add(body);
        bodyParagraph.setSpacingAfter(25);

        document.add(headerParagraph);
        document.add(bodyParagraph);
        document.close();
    }
}
