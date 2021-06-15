/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.BackupStockProduct;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class BackupStockproductDao implements Icrud<BackupStockProduct> {
    //private static final String DeleteByKey= "Delete from Color where id = ?;";
    private static final String SelectByPage = "SELECT * FROM backupstockproduct ORDER BY ID desc limit ?,?;";
    // private static final String Insert = "INSERT INTO Color(name=?) values(?)";
    // private static final String Update = "UPDATE Color set name=? WHERE id=?;";
    private static final String SelectByAtrib = "SELECT * FROM backupstockproduct WHERE product_sku LIKE ?;";
    //private static final String SelectBykey ="SELECT * FROM Color;";
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    BackupStockProduct BackupStock = null;

    @Override
    public BackupStockProduct ListByAtrib(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BackupStockProduct> ListByPag(Object key, int start, int end) {
        
        ArrayList<BackupStockProduct> listaBS = new ArrayList<>();
        
        try {
            ps = con.getCon().prepareStatement(SelectByPage);
            ps.setInt(1, start);
            ps.setInt(2, end);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
               BackupStock = new BackupStockProduct();
               
               BackupStock.setId(rs.getInt("id"));
               BackupStock.setNewDatetime(rs.getString("NewDatetime"));
               BackupStock.setOldQuantity(rs.getDouble("OldQuantity"));
               BackupStock.setProduct_sku(rs.getString("product_sku"));
               BackupStock.setNewQuantity(rs.getDouble("NewQuantity"));
               BackupStock.setIdEmployee(rs.getInt("IdEmployee"));
               
               listaBS.add(BackupStock);
            }
            
            return listaBS;
            
        } catch (Exception e) {
            
            e.printStackTrace(System.out);
            
        }finally{  
            
            Conexion.CloseConexion();
        }
        return null;  
    }

    @Override
    public List<BackupStockProduct> ListByKey(Object key) {
        
        ArrayList<BackupStockProduct> listaBS = new ArrayList<>();
        
        try {
            ps = con.getCon().prepareStatement(SelectByAtrib);
            ps.setString(1, "%"+key.toString()+"%");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
               BackupStock = new BackupStockProduct();
               
               BackupStock.setId(rs.getInt("id"));
               BackupStock.setNewDatetime(rs.getString("NewDatetime"));
               BackupStock.setOldQuantity(rs.getDouble("OldQuantity"));
               BackupStock.setProduct_sku(rs.getString("product_sku"));
               BackupStock.setNewQuantity(rs.getDouble("NewQuantity"));
               BackupStock.setIdEmployee(rs.getInt("IdEmployee"));
               
               listaBS.add(BackupStock);
            }
            
            return listaBS;
            
        } catch (Exception e) {
            
            e.printStackTrace(System.out);
            
        }finally{  
            
            Conexion.CloseConexion();
        }
        return null; 
    }

    @Override
    public BackupStockProduct ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(BackupStockProduct c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update(BackupStockProduct c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
