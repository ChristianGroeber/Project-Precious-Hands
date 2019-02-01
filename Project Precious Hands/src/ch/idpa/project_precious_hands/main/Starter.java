/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main;

import ch.idpa.project_precious_hands.main.Model.ChildDAO;
import ch.idpa.project_precious_hands.main.Model.DonationDAO;
import ch.idpa.project_precious_hands.main.Model.DonationplanDAO;
import ch.idpa.project_precious_hands.main.Model.DonorDAO;
import com.sun.javafx.application.LauncherImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author chris
 */
public class Starter extends Application {

    private static Stage stage = null;
    private static Parent root;
    
    private static Starter instance;
    
    private static final int COUNT_LIMIT = 500000;
    private static int stepCount = 1;
    
    public Starter(){
        System.out.println(Starter.STEP() + "MyApplication constructor called, thread: " + Thread.currentThread().getName());
    }
    
    public static Starter getInstance(){
        if(instance == null){
            instance = new Starter();
        }
        return instance;
    }
    
    public static String STEP() {
        return stepCount++ + ". ";
    }
    
    @Override
    public void init()throws Exception{
        System.out.println(Starter.STEP() + "MyApplication#init (doing some heavy lifting), thread: " + Thread.currentThread().getName());
        
        // Perform some heavy lifting (i.e. database start, check for application updates, etc. )
        loadMyStuff();
//        for (int i = 0; i < COUNT_LIMIT; i++) {
//            double progress = (100 * i) / COUNT_LIMIT;
//            LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
//        }
    }
    
    private void loadMyStuff() throws ParseException, SQLException, FileNotFoundException, ClassNotFoundException{
        ChildDAO.getInstance();
        DonorDAO.getInstance();
        DonationDAO.getInstance();
        DonationplanDAO.getInstance();
    }

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(Starter.STEP() + "MyApplication#start (initialize and show primary application stage), thread: " + Thread.currentThread().getName());
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
        LauncherImpl.launchApplication(Starter.class, MyPreloader.class, args);
//        launch(args);
    }

}