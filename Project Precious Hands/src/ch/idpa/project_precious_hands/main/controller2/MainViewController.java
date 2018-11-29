/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.controller2;

import ch.idpa.project_precious_hands.main.ScreenSwitcher;
import ch.idpa.project_precious_hands.main.Starter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    private TableView<?> leiterTbl1;
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
    private TableView<?> leiterTbl11;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(settings != null){
            settings.setMenuBar(menuBar);
        }
    }    

    @FXML
    private void newDonation(ActionEvent event) {
    }

    @FXML
    private void save(ActionEvent event) {
    }

    @FXML
    private void chooseDonor(ActionEvent event) {
    }

    @FXML
    private void chooseChild(ActionEvent event) {
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
        //settings.setDetailPage("Donation");
        loadWindow("DetailView");
    }


    @FXML
    private void childDetail(ActionEvent event) throws IOException {
        //settings.setDetailPage("Child");
        loadWindow("DetailView");
    }


    @FXML
    private void donorDetail(ActionEvent event) throws IOException {
        //settings.setDetailPage("Donor");
        loadWindow("DetailView");
    }

    
    private void loadWindow(String window) throws IOException{
        Starter start = new Starter();
        start.changeScreen("view2", "DetailView");

    }
    
}
