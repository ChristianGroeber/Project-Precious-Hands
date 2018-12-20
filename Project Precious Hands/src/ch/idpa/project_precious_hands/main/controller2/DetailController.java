/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.controller2;

import ch.idpa.project_precious_hands.main.Starter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author chris
 */
public class DetailController implements Initializable {
    
    private static final Settings settings = Settings.getInstance();
    
    private MenuBar menuBar;
    @FXML
    private MenuBar newMenuBar;
    @FXML
    private TextField txtAmount;
    @FXML
    private Button btnSaveDonation;
    @FXML
    private Label txtTitle;
    @FXML
    private TextField txtDonorChooser;
    @FXML
    private TextField txtChildChooser;
    @FXML
    private Label lblDetailPage;
    @FXML
    private GridPane grd;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //menuBar = settings.getMenuBar();
        //this.newMenuBar = menuBar;
        //lblDetailPage.setText(settings.getDetailPage());
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
    private void backHome(MouseEvent event) throws IOException {
        new Starter().changeScreen("view2", "MainView", "Precious Hands");
    }
    
}
