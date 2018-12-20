/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.idpa.project_precious_hands.main.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olive
 */
public class ChildDAO implements DAO<Child>{
    private List<Child> children = new ArrayList<>();

    public ChildDAO() throws SQLException {
        /*        Database.getInstance().openConnection("preciousdb", "Os1t~T6E!5wi");
        ResultSet rs = Database.getInstance().getTable("SELECT * FROM child;");
        for (Object r : rs) {
        
        }*/
        Database.getInstance().closeConnection();
    }

    @Override
    public List<Child> findAll() {
        return children;
    }

    @Override
    public List<Child> findById(int id) {
        List<Child> temp = new ArrayList<>();

        for (Child child : children) {
            if (child.getChildID() == id) {
                temp.add(child);
            }
        }
        return temp;
    }

    @Override
    public List<Child> findByName(String name) {
        List<Child> temp = new ArrayList<>();

        for (Child child : children) {
            if (child.getName().equals(name)) {
                temp.add(child);
            }
        }
        return temp;
    }

    @Override
    public boolean update(Child t) {
        try {
            children.set(children.indexOf(t), t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean insert(Child t) {
        try {
            children.add(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Child t) {
        try {
            children.remove(t);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
