
package Dao;

import Config.Conexion;
import Entity.PedidoHeader;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PedidoHeaderDao implements Icrud<PedidoHeader>{
    
    private static final String DeleteByKey= "DELETE FROM pedidoherader WHERE  id = ? OR numpedido = ?;";
    private static final String SelectByPage = "";
    private static final String Insert = "";
    private static final String Update = "UPDATE pedidoherader SET fechaentrega=?, igvped=?, descuentoa=?, descuentob=?, subtotal=?, montototal=?, responsable=?, contacto=?, state=? WHERE id = ? OR numpedido = ?;";
    private static final String SelectByAtrib = "SELECT * FROM pedidoherader WHERE id=? OR numpedido = ?;";
    private static final String SelectBykey ="";
    private static final String SelectByProv ="SELECT * FROM pedidoherader WHERE idproveedor = ? order by fechaped desc limit 50;";  
    
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    PedidoHeader pedidoH = null;
    
    
    @Override
    public PedidoHeader ListByAtrib(Object key) { // retorna un solo pedido
        
        try {
            ps = con.getCon().prepareStatement(SelectByAtrib);
            ps.setInt(1, key.hashCode());
            ps.setString(2, key.toString());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                pedidoH = new PedidoHeader(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getDouble(9), rs.getString(10), rs.getString(11), rs.getString(12),rs.getInt(13));
                
            }
            
            return pedidoH;
            
        } catch (Exception e) {
            
            return null;
        }finally{
            Conexion.CloseConexion();
        }
    }

    @Override
    public List<PedidoHeader> ListByPag(Object key, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PedidoHeader> ListByKey(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       ArrayList<PedidoHeader>listaPed = new ArrayList<>();
        
        try {
            ps = con.getCon().prepareStatement(SelectByProv);            
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                pedidoH = new PedidoHeader();
                
                pedidoH.setId(rs.getInt("id"));
                pedidoH.setNumpedido(rs.getString("numpedido"));
                pedidoH.setFechaped(rs.getString("fechaped"));
                pedidoH.setFechaentrega(rs.getString("fechaentrega"));
                pedidoH.setIgvped(rs.getDouble("igvped"));
                pedidoH.setDescuentoa(rs.getDouble("descuentoa"));
                pedidoH.setDescuentob(rs.getDouble("descuentob"));
                pedidoH.setSubtotal(rs.getDouble("subtotal"));
                pedidoH.setMontototal(rs.getDouble("montototal"));
                pedidoH.setResponsable(rs.getString("responsable"));
                pedidoH.setContacto(rs.getString("contacto"));
                pedidoH.setState(rs.getString("state"));
                pedidoH.setIdproveedor(rs.getInt("idproveedor"));
                
                listaPed.add(pedidoH);
            }
            
            return listaPed;
            
        } catch (Exception e) {
            
            return null;
           // e.printStackTrace(System.out);
            
        }finally{        
            Conexion.CloseConexion();
        }
        
        //return null;
    }

    @Override
    public PedidoHeader ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean Insert(PedidoHeader c) { // inserta un pedido
        
        try {
            ps = con.getCon().prepareStatement(Insert);
            
            //ps.setDouble(1,c.getid());
            ps.setString(1,c.getNumpedido());
            ps.setString(2,c.getFechaped());
            ps.setString(3,c.getFechaentrega());
            ps.setDouble(4,c.getIgvped());
            ps.setDouble(5,c.getDescuentoa());
            ps.setDouble(6,c.getDescuentob());
            ps.setDouble(7,c.getSubtotal());
            ps.setDouble(8,c.getMontototal());
            ps.setString(9,c.getResponsable());
            ps.setString(10,c.getContacto());
            ps.setString(11, c.getState());
            ps.setInt(12,c.getIdproveedor());
            
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
    public boolean Update(PedidoHeader c) { //Actualiza un pedido por id o codigo documento
       
        
         try {
            ps = con.getCon().prepareStatement(Update);            
            
            
            ps.setString(1, c.getFechaentrega());
            ps.setDouble(2, c.getIgvped());
            ps.setDouble(3, c.getDescuentoa());
            ps.setDouble(4, c.getDescuentob());
            ps.setDouble(5, c.getSubtotal());
            ps.setDouble(6, c.getMontototal());
            ps.setString(7, c.getResponsable());
            ps.setString(8, c.getContacto());
            ps.setString(9, c.getState());
            
            
            ps.setInt(10,c.getId());
            ps.setString(11,c.getNumpedido());
            
            
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
    public boolean DeleteByKey(Object key) { //Elimina un pedido
        
       
        try {
            ps = con.getCon().prepareStatement(DeleteByKey);          
            
            ps.setInt(1, key.hashCode());
            ps.setString(2, key.toString());
            
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
    
    
}
