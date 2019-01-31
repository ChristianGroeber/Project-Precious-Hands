/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.awt.image.BufferedImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olive
 */
public class Child extends Choosable{
    private int childID;
    private String name;
    private String lastName;
    private char gender;
    private Date birthday;
    private BufferedImage image;
    private String sql;
    
    public Child(int childID, String name, String lastName, char gender, Date birthday, BufferedImage image){
        this.childID = childID;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.image = image;
    }
    
    public Child(String name, String lastName, char gender, Date birthday, BufferedImage image){
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.image = image;
        try {
            this.childID = ChildDAO.getInstance().getOpenId(1);
        } catch (ParseException ex) {
            Logger.getLogger(Child.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Child(int childID, String name, String lastName, char gender, Date birthday) {
        this.childID = childID;
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
    }

    
    public int getChildID() {
        return childID;
    }

    public void setChildID(int childID) {
        this.childID = childID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public String getSql(){
        sql = "INSERT INTO `preciousdb`.`child` (`ID_Child`, `Name`, `LastName`, `Gender`, `Birthday`) VALUES ('" + childID + "', '" + name + "', '" + lastName + "', '" + gender + "', '" + birthday + "');";
        return this.sql;
    }
}
