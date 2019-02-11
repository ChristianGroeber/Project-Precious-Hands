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
public class UserDataDAO implements DAO<UserData> {

    private List<UserData> userData = new ArrayList<>();

    @Override
    public List<UserData> findAll() {
        return userData;
    }

    @Override
    public UserData findById(int id) {
        for (UserData data : userData) {
            if (data.getUserID() == id) {
                return data;
            }
        }
        return null;
    }

    @Override
    public List<UserData> findByName(String name) {
        List<UserData> temp = new ArrayList<>();

        for (UserData data : userData) {
            if (data.getName().equals(name)) {
                temp.add(data);
            }
        }
        return temp;
    }

    @Override
    public boolean update(UserData t) {
        try {
            userData.set(userData.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(UserData t) {
        try {
            userData.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(UserData t) {
        try {
            userData.remove(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public int getOpenId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
