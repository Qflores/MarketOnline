
package Dao;

import Config.Conexion;
import Entity.StockProduct;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StockProductDao implements Icrud<StockProduct>{
    
    private static final String DeleteByKey = "DELETE FROM stockproduct WHERE id=?;";
    private static final String SelectAll = "SELECT * FROM stockproduct limit ?,?;";
    private static final String Insert = "INSERT INTO stockproduct (quantity, fupdate, products_sku, humantalent_id) VALUES (?,?,?,?);";
    private static final String Update = "UPDATE stockproduct SET quantity = ?, fupdate=?,humantalent_id=?, WHERE products_sku=?;";
    private static final String SelectByAtrib = "SELECT * FROM stockproduct WHERE products_sku = ?;";
    private static final String SelectByKey = "SELECT * FROM stockproduct where id = ?;";
    private static final String UpdateQuantity = "UPDATE stockproduct SET quantity= ? WHERE products_sku=?;";
    
    
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    
    ResultSet rs = null;
    
    StockProduct stock = null;
    
    public boolean UpdateQuantity(Object quantity, Object sku){
        
        try {
            ps = con.getCon().prepareStatement(UpdateQuantity);
            ps.setDouble(1, quantity.hashCode());
            ps.setString(2, sku.toString());
            
            if (ps.executeUpdate() > 0) {
                
                return true;
            }
            
            
        } catch (Exception e) {
            
            return false;
        }
        
        return false;
    }
    
    @Override
    public StockProduct ListByAtrib(Object key) {

        try 
        {
            ps = con.getCon().prepareStatement(SelectByAtrib);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();
                        
            while(rs.next())
            {               
                stock = new StockProduct(rs.getInt(1) ,rs.getDouble(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            }
            
            return stock;
            
        } 
        catch (Exception e) 
        {
            //e.printStackTrace(System.out);
            return null;
        }
        finally
        {
            Conexion.CloseConexion();
        }
        
        //return null;
        
    }
    
    
    @Override
    public List<StockProduct> ListByKey(Object key) {
        
        ArrayList<StockProduct>listaS = new ArrayList<>();
        
        try {
            ps = con.getCon().prepareStatement(SelectByKey);
            
            ps.setString(1, "%"+key.toString()+"%");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                stock = new StockProduct();
                
                stock.setId(rs.getInt("id"));
                stock.setQuantity(rs.getDouble("quantity"));  
                stock.setFupdate(rs.getString("fupdate"));  
                stock.setProducts_sku(rs.getString("products_sku"));  
                stock.setHumantalent_id(rs.getInt("humantalent_id")); 
                
                listaS.add(stock);
            }
            
            return listaS;
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{        
            Conexion.CloseConexion();
        }
        
        return null;
    }
    
    
    @Override
    public List<StockProduct> ListByPag(Object key,int start, int end) {
        
        ArrayList<StockProduct>listaS = new ArrayList<>();
        
        try {
            ps = con.getCon().prepareStatement(SelectAll);
            
            //ps.setInt(1, start);
           // ps.setInt(2, end);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                stock = new StockProduct();
                
                stock.setId(rs.getInt("id"));
                stock.setQuantity(rs.getDouble("quantity"));  
                stock.setFupdate(rs.getString("fupdate"));  
                stock.setProducts_sku(rs.getString("products_sku"));  
                stock.setHumantalent_id(rs.getInt("humantalent_id")); 
                
                listaS.add(stock);
            }
            
            return listaS;
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{        
            Conexion.CloseConexion();
        }
        
        return null;
    }



    @Override
    public boolean Insert(StockProduct c) {
        
         try {
             
            ps = con.getCon().prepareStatement(Insert);
            
            ps.setDouble(1, c.getQuantity());
            ps.setString(2, c.getFupdate()); 
            ps.setString(3, c.getProducts_sku());
            ps.setInt(4, c.getHumantalent_id());
            
            
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
    public boolean Update(StockProduct c) {
         try {
            ps = con.getCon().prepareStatement(Update); //pasa sku para actualizar
            
            ps.setDouble(1, c.getQuantity());
            ps.setString(2, c.getFupdate());           
            ps.setInt(3, c.getHumantalent_id());           
            ps.setString(4, c.getProducts_sku());
            
            
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
         try {
            ps = con.getCon().prepareStatement(DeleteByKey);
            
            ps.setInt(1, key.hashCode());
            
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
    public StockProduct ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
