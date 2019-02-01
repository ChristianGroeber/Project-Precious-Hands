/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main;

import ch.idpa.project_precious_hands.main.Model.Database;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author chris
 */
public class Starter extends Application {

    private static Stage stage = null;
    private static Parent root;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        changeScreen("view2", "LoginView", "Precious Hands");
    }

    public void changeScreen(String pkg, String window, String title) throws IOException {
        Image icon = new Image("resources/Precious_Logo.png");
        Stage stage = this.stage;
        Scene scene;
        if (window.equals("DetaiView")) {
            stage = new Stage();
            scene = new Scene(FXMLLoader.load(getClass().getResource(pkg + "/DetailView.fxml")));
        } else {
            root = FXMLLoader.load(getClass().getResource(pkg + "/" + window + ".fxml"));
            scene = new Scene(root);
        }

        stage.setTitle("Precious Hands");
        stage.setResizable(false);
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public String getTitle() {
        return stage.getTitle();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
