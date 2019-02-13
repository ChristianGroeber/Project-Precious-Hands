/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.controller2;

import ch.idpa.project_precious_hands.main.Model.UserDAO;
import ch.idpa.project_precious_hands.main.Starter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author chris
 */
public class LoginController implements Initializable {

    @FXML
    private TextField txtUserName;
    @FXML
    private TextField txtPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void login(ActionEvent event) throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
        if(UserDAO.getInstance().correctValues(txtUserName.getText(), txtPassword.getText())){
            new Starter().changeScreen("view2", "MainView", "Precious Hands");
        }
    }

    @FXML
    private void goToPwField(ActionEvent event) {
        txtPassword.requestFocus();
    }
    
}
