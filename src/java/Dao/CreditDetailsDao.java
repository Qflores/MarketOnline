/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.CreditDetails;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class CreditDetailsDao implements Icrud<CreditDetails>{
    
    //private static final String DeleteByKey= "";
    //private static final String SelectByPage = "";
    private static final String Insert = "INSERT INTO creditdetail(cuota, amountpay, mora, fechapago, namecustomer, credits_id) VALUES (1,?,0,NOW(),?,?);";                                        
    //private static final String Update = "";
    private static final String SelectByAtrib = "SELECT SUM(IFNULL(d.amountpay,0)) as total FROM creditdetail AS d WHERE credits_id = ?;";
    private static final String SelectBykey ="SELECT d.id, d.amountpay, d.fechapago, d.namecustomer, c.headerId FROM creditdetail  d INNER JOIN credits c ON d.credits_id = c.id  WHERE  c.headerid =?;";
    
    private static final String SelectByIdFact ="SELECT *  FROM creditdetail WHERE  credits_id = ?;";
    
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
        
    CreditDetails creditdetails =null;
    

    @Override
    public CreditDetails ListByAtrib(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            ps = con.getCon().prepareStatement(SelectByAtrib);
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                creditdetails = new CreditDetails(rs.getDouble("total")); // revisar el codigo
              }
            return creditdetails;
            
        } catch (Exception e) {
            return null;
        }finally{
            Conexion.CloseConexion();
        }
        
    }

    @Override
    public List<CreditDetails> ListByPag(Object key, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CreditDetails> ListByKey(Object key) {        
        ArrayList<CreditDetails> listdetail = new ArrayList<>();        
        try {
            
            ps = con.getCon().prepareStatement(SelectBykey);
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                creditdetails = new CreditDetails();
                
                creditdetails.setId(rs.getInt(1));                
                creditdetails.setAmountpay(rs.getDouble(2));                
                creditdetails.setFechapago(rs.getString(3));
                creditdetails.setNamecustomer(rs.getString(4));
                creditdetails.setCredits_id(rs.getInt(5));
                
                listdetail.add(creditdetails);
            }
            
            return listdetail;
            
        } catch (Exception e) {
            return null;
        }finally{
            Conexion.CloseConexion();
        }
        //return null;
        
    }

    @Override
    public CreditDetails ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(CreditDetails c) {
        
        
        try {
            
            ps = con.getCon().prepareStatement(Insert); 
            ps.setDouble(1, c.getAmountpay());
            ps.setString(2, c.getNamecustomer());
            ps.setInt(3, c.getCredits_id());
            
            if (ps.executeUpdate() > 0) {
                
                return  true;
            }
            
            
        } catch (Exception e) {
            return false;
        }finally{
            Conexion.CloseConexion();
        }
        
        return false;
        
    }

    @Override
    public boolean Update(CreditDetails c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
