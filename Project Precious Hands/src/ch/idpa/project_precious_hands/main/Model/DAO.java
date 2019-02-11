/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.util.List;

/**
 *
 * @author olive
 */
public interface DAO<T> {
    List<T> findAll();
    T findById(int id);
    List<T> findByName(String name);
    
    boolean update(T t);
        
    
    boolean insert(T t);
    
    
    boolean delete(T t);
    
    int getOpenId();
}
