/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.controller2;

import ch.idpa.project_precious_hands.main.Model.Child;
import ch.idpa.project_precious_hands.main.Model.ChildDAO;
import ch.idpa.project_precious_hands.main.Model.Choosable;
import ch.idpa.project_precious_hands.main.Model.Database;
import ch.idpa.project_precious_hands.main.Model.Donation;
import ch.idpa.project_precious_hands.main.Model.DonationDAO;
import ch.idpa.project_precious_hands.main.Model.DonationInterval;
import ch.idpa.project_precious_hands.main.Model.Donationplan;
import ch.idpa.project_precious_hands.main.Model.DonationplanDAO;
import ch.idpa.project_precious_hands.main.Model.Donor;
import ch.idpa.project_precious_hands.main.Model.DonorDAO;
import ch.idpa.project_precious_hands.main.Model.User;
import ch.idpa.project_precious_hands.main.Model.UserDAO;
import ch.idpa.project_precious_hands.main.Starter;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
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
    private TextField txtDonorChooser;
    private TextField txtChildChooser;
    //________Table Donationplans____________________
    @FXML
    private TableView<Donationplan> tblDonationplans;
    @FXML
    private TableColumn<Donationplan, Integer> colIDDonationplan;
    @FXML
    private TableColumn<Donationplan, Integer> colAmount;
    @FXML
    private TableColumn<Donationplan, Integer> colDonor;
    @FXML
    private TableColumn<Donationplan, Integer> colChild;
    @FXML
    private TableColumn<Donationplan, Date> colDateCreated;
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

    //_________Table Donations________________________
    @FXML
    private TableView<Donation> tblDonations;
    @FXML
    private TableColumn<Donation, Integer> colIDDonation;
    @FXML
    private TableColumn<Donation, Integer> colIDDonationplan2;
    @FXML
    private TableColumn<Donation, Date> colDateDonated;
    //_________END Table Donations_____________________

    //_________Table Users_____________________________
    @FXML
    private TableView<User> tblUsers;
    @FXML
    private TableColumn<User, Integer> colIDUser;
    @FXML
    private TableColumn<User, String> colUserName;
    @FXML
    private TableColumn<User, String> colUserLastName;
    @FXML
    private TableColumn<User, Date> colUserDateAdded;
    @FXML
    private TableColumn<User, Boolean> colUserIsAdmin;
    //________END Table Users___________________________

    @FXML
    private TextField txtNameChild;
    @FXML
    private TextField txtLastNameChild;
    @FXML
    private Button btnSaveChild;
    @FXML
    private ImageView imgChild;
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
    private ArrayList<Donationplan> arrDonationplans;
    private ArrayList<User> arrUsers;
    @FXML
    private DatePicker txtUntil;
    @FXML
    private TextField txtNameDonor;
    @FXML
    private ComboBox<String> cmbInterval;
    @FXML
    private Button btnSaveDonationplan;
    @FXML
    private ComboBox<String> cmbDonors;
    @FXML
    private ComboBox<String> cmbChildren;
    @FXML
    private Tab tabDonationplans;
    @FXML
    private Button btnSaveDonation;
    @FXML
    private ComboBox<String> cmbDonations;
    @FXML
    private DatePicker txtDateDonated;
    @FXML
    private Tab tabUsers;
    @FXML
    private Button btnSaveUser;
    @FXML
    private TextField txtUserName;
    @FXML
    private RadioButton radUserIsAdmin;
    @FXML
    private TextField txtUserLastName;

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
            arrDonationplans = (ArrayList<Donationplan>) new DonationplanDAO().findAll();
        } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillCmbInterval();
        fillCmbDonors(arrDonors);
        fillCmbChildren(arrChildren);
        fillCmbDonationplans(arrDonationplans);
        if (UserDAO.getInstance().getLoggedInUser().isAdmin()) {
            tabUsers.setDisable(false);
            arrUsers = (ArrayList<User>) UserDAO.getInstance().findAll();
            loadUsersInTable();
        }
        loadChildrenInTable();
        loadDonorsInTable();
        loadDonationplansInTable();
        loadDonationsInTable();
    }

    private void fillCmbInterval() {
        ArrayList<DonationInterval> intervals = createIntervals();
        ObservableList< String> options = FXCollections.observableArrayList();
        for (DonationInterval i : intervals) {
            options.add(i.getDescription());
        }
        cmbInterval.setItems(options);
    }

    private ArrayList<DonationInterval> createIntervals() {
        ArrayList<DonationInterval> inters = new ArrayList<>();
        DonationInterval a = new DonationInterval("Monthly", 1.0);
        DonationInterval b = new DonationInterval("Every Other Month", 2.0);
        DonationInterval c = new DonationInterval("Quarterly", 3.0);
        DonationInterval d = new DonationInterval("Semesterly", 6.0);
        inters.add(a);
        inters.add(b);
        inters.add(c);
        inters.add(d);
        return inters;
    }

    private void loadChildrenInTable() {
        ObservableList<Child> data = FXCollections.observableArrayList(arrChildren);
        colChildID.setCellValueFactory(new PropertyValueFactory<>("childID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        tblChildren.setItems(data);
    }

    private void loadDonorsInTable() {
        ObservableList<Donor> data = FXCollections.observableArrayList(arrDonors);
        colDonorID.setCellValueFactory(new PropertyValueFactory<>("donorID"));
        colNameDonor.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLastNameDonor.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblDonor.setItems(data);
    }

    private void loadDonationplansInTable() {
        ObservableList<Donationplan> data = FXCollections.observableArrayList(arrDonationplans);
        colIDDonationplan.setCellValueFactory(new PropertyValueFactory<>("onationPlanID"));
        colAmount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colDonor.setCellValueFactory(new PropertyValueFactory<>("donorID"));
        colChild.setCellValueFactory(new PropertyValueFactory<>("childID"));
        colDateCreated.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
        tblDonationplans.setItems(data);
    }

    private void loadDonationsInTable() {
        ObservableList<Donation> data = FXCollections.observableArrayList(arrDonations);
        colIDDonation.setCellValueFactory(new PropertyValueFactory<>("donationID"));
        colIDDonationplan2.setCellValueFactory(new PropertyValueFactory<>("donationplanID"));
        colDateDonated.setCellValueFactory(new PropertyValueFactory<>("receptionDate"));
        tblDonations.setItems(data);
    }

    private void loadUsersInTable() {
        ObservableList<User> data = FXCollections.observableArrayList(arrUsers);
        colIDUser.setCellValueFactory(new PropertyValueFactory<>("userID"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUserLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colUserDateAdded.setCellValueFactory(new PropertyValueFactory<>("dateAdded"));
        colUserIsAdmin.setCellValueFactory(new PropertyValueFactory<>("isAdmin"));
        tblUsers.setItems(data);
    }

    private void fillCmbDonors(ArrayList<Donor> donors) {
        ObservableList<String> options = FXCollections.observableArrayList();
        for (Donor i : donors) {
            options.add(i.getDonorID() + " " + i.getName() + " " + i.getLastName());
        }
        cmbDonors.setItems(options);
    }

    private void fillCmbChildren(ArrayList<Child> children) {
        ObservableList<String> options = FXCollections.observableArrayList();
        for (Child i : children) {
            options.add(i.getChildID() + " " + i.getName() + " " + i.getLastName());
        }
        cmbChildren.setItems(options);
    }

    private void fillCmbDonationplans(ArrayList<Donationplan> donationplans) {
        ObservableList<String> options = FXCollections.observableArrayList();
        for (Donationplan i : donationplans) {
            options.add(i.toString());
        }
        cmbDonations.setItems(options);
    }

    private void fillUniversalCombobox(ArrayList<Choosable> arr, ComboBox cmb) {
        ObservableList<String> options = FXCollections.observableArrayList();
        for (Choosable i : arr) {
            options.add(i.getName() + " " + i.getLastName());
        }
        cmb.setItems(options);
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
            case ("btnSaveDonor"):
                saveDonor();
                break;
            case ("btnSaveDonationplan"):
                saveDonationplan();
                break;
            case ("btnSaveUser"):
                saveUser();
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

    private void saveDonor() {
        String name = txtNameDonor.getText();
        String lastName = txtLastNameDonor.getText();
        String road = txtRoadDonor.getText();
        String postalCode = txtPostalCodeDonor.getText();
        String town = txtLocationDonor.getText();
        String email = txtEmailDonor.getText();
        String phone = txtPhoneNumberDonor.getText();
        Donor d = new Donor(name, lastName, road, postalCode, town, email, phone);
        DonorDAO.getInstance().insert(d);
        arrDonors = (ArrayList<Donor>) DonorDAO.getInstance().findAll();
        loadDonorsInTable();
    }

    private void saveDonationplan() {
        try {
            int amount = Integer.parseInt(txtAmount.getText());
            int donorID = Integer.parseInt(cmbDonors.getValue().split(" ")[0]);
            int childID = Integer.parseInt(cmbChildren.getValue().split(" ")[0]);
            LocalDate dt = txtUntil.getValue();
            Instant instant = Instant.from(dt.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);
            java.sql.Date sDate = convertUtilToSql(date);
            String interval = cmbInterval.getValue();
            Donationplan d = new Donationplan(amount, donorID, childID, sDate, interval);
            DonationplanDAO.getInstance().insert(d);
            arrDonationplans = (ArrayList<Donationplan>) DonationplanDAO.getInstance().findAll();
            loadDonationplansInTable();
        } catch (NumberFormatException e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Please Enter a valid Amount");
        } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void saveDonation() {
        LocalDate dt = txtDateDonated.getValue();
        Instant instant = Instant.from(dt.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        java.sql.Date sDate = convertUtilToSql(date);
        Donation d = new Donation(Integer.parseInt(cmbDonations.getValue().split(" ")[0]), sDate);
        DonationDAO.getInstance().insert(d);
        arrDonations = (ArrayList<Donation>) DonationDAO.getInstance().findAll();
        loadDonationsInTable();
    }

    private void saveUser() {
        java.sql.Date dateCreated = convertUtilToSql(new Date());
        User u = new User(txtUserLastName.getText(), txtUserName.getText(), "1234", dateCreated, radUserIsAdmin.isSelected());
        UserDAO.getInstance().insert(u);
        arrUsers = (ArrayList<User>) UserDAO.getInstance().findAll();
        loadUsersInTable();
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

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
        Starter start = Starter.getInstance();
        start.changeScreen("view2", window, title);

    }

    @FXML
    private void addDonationToChild(ActionEvent event) throws ParseException {
        try {
            TablePosition pos = tblChildren.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Child item = tblChildren.getItems().get(row);

            cmbChildren.setValue(item.getChildID() + " " + item.getName() + " " + item.getLastName());
            SingleSelectionModel<Tab> mod = tabPane.getSelectionModel();
            mod.select(tabDonationplans);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please select a row");
        }
//        Reciever rec = new Reciever
//        Donation donation = new Donation(new DonationDAO().getOpenId(), RecieverDAO.getInstance().getOpenId(), getAmountDonated(), new Date());
//        while (new DonationDAO().update(donation)) {
//            System.out.println("adding to donation array");
//        }
    }

    @FXML
    private void btnDonationDone(ActionEvent event) throws ParseException {
        TablePosition pos = tblDonationplans.getSelectionModel().getSelectedCells().get(0);
        int row = pos.getRow();
        Donationplan item = tblDonationplans.getItems().get(row);
        cmbDonations.setValue(item.toString());
        SingleSelectionModel<Tab> mod = tabPane.getSelectionModel();
        mod.select(tabDonations);
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

    @FXML
    private void searchDonor(ActionEvent event) {
        String val = cmbDonors.getValue();
        ArrayList<Donor> newArr = new ArrayList<>();
        for (Donor i : arrDonors) {
            if (Integer.toString(i.getDonorID()).equals(val)) {
                newArr.add(i);
            } else if (i.getName().equals(val)) {
                newArr.add(i);
            } else if (i.getLastName().equals(val)) {
                newArr.add(i);
            }
        }
        fillCmbDonors(newArr);
        cmbDonors.show();
    }

    @FXML
    private void searchChild(ActionEvent event) {
        String val = cmbChildren.getValue();
        ArrayList<Child> newArr = new ArrayList<>();
        for (Child i : arrChildren) {
            if (Integer.toString(i.getChildID()).equals(val)) {
                newArr.add(i);
            } else if (i.getName().equals(val)) {
                newArr.add(i);
            } else if (i.getLastName().equals(val)) {
                newArr.add(i);
            }
        }
        fillCmbChildren(newArr);
        cmbChildren.show();
    }

    @FXML
    private void newDonationPlan(ActionEvent event) {
    }

    @FXML
    private void logout(ActionEvent event) throws IOException {
        Starter.getInstance().changeScreen("view2", "LoginView", "Login");
    }

    @FXML
    private void addUser(ActionEvent event) {

    }

    @FXML
    private void btnRemoveRights(ActionEvent event) {
    }

    @FXML
    private void checkOpenDonations(ActionEvent event) throws SQLException, FileNotFoundException, ClassNotFoundException {
        for (Donationplan i : arrDonationplans) {
            System.out.println(i.getSql());
        }
        arrDonationplans = DonationplanDAO.getInstance().getOpenDonations();
        for (Donationplan i : arrDonationplans) {
            System.out.println(i.getSql());
        }
        loadDonationplansInTable();
    }
}
