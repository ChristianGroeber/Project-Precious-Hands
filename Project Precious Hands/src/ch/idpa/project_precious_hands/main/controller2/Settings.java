/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.controller2;

import javafx.scene.control.MenuBar;

/**
 *
 * @author chris
 */
public class Settings {

    private static Settings instance;
    public String detailPage = "Detail";
    private MenuBar menuBar;

    public Settings() {
        if (instance == null) {
            instance = new Settings();
        }
    }

    public static Settings getInstance() {
        return instance;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public MenuBar getMenuBar() {
        return this.menuBar;
    }
    
    public String getDetailPage(){
        return detailPage;
    }
    
    public void setDetailPage(String detailPage){
        this.detailPage = detailPage;
    }

}
