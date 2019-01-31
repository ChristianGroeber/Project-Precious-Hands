/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.controller2;

import ch.idpa.project_precious_hands.main.Model.Child;
import ch.idpa.project_precious_hands.main.Model.Database;
import ch.idpa.project_precious_hands.main.Model.Donation;
import ch.idpa.project_precious_hands.main.Model.DonationDAO;
import ch.idpa.project_precious_hands.main.Model.Donor;
import ch.idpa.project_precious_hands.main.Model.DonorDAO;
import ch.idpa.project_precious_hands.main.Model.RecieverDAO;
import ch.idpa.project_precious_hands.main.Starter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.TextInputDialog;
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
    @FXML
    private TableView<?> tblPayments;
    @FXML
    private TableColumn<?, ?> colAmount;
    @FXML
    private TableColumn<?, ?> colDonor;
    @FXML
    private TableColumn<?, ?> colChild;
    @FXML
    private TableColumn<?, ?> colDateCreated;
    @FXML
    private TextField txtNameChild;
    @FXML
    private TextField txtLastNameChild;
    @FXML
    private Button btnSaveChild;
    @FXML
    private ImageView imgChild;
    @FXML
    private TableColumn<?, ?> colName;
    @FXML
    private TableColumn<?, ?> colLastName;
    @FXML
    private TableColumn<?, ?> colBirthday;
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
    private TableColumn<?, ?> colNameDonor;
    @FXML
    private TableColumn<?, ?> colLastNameDonor;
    @FXML
    private MenuBar menuBar;

    private static final Settings settings = Settings.getInstance();
    @FXML
    private TableView<?> tblDonor;
    @FXML
    private Tab tabDonations;
    @FXML
    private Tab tabChildren;
    @FXML
    private Tab tabDonors;
    @FXML
    private TableView<Child> tblChildren;
    @FXML
    private TabPane tabPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (settings != null) {
            settings.setMenuBar(menuBar);
        }
        try {
            Database.getInstance().createDatabase(0);
        } catch (SQLException | FileNotFoundException | ClassNotFoundException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void newDonation(ActionEvent event) {
        Donation donation = new Donation();

    }

    @FXML
    private void save(ActionEvent event) {
        String id = ((Control) event.getSource()).getId();
        switch (id) {
            case ("btnSaveDonation"):
                saveDonation();
                break;
        }
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
