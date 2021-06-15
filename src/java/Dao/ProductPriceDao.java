
package Dao;

import Config.Conexion;
import Entity.ProductPrice;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProductPriceDao implements Icrud<ProductPrice>{
    //private static final String DeleteByKey = "Delete from product where sku = ?;";
    //private static final String SelectByPage = "SELECT * FROM  products limit ?,?;";
    private static final String Insert = "INSERT INTO product_price(price, state, pricepromo, cantidadpromo, fexpiration, products_sku) VALUES (?,?,?,?,?,?);";
    private static final String Update = "UPDATE product_price SET price=?,pricepromo=?,cantidadpromo=?,fexpiration=?  WHERE products_sku=?;";
    private static final String SelectByAtrib = "SELECT * FROM  product_price  WHERE  products_sku = ?;";
    private static final String DeleteBySku ="DELETE FROM product_price WHERE products_sku = ?;";
    
    
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    ProductPrice pPrice = null;

    @Override
    public ProductPrice ListByAtrib(Object key) {
        
       try {
            
            ps = con.getCon().prepareStatement(SelectByAtrib);

            ps.setString(1, key.toString());

            rs = ps.executeQuery();

            while (rs.next()) {
                
                pPrice = new ProductPrice(rs.getInt(1), rs.getDouble(2), rs.getString(3), rs.getDouble(4), rs.getDouble(5), rs.getString(6), rs.getString(7));
            }
            
            return  pPrice;
            
        } catch (Exception e) {
            
            e.printStackTrace(System.out);
            
        }finally {
            Conexion.CloseConexion();
        }
        
        return null; 
        
    }



    @Override
    public boolean Insert(ProductPrice c) {
        
        
        try {
            ps = con.getCon().prepareStatement(Insert);

            ps.setDouble(1, c.getPrice());
            ps.setString(2, c.getState());
            ps.setDouble(3, c.getPricepromo());
            ps.setDouble(4, c.getCantidadpromo());
            ps.setString(5, c.getFexpiration());
            ps.setString(6, c.getProducts_sku());            
            
            if (ps.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            
            return false;
            
           // e.printStackTrace(System.out);

        } finally {
            Conexion.CloseConexion();
        }

        return false;
        
    }

    @Override
    public boolean Update(ProductPrice c) {
       
        try {
            ps = con.getCon().prepareStatement(Update);

            ps.setDouble(1, c.getPrice());
            ps.setDouble(2, c.getPricepromo());
            ps.setDouble(3, c.getCantidadpromo());
            ps.setString(4, c.getFexpiration());
            ps.setString(5, c.getProducts_sku());            
            
            if (ps.executeUpdate() > 0) {

                return true;
            }

        } catch (Exception e) {
            
            return false;

        } finally {
            Conexion.CloseConexion();
        }

        return false;
        
    }

    @Override
    public boolean DeleteByKey(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            
            ps = con.getCon().prepareStatement(DeleteBySku);
            ps.setString(1, key.toString());
            
            if (ps.executeUpdate() > 0){
                
                return true;
            }           
            
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
            //return false;
            
        }finally{
        
            Conexion.CloseConexion();
        }
        
        return false;
        
    }
    
    @Override
    public List<ProductPrice> ListByPag(Object key, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ProductPrice> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductPrice ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
