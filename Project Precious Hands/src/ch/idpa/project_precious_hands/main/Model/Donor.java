/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

/**
 *
 * @author olive
 */
public class Donor extends Choosable{

    private int donorID;
    private String name;
    private String lastName;
    private String street;
    private String postalCode;
    private String city;
    private String email;
    private String phone;
    private int donationPlanID;
    private String sql; 

    public Donor(int donorID, String name, String lastName, String street, String postalCode, String city, String email, String phone) {
        this.donorID = donorID;
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
        this.phone = phone;
//        this.donationPlanID = donationPlanID;
    }

    public Donor(String name, String lastName, String road, String postalCode, String town, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.street = road;
        this.postalCode = postalCode;
        this.city = town;
        this.email = email;
        this.phone = phone;
        this.donorID = DonorDAO.getInstance().getOpenId(0);
    }

    public Donor(String name, String lastName, String street, String postalCode, String city, String email, String phone, int donationPlanID) {
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.donationPlanID = donationPlanID;
    }

    public Donor(int donorID, String name, String lastName, String street, String postalCode, String city, String email, String phone, int donationPlanID) {
        this.donorID = donorID;
        this.name = name;
        this.lastName = lastName;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.email = email;
        this.phone = phone;
        this.donationPlanID = donationPlanID;
    }
    
    public int getDonorID() {
        return donorID;
    }

    public void setDonorID(int donorID) {
        this.donorID = donorID;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDonationPlanID() {
        return donationPlanID;
    }

    public void setDonationPlanID(int donationPlanID) {
        this.donationPlanID = donationPlanID;
    }
    
    public String getSql(){
        sql = "INSERT INTO `preciousdb`.`donor` (`ID_Donor`, `Name`, `LastName`, `Street`, `Postal_Code`, `City`, `Email`, `Phone`) VALUES ('"
                + donorID + "', '" + name + "', '" + lastName + "', '" + street + "', '" + postalCode + "', '" + city + "', '" + email + "', '" + phone + "');";
        return this.sql;
    }

}
