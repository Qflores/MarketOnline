/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.CreditDetails;
import Entity.Credits;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public class CreditsDao implements Icrud<Credits>{

    private static final String DeleteByKey= "";
    private static final String SelectByPage = "";
    private static final String Insert = "INSERT INTO credits(amount, state, description, period, expirationdate, namecustomer, headerId) VALUES (?,?,?,?,?,?,?);";
    private static final String Update = "UPDATE credits SET state=? WHERE headerId=?;";
    private static final String SelectByAtrib = "";
    private static final String SelectBykey ="SELECT * FROM credits WHERE headerId = ?;";
    private static final String SelectbyHead ="SELECT id, state, amount FROM credits WHERE  headerId = ?";
    private static final String SelectMounts ="SELECT c.id, c.state, c.amount, SUM(IFNULL(d.amountpay,0)) AS pagos FROM credits AS c INNER JOIN creditdetail AS d ON c.id = d.credits_id WHERE c.headerId = ? GROUP BY d.credits_id";
    
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
         
    Credits credits= null; 
//datos de cabecero de decudas
    public Credits infocredihead(Object key) {//mostramos las dedudas        
        
        try {
            ps = con.getCon().prepareStatement(SelectbyHead);
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                credits = new Credits();
                
                credits.setId(rs.getInt(1));
                credits.setState(rs.getString(2));
                credits.setAmount(rs.getDouble(3));
                 
            }
            
            return credits;
            
        } catch (Exception e) {
            
            return null;
        }finally{
            Conexion.CloseConexion();
        }
    }
    
    public Credits ViewCredits(Object key) {//mostramos las dedudas        
        
        try {
            ps = con.getCon().prepareStatement(SelectMounts);
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                credits = new Credits();
                credits.setId(rs.getInt(1));
                credits.setState(rs.getString(2));
                credits.setAmount(rs.getDouble(3));
                credits.setCdetalle(new CreditDetails(rs.getDouble(4)));  
            }
            
            return credits;
            
        } catch (Exception e) {
            
            return null;
        }finally{
            Conexion.CloseConexion();
        }
    }
    
    
    @Override
    public Credits ListByAtrib(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            ps = con.getCon().prepareStatement(SelectBykey);
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                credits = new Credits(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }            
            return credits;            
        } catch (Exception e) {            
            return null;
        }finally{
            Conexion.CloseConexion();
        }
    }

    @Override
    public List<Credits> ListByPag(Object key, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Credits> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Credits ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(Credits c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //ps.setString(,c.get id());
                
        try {
            ps = con.getCon().prepareStatement(Insert);
            
            ps.setDouble(1,c.getAmount());
            ps.setString(2,c.getState());
            ps.setString(3,c.getDescription());
            ps.setInt(4,c.getPeriod());
            ps.setString(5,c.getExpirationdate());
            ps.setString(6,c.getNamecustomer());
            ps.setInt(7,c.getHeaderId());
            
            
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
    public boolean Update(Credits c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
            ps = con.getCon().prepareStatement(Update);
            
            ps.setString(1,c.getState());
            ps.setInt(2,c.getHeaderId());
            
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
