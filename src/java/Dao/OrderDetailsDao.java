/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.OrderDetails;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class OrderDetailsDao implements Icrud<OrderDetails>{
    
    
    
    private static final String DeleteByKey= "DELETE FROM orderdetails WHERE  id = ?;";
    private static final String SelectByHeadId = "DELETE FROM orderdetails WHERE headerid = ?;";
    private static final String Insert = "INSERT INTO orderdetails(quantity, discount, amount, peso, simbolo, color, productname, product_sku, headerid) VALUES (?,?,?,?,?,?,?,?,?);";
    private static final String Update = "UPDATE orderdetails SET quantity=? ,discount=? ,amount=? ,peso=? ,simbolo=? ,color=? ,productname=? ,product_sku=? , headerid=?  WHERE id=?;";
    private static final String SelectByAtrib = "";
    private static final String SelectBykey ="SELECT *  FROM orderdetails WHERE headerid = ?;";
    
    //monto total de productos vendidos x dia, semana mes,
    private static final String montoxproducto = "";
    //Cantidad total de productos vendidos x dia, semana mes,
    private static final String cantixproducto = ""    
    +"SELECT o.productname, ROUND(o.peso,1) AS peso, o.simbolo, SUM(ROUND(o.quantity,1)) AS cant, SUM(ROUND(o.amount*o.quantity,2)) AS monto  "
    +"FROM orderdetails AS o INNER JOIN headerpurchaseorder AS h ON o.headerid = h.id "
    +"WHERE h.orderdate BETWEEN ? AND ? AND   h.state = 'a' "
    +"GROUP BY  o.product_sku, o.productname, peso, o.simbolo ORDER BY monto DESC ";//LIMIT 30;
    
    
     private static final String totalventas = ""  
    +"SELECT SUM(ROUND(o.quantity,1)) AS cant, SUM(ROUND(o.amount*o.quantity,2)) AS monto  "
    +"FROM orderdetails AS o INNER JOIN headerpurchaseorder AS h ON o.headerid = h.id  "
    +"WHERE h.orderdate  LIKE ?  AND   h.state = 'a' ;";
     
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    OrderDetails orderdetails = null;
    
    
    // total de ventas
    public OrderDetails ListTotalProduct(String a) {
     
        try {
            
            ps = con.getCon().prepareStatement(totalventas);
            ps.setString(1, a.toString()+"%");            
            
            rs = ps.executeQuery();
            orderdetails = new OrderDetails();  
            
            while (rs.next()) {
                
                orderdetails.setQuantity(rs.getDouble(1));;
                orderdetails.setTotalPagar(rs.getDouble(2));                
            }
            
            return orderdetails;
            
        }catch(Exception e){
            return null;
        }
    
    }
    
    //monto total de productos vendidos x dia, semana mes,
    public List<OrderDetails> ListTotalProduct(Object a, Object b) {
        ArrayList<OrderDetails> l = new ArrayList<>();
        
        try {
            ps = con.getCon().prepareStatement(cantixproducto);
            ps.setString(1, a.toString());
            ps.setString(2, b.toString());
            
            
            rs = ps.executeQuery();
            while (rs.next()) { 
                orderdetails = new OrderDetails();
                
                orderdetails.setProductname(rs.getString(1));
                orderdetails.setPeso(rs.getDouble(2));
                orderdetails.setSimbolo(rs.getString(3));
                orderdetails.setQuantity(rs.getDouble(4));
                orderdetails.setTotalPagar(rs.getDouble(5));
                
                l.add(orderdetails);
            }
            return l;
            
        }catch(Exception e){
            return null;
        }
        
    }
    
    @Override
    public OrderDetails ListByAtrib(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDetails> ListByPag(Object key, int start, int end) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<OrderDetails> listOrder = new ArrayList<>();
        
        try {
            
            ps = con.getCon().prepareStatement(SelectBykey);
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            while (rs.next()) {                
                
                orderdetails = new OrderDetails();
                
                orderdetails.setId(rs.getInt("id"));
                orderdetails.setQuantity(rs.getDouble("quantity"));
                orderdetails.setDiscount(rs.getDouble("discount"));
                orderdetails.setAmount(rs.getDouble("amount"));
                orderdetails.setPeso(rs.getDouble("peso"));
                orderdetails.setSimbolo(rs.getString("simbolo"));
                orderdetails.setColor(rs.getString("color"));
                orderdetails.setProductname(rs.getString("productname"));
                orderdetails.setProduct_sku(rs.getString("product_sku"));
                orderdetails.setHeaderid(rs.getInt("headerid"));
                
                listOrder.add(orderdetails);
            }
            
            return listOrder;
            
        } catch (Exception e) {
            
            return null;
        }
    }

    @Override
    public List<OrderDetails> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OrderDetails ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(OrderDetails c) {
        
        try {
            
            ps = con.getCon().prepareStatement(Insert);
            ps.setDouble(1,c.getQuantity());
            ps.setDouble(2,c.getDiscount());
            ps.setDouble(3,c.getAmount());
            ps.setDouble(4,c.getPeso());
            ps.setString(5,c.getSimbolo());
            ps.setString(6,c.getColor());
            ps.setString(7,c.getProductname());
            ps.setString(8,c.getProduct_sku());
            ps.setInt(9,c.getHeaderid());
            
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
    public boolean Update(OrderDetails c) {
        
        try {
            
            ps = con.getCon().prepareStatement(Update);
            
            ps.setDouble(1,c.getQuantity());
            ps.setDouble(2,c.getDiscount());
            ps.setDouble(3,c.getAmount());
            ps.setDouble(4,c.getPeso());
            ps.setString(5,c.getSimbolo());
            ps.setString(6,c.getColor());
            ps.setString(7,c.getProductname());
            ps.setString(8,c.getProduct_sku());
            ps.setInt(9,c.getHeaderid());
            ps.setInt(10, c.getId());            
            
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
    
    
    public boolean DeleteByHeadId(Object key){
        try {
            
            ps = con.getCon().prepareStatement(SelectByHeadId);
            
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
}
