/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.Contact;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class ContactDao implements Icrud<Contact> {
    
    private static final String DeleteByKey= "";
    private static final String SelectByPage = "";
    private static final String Insert = "INSERT INTO contact(adress, email, numphone, numhouse, numwork, namecontact, person_Id) VALUES (?,?,?,?,?,?,?);";
    private static final String Update = "UPDATE contact SET adress=?, email=?, numphone=?, numhouse=? WHERE  person_Id=?;";
    private static final String SelectByAtrib = "";
    private static final String SelectBykey ="SELECT * FROM contact WHERE person_Id = ?;";
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    Contact contact = null;

    @Override
    public Contact ListByAtrib(Object key) {
        
      
        try {
            ps = con.getCon().prepareStatement(SelectBykey);
            
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                contact = new Contact(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }
            
            return contact;
            
        } catch (Exception e) {
            return null;
        }finally{
            Conexion.CloseConexion();
        }
        
    }

    @Override
    public List<Contact> ListByPag(Object key, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contact> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Contact ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(Contact c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            
            ps= con.getCon().prepareStatement(Insert);
            
            ps.setString(1, c.getAdress());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getNumphone());
            ps.setString(4, c.getNumhouse());
            ps.setString(5, c.getNumwork());
            ps.setString(6, c.getNamecontact());
            ps.setInt(7, c.getPerson_Id());
            
            if (ps.executeUpdate() > 0) {
                
                 return true;
            }
            
            
        } catch (Exception e) {
            
            return false;
        }finally{
            
            Conexion.CloseConexion();
        }
        
        return false;
    }

    @Override
    public boolean Update(Contact c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            
            ps= con.getCon().prepareStatement(Update);
            
            ps.setString(1, c.getAdress());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getNumphone());
            ps.setString(4, c.getNumhouse());
            ps.setInt(5, c.getPerson_Id());
            
            
            if (ps.executeUpdate() > 0) {
                
                 return true;
            }           
            
        } catch (Exception e) {
            
            return false;
            
        }finally{
            
            Conexion.CloseConexion();
        }
        
        return false;
    }

    @Override
    public boolean DeleteByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
