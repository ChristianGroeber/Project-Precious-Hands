/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.controller2;

import ch.idpa.project_precious_hands.main.Model.*;
import ch.idpa.project_precious_hands.main.Starter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author chris
 */
public class ChooserViewController implements Initializable {
    
    private Child selChild;
    private Donor selDonor;
    
    @FXML
    private TableView<?> table;
            
            /**
             * Initializes the controller class.
             */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void select(ActionEvent event) {
        String title = new Starter().getTitle();
        if(title.equals("Child")){
            selChild = (Child) table.getSelectionModel().getSelectedItem();
        }else{
            selDonor = (Donor) table.getSelectionModel().getSelectedItem();
        }
    }

    @FXML
    private void previous(ActionEvent event) {
        //TODO connect to Database
    }

    @FXML
    private void next(ActionEvent event) {
        //TODO connecto to Database
    }

}
