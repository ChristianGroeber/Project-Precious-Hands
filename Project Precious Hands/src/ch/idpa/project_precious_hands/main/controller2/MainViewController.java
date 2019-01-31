/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.controller2;

import ch.idpa.project_precious_hands.main.Model.Child;
import ch.idpa.project_precious_hands.main.Model.ChildDAO;
import ch.idpa.project_precious_hands.main.Model.Database;
import ch.idpa.project_precious_hands.main.Model.Donation;
import ch.idpa.project_precious_hands.main.Model.DonationDAO;
import ch.idpa.project_precious_hands.main.Model.Donor;
import ch.idpa.project_precious_hands.main.Model.DonorDAO;
import ch.idpa.project_precious_hands.main.Starter;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author chris
 */
public class MainViewController implements Initializable {

    @FXML
    private TextField txtAmount;
    @FXML
    private Button btnSaveDonation;
    @FXML
    private TextField txtDonorChooser;
    @FXML
    private TextField txtChildChooser;
    //__________Table Donations_________________
    @FXML
    private TableView<Donation> tblDonations;
    @FXML
    private TableColumn<Donation, Integer> colAmount;
    @FXML
    private TableColumn<Donation, Integer> colDonor;
    @FXML
    private TableColumn<Donation, Integer> colChild;
    @FXML
    private TableColumn<Donation, Date> colDateCreated;
    //__________END Table Donations_________________

    //_________Table Children_______________________
    @FXML
    private TableView<Child> tblChildren;
    @FXML
    private TableColumn<Child, Integer> colChildID;
    @FXML
    private TableColumn<Child, String> colName;
    @FXML
    private TableColumn<Child, String> colLastName;
    @FXML
    private TableColumn<Child, Date> colBirthday;
    //_________END Table Children_____________________

    //_________Table Donors___________________________
    @FXML
    private TableView<Donor> tblDonor;
    @FXML
    private TableColumn<Donor, Integer> colDonorID;
    @FXML
    private TableColumn<Donor, String> colNameDonor;
    @FXML
    private TableColumn<Donor, String> colLastNameDonor;
    //_________END Table Donors_______________________

    @FXML
    private TextField txtNameChild;
    @FXML
    private TextField txtLastNameChild;
    @FXML
    private Button btnSaveChild;
    @FXML
    private ImageView imgChild;
    @FXML
    private TextField tytNameDonor;
    @FXML
    private TextField txtLastNameDonor;
    @FXML
    private TextField txtRoadDonor;
    @FXML
    private TextField txtPostalCodeDonor;
    @FXML
    private DatePicker txtBirthdayChild;
    @FXML
    private Button btnSaveDonor;
    @FXML
    private TextField txtLocationDonor;
    @FXML
    private TextField txtEmailDonor;
    @FXML
    private TextField txtPhoneNumberDonor;
    @FXML
    private MenuBar menuBar;

    private static final Settings settings = Settings.getInstance();
    @FXML
    private Tab tabDonations;
    @FXML
    private Tab tabChildren;
    @FXML
    private Tab tabDonors;
    @FXML
    private TabPane tabPane;

    private Database db;
    private ArrayList<Child> arrChildren;
    private ArrayList<Donor> arrDonors;
    private ArrayList<Donation> arrDonations;
    @FXML
    private DatePicker txtUntil;

    public MainViewController() {
        try {
            this.db = Database.getInstance();
        } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (settings != null) {
            settings.setMenuBar(menuBar);
        }
        try {
            arrChildren = (ArrayList<Child>) new ChildDAO().findAll();
            arrDonors = (ArrayList<Donor>) new DonorDAO().findAll();
            arrDonations = (ArrayList<Donation>) new DonationDAO().findAll();
        } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadChildrenInTable();
        loadDonorsInTable();
    }

    private void loadChildrenInTable() {
        ObservableList<Child> data = FXCollections.observableArrayList(arrChildren);
        colChildID.setCellValueFactory(new PropertyValueFactory<>("childID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        tblChildren.setItems(data);
    }
    
    private void loadDonorsInTable(){
        ObservableList<Donor> data = FXCollections.observableArrayList(arrDonors);
        colDonorID.setCellValueFactory(new PropertyValueFactory<>("donorID"));
        colNameDonor.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLastNameDonor.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblDonor.setItems(data);
    }

    @FXML
    private void newDonation(ActionEvent event) {
        Donation donation = new Donation();

    }

    @FXML
    private void save(ActionEvent event) throws ParseException {
        String id = ((Control) event.getSource()).getId();
        switch (id) {
            case ("btnSaveDonation"):
                saveDonation();
                break;
            case ("btnSaveChild"):
                saveChild();
                break;
        }
    }

    private void saveChild() throws ParseException {
        String name = txtNameChild.getText();
        String lastName = txtLastNameChild.getText();
        LocalDate bd = txtBirthdayChild.getValue();
        Instant instant = Instant.from(bd.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        java.sql.Date sDate = convertUtilToSql(date);
        Child c = new Child(name, lastName, 'm', sDate, new BufferedImage(1, 1, TYPE_INT_ARGB));
        ChildDAO.getInstance().insert(c);
        arrChildren = (ArrayList<Child>) ChildDAO.getInstance().findAll();
        loadChildrenInTable();
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    private void saveDonation() {
        String amount = txtAmount.getText();
        List<Donor> donor = DonorDAO.getInstance().findByName(txtDonorChooser.getText());
    }

    @FXML
    private void chooseDonor(ActionEvent event) {

    }

    @FXML
    private void chooseChild(ActionEvent event) throws IOException {
        loadWindow("DetailView", "Child");
    }

    @FXML
    private void newChild(ActionEvent event) {

    }

    @FXML
    private void chooseImage(ActionEvent event) {
    }

    @FXML
    private void newDonor(ActionEvent event) {
    }

    @FXML
    private void donationDetail(ActionEvent event) throws IOException {
        loadWindow("DetailView", "Donation Detail");
    }

    @FXML
    private void childDetail(ActionEvent event) throws IOException {
        loadWindow("DetailView", "Child Detail");
    }

    @FXML
    private void donorDetail(ActionEvent event) throws IOException {
        loadWindow("DetailView", "Donor Detail");
    }

    private void loadWindow(String window, String title) throws IOException {
        Starter start = new Starter();
        start.changeScreen("view2", window, title);

    }

    @FXML
    private void addDonationToChild(ActionEvent event) {
        Child child = tblChildren.getSelectionModel().getSelectedItem();
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(0);
        txtChildChooser.setText(child.getLastName());
//        Reciever rec = new Reciever
//        Donation donation = new Donation(new DonationDAO().getOpenId(), RecieverDAO.getInstance().getOpenId(), getAmountDonated(), new Date());
//        while (new DonationDAO().update(donation)) {
//            System.out.println("adding to donation array");
//        }
    }

    private int getAmountDonated() {
        boolean validAmount = false;
        int ret = 0;
        while (!validAmount) {
            try {
                ret = Integer.parseInt(txtAmount.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showConfirmDialog(null, "Error", "This entry wasn't valid, please try again.", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.toString());
            }
        }
        return ret;
    }

    @FXML
    private void addDonationToDonor(ActionEvent event) {
    }

}
