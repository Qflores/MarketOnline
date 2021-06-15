
package Dao;

import Config.Conexion;
import Entity.PedidoDetails;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PedidoDetailsDao implements Icrud<PedidoDetails>{

    private static final String DeleteByKey= "DELETE FROM pedidodetails WHERE id = ?;";
    private static final String DeleteByHeaderId= "DELETE FROM pedidodetails WHERE pedidoid = ?;";
    private static final String SelectByPage = "";
    private static final String Insert = "INSERT INTO pedidodetails(productsku, nameproduct, description, quantity, priceunit, pricesugerido, descuento, quantitypack, subtotal, importe, igvped, pedidoid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String Update = "UPDATE pedidodetails SET productsku=?,nameproduct=?,description=?,quantity=?,priceunit=?,pricesugerido=?,descuento=?,quantitypack=?,subtotal=?,importe=?,igvped=?,pedidoid=? WHERE id=?;";
    private static final String SelectByAtrib = "SELECT * FROM pedidodetails WHERE pedidoid = ?;";
    private static final String SelectBykey ="SELECT * FROM pedidodetails WHERE id = ?;"; //retormn uno
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
        
    PedidoDetails pedidod =null;
    
    
    @Override
    public PedidoDetails ListByAtrib(Object key) {
                 
        try {            
        
            ps = con.getCon().prepareStatement(SelectBykey);
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
               
               pedidod = new  PedidoDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getDouble(12), rs.getInt(13)); 
                
            }
            
            return pedidod;
            
        } catch (Exception e) {            
            return null;
        }finally{
            Conexion.CloseConexion();
        }
        
                
    }

    @Override
    public List<PedidoDetails> ListByPag(Object key, int start, int end) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<PedidoDetails>listpd = new ArrayList<>();
         try {            
        
            ps = con.getCon().prepareStatement(SelectByAtrib);
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
               
               pedidod = new  PedidoDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getDouble(12), rs.getInt(13)); 
               listpd.add(pedidod);
            }
            
            return listpd;
            
        } catch (Exception e) {            
            return null;
        }finally{
            Conexion.CloseConexion();
        }
    }

    @Override
    public List<PedidoDetails> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PedidoDetails ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(PedidoDetails c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
             
            ps = con.getCon().prepareStatement(Insert);
            
            ps.setString(1,c.getProductsku());
            ps.setString(2,c.getNameproduct());
            ps.setString(3,c.getDescription());
            ps.setDouble(4,c.getQuantity());
            ps.setDouble(5,c.getPriceunit());
            ps.setDouble(6,c.getPricesugerido());
            ps.setDouble(7,c.getDescuento());
            ps.setDouble(8,c.getQuantitypack());
            ps.setDouble(9,c.getSubtotal());
            ps.setDouble(10,c.getImporte());
            ps.setDouble(11,c.getIgvped());
            ps.setInt(12,c.getPedidoid());
            
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
    public boolean Update(PedidoDetails c) {
        
         try {
             
            ps = con.getCon().prepareStatement(Update);
            
            ps.setString(1,c.getProductsku());
            ps.setString(2,c.getNameproduct());
            ps.setString(3,c.getDescription());
            ps.setDouble(4,c.getQuantity());
            ps.setDouble(5,c.getPriceunit());
            ps.setDouble(6,c.getPricesugerido());
            ps.setDouble(7,c.getDescuento());
            ps.setDouble(8,c.getQuantitypack());
            ps.setDouble(9,c.getSubtotal());
            ps.setDouble(10,c.getImporte());
            ps.setDouble(11,c.getIgvped());
            ps.setInt(12,c.getPedidoid());
            ps.setInt(13,c.getId());
            
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {            
        
            ps = con.getCon().prepareStatement(DeleteByKey);
            ps.setInt(1, key.hashCode());
            
            if (ps.executeUpdate()> 0) {
                return true;
            }            
            
        } catch (Exception e) {            
            return false;
        }finally{
            Conexion.CloseConexion();
        }
        
        return false;
    }
   
    public boolean DeleteByHeadId(Object key) {
         try {            
        
            ps = con.getCon().prepareStatement(DeleteByHeaderId);
            ps.setInt(1, key.hashCode());
            
            if (ps.executeUpdate()> 0) {
                return true;
            }            
            
        } catch (Exception e) {            
            return false;
        }finally{
            Conexion.CloseConexion();
        }
        
        return false;
    }
    
}
