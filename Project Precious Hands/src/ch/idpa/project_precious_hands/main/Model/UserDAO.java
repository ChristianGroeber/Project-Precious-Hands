/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olive
 */
public class UserDAO implements DAO<User>{
    List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public List<User> findById(int id) {
        List<User> temp = new ArrayList<>();

        for (User user : users) {
            if (user.getUserID() == id) {
                temp.add(user);
            }
        }
        return temp;
    }

    @Override
    public List<User> findByName(String name) {
        List<User> temp = new ArrayList<>();

        for (User user : users) {
            if (user.getName().equals(name)) {
                temp.add(user);
            }
        }
        return temp;
    }

    @Override
    public boolean update(User t) {
        try {
            users.set(users.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(User t) {
        try {
            users.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(User t) {
        try {
            users.remove(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
