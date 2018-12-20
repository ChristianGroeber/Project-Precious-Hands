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
public class RecieverDAO implements DAO<Reciever>{
    List<Reciever> recievers = new ArrayList<>();

    @Override
    public List<Reciever> findAll() {
        return recievers;
    }

    @Override
    public List<Reciever> findById(int id) {
        List<Reciever> temp = new ArrayList<>();
        
        for (Reciever reciever : recievers) {
            if (reciever.getDonorID() == id) {
                temp.add(reciever);
            }
        }
        return temp;
    }

    @Override
    public List<Reciever> findByName(String name) {
        throw new UnsupportedOperationException("Unsupported");
    }

    @Override
    public boolean update(Reciever t) {
        try {
            recievers.set(recievers.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(Reciever t) {
        try {
            recievers.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Reciever t) {
        try {
            recievers.remove(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    
    
}
