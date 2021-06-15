/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.PaymentMethod;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class PaymentMethodDao implements Icrud<PaymentMethod>{
    
    
    //private static final String DeleteByKey= "";
    private static final String SelectByPage = "SELECT * FROM paymentmethod;";
    private static final String Insert = "INSERT INTO paymentmethod (name) VALUES (?);";
    private static final String Update = "UPDATE paymentmethod  name=? WHERE id=?;";
    //private static final String SelectByAtrib = "";
    private static final String SelectBykey ="SELECT * FROM paymentmethod WHERE id =?;";
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    PaymentMethod paymentmethod = null;

    @Override
    public PaymentMethod ListByAtrib(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            ps = con.getCon().prepareStatement(SelectBykey);
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                paymentmethod = new PaymentMethod(rs.getInt(1), rs.getString(2));
            }
            return paymentmethod;
            
        } catch (Exception e) {
            
            return null;
        }
        
        //return null;
    }

    @Override
    public List<PaymentMethod> ListByPag(Object key, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public List<PaymentMethod> ListByKey(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        ArrayList<PaymentMethod> listapay = new ArrayList<>();
        
        try {
           
            ps = con.getCon().prepareStatement(SelectByPage);
            
            rs = ps.executeQuery(); 
            
            while (rs.next()) {                
                
                paymentmethod = new PaymentMethod();
                paymentmethod.setId(rs.getInt("id"));
                paymentmethod.setName(rs.getString("name")); 
                
                listapay.add(paymentmethod);
            }
            
            return listapay;
            
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public PaymentMethod ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(PaymentMethod c) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            ps = con.getCon().prepareStatement(Insert);
            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            
            if (ps.executeUpdate() > 0) {
                
                return true;                
            }
            
            
        } catch (Exception e) {
            
            return false;
        }
        
        return false;
    }

    @Override
    public boolean Update(PaymentMethod c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            ps = con.getCon().prepareStatement(Update);
            
            ps.setString(1, c.getName());
            ps.setInt(2, c.getId());
            
            if (ps.executeUpdate() > 0) {
                
                return true;                
            }
            
            
        } catch (Exception e) {
            
            return false;
        }
        
        return false;
        
    }

    @Override
    public boolean DeleteByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
