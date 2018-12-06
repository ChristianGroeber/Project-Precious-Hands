/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.util.Date;

/**
 *
 * @author chris
 */
public class Child {
    private String name;
    private String lastName;
    private int id;
    private Date birthday;
    
    private static Child instance;

    public Child() {
        if(instance == null){
            instance = new Child();
        }
    }
    
    public static Child getInstance(){
        return instance;
    }
    
    

    public Child(String name, String lastName, int id, Date birthday) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    
    
}
