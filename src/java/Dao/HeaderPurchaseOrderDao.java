/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.HeaderPurchaseOrder;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class HeaderPurchaseOrderDao implements Icrud<HeaderPurchaseOrder> {

    private static final String DeleteByKey = "DELETE FROM headerpurchaseorder WHERE id = ?;";
    //private static final String SelectByPage = "";
    private static final String Insert = "INSERT INTO headerpurchaseorder(purchasecode, typedocument, orderdate, subtotal, igv, commission, totalamount, modifidate, state, customer_id, paymentmethod_id,users_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String Update = "UPDATE headerpurchaseorder SET purchasecode=?,typedocument=?,orderdate=?,subtotal=?,igv=?,commission=?,totalamount=?,modifidate=?,state=?,customer_id=?,paymentmethod_id=? WHERE SET id=?;";
    private static final String SelectByAtrib = "SELECT * FROM headerpurchaseorder WHERE state = ? ORDER BY orderdate DESC limit 50;";
    //private static final String SelectBykey = "SELECT * FROM headerpurchaseorder WHERE purchasecode LIKE  ? ORDER BY orderdate DESC limit 50;";
    private static final String SelectBykey = "SELECT * FROM headerpurchaseorder AS h INNER JOIN customer AS c ON c.id = h.customer_id  INNER JOIN person p ON p.id = c.person_Id WHERE h.purchasecode LIKE  ? OR p.numdoc LIKE ? ORDER BY h.id DESC LIMIT 50;";
    private static final String SelectByFech = "SELECT * FROM headerpurchaseorder WHERE orderdate between ? and ? order by orderdate desc;";
    private static final String UpdateState = "UPDATE headerpurchaseorder  SET state= ? Where purchasecode = ?;";

    //total ventas por rango de fechas
    private static final String ventatotal ="SELECT SUM(ROUND(totalamount,3)) AS total FROM headerpurchaseorder WHERE orderdate BETWEEN ? AND ? AND state = 'a'; ";
    
    
    private static final Conexion con = Conexion.knowConexion();

    PreparedStatement ps = null;
    ResultSet rs = null;

    HeaderPurchaseOrder headerpurchase = null;
    //venta total por fecha
     public HeaderPurchaseOrder totalventas(Object a, Object b){
         
        try {
            ps = con.getCon().prepareStatement(ventatotal);
            
            ps.setString(1, a.toString());
            ps.setString(2, b.toString());
            
            headerpurchase = new HeaderPurchaseOrder();
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                headerpurchase.setTotalamount(rs.getDouble(1));
            }
            return headerpurchase;
            
        } catch (Exception e) {

            return null;
        } finally {
            Conexion.CloseConexion();
        }

       
    }
     
     //para anular la factura
    public boolean AnularFact(Object key){
        try {
            ps = con.getCon().prepareStatement(UpdateState);
            ps.setString(1, "i");
            ps.setString(2, key.toString());
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
    
    public boolean UpdateState(Object state, Object headerid) {
        try {
            ps = con.getCon().prepareStatement(UpdateState);
            ps.setString(1, state.toString());
            ps.setInt(2, headerid.hashCode());
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
    public HeaderPurchaseOrder ListByAtrib(Object key) {

        try {
            ps = con.getCon().prepareStatement(DeleteByKey);
            ps.setString(1, key.toString());

            rs = ps.executeQuery();

            while (rs.next()) {

                headerpurchase = new HeaderPurchaseOrder(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6), rs.getDouble(7), rs.getDouble(8), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
            }

            return headerpurchase;

        } catch (Exception e) {

            return null;
        }

    }

    public List<HeaderPurchaseOrder> listheadbyfech(Object fstar, Object fend) {

        ArrayList<HeaderPurchaseOrder> listbyfecha = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectByFech);
            ps.setString(1, fstar.toString());
            ps.setString(2, fend.toString());

            rs = ps.executeQuery();

            while (rs.next()) {
                 
                headerpurchase = new HeaderPurchaseOrder();
                 
                headerpurchase.setId(rs.getInt("id"));
                headerpurchase.setPurchasecode(rs.getString("purchasecode"));
                headerpurchase.setTypedocument(rs.getString("typedocument"));
                headerpurchase.setOrderdate(rs.getString("orderdate"));
                headerpurchase.setSubtotal(rs.getDouble("subtotal"));
                headerpurchase.setIgv(rs.getDouble("igv"));
                headerpurchase.setCommission(rs.getDouble("commission"));
                headerpurchase.setTotalamount(rs.getDouble("totalamount"));
                headerpurchase.setModifidate(rs.getString("modifidate"));
                headerpurchase.setState(rs.getString("state"));
                headerpurchase.setCustomer_id(rs.getInt("customer_id"));
                headerpurchase.setPaymentmethod_id(rs.getInt("paymentmethod_id"));

                listbyfecha.add(headerpurchase);
            }

            return listbyfecha;

        } catch (Exception e) {

            return null;
        } finally {
            Conexion.CloseConexion();
        }
    }

    @Override
    public List<HeaderPurchaseOrder> ListByPag(Object key, int start, int end) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //SelectByAtrib
        ArrayList<HeaderPurchaseOrder> listbyfecha = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectByAtrib);
            ps.setString(1, key.toString());

            rs = ps.executeQuery();

            while (rs.next()) {
                
                headerpurchase = new HeaderPurchaseOrder();

                headerpurchase.setId(rs.getInt("id"));
                headerpurchase.setPurchasecode(rs.getString("purchasecode"));
                headerpurchase.setTypedocument(rs.getString("typedocument"));
                headerpurchase.setOrderdate(rs.getString("orderdate"));
                headerpurchase.setSubtotal(rs.getDouble("subtotal"));
                headerpurchase.setIgv(rs.getDouble("igv"));
                headerpurchase.setCommission(rs.getDouble("commission"));
                headerpurchase.setTotalamount(rs.getDouble("totalamount"));
                headerpurchase.setModifidate(rs.getString("modifidate"));
                headerpurchase.setState(rs.getString("state"));
                headerpurchase.setCustomer_id(rs.getInt("customer_id"));
                headerpurchase.setPaymentmethod_id(rs.getInt("paymentmethod_id"));

                listbyfecha.add(headerpurchase);
            }

            return listbyfecha;

        } catch (Exception e) {

            return null;
        } finally {
            Conexion.CloseConexion();
        }
    }

    @Override
    public List<HeaderPurchaseOrder> ListByKey(Object key) {

        ArrayList<HeaderPurchaseOrder> listbyfecha = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectBykey);
            ps.setString(1, "%"+key.toString()+"%");
             ps.setString(2, "%"+key.toString()+"%");

            rs = ps.executeQuery();

            while (rs.next()) {
                
                headerpurchase = new HeaderPurchaseOrder();

                headerpurchase.setId(rs.getInt("id"));
                headerpurchase.setPurchasecode(rs.getString("purchasecode"));
                headerpurchase.setTypedocument(rs.getString("typedocument"));
                headerpurchase.setOrderdate(rs.getString("orderdate"));
                headerpurchase.setSubtotal(rs.getDouble("subtotal"));
                headerpurchase.setIgv(rs.getDouble("igv"));
                headerpurchase.setCommission(rs.getDouble("commission"));
                headerpurchase.setTotalamount(rs.getDouble("totalamount"));
                headerpurchase.setModifidate(rs.getString("modifidate"));
                headerpurchase.setState(rs.getString("state"));
                headerpurchase.setCustomer_id(rs.getInt("customer_id"));
                headerpurchase.setPaymentmethod_id(rs.getInt("paymentmethod_id"));

                listbyfecha.add(headerpurchase);
            }

            return listbyfecha;

        } catch (Exception e) {

            return null;
        } finally {
            Conexion.CloseConexion();
        }

    }

    @Override
    public HeaderPurchaseOrder ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(HeaderPurchaseOrder c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //int lastId =0;
        try {

            ps = con.getCon().prepareStatement(Insert, PreparedStatement.RETURN_GENERATED_KEYS);

            //ps.setDouble(,c.get id());
            ps.setString(1, c.getPurchasecode());
            ps.setString(2, c.getTypedocument());
            ps.setString(3, c.getOrderdate());
            ps.setDouble(4, c.getSubtotal());
            ps.setDouble(5, c.getIgv());
            ps.setDouble(6, c.getCommission());
            ps.setDouble(7, c.getTotalamount());
            ps.setString(8, c.getModifidate());
            ps.setString(9, c.getState());
            ps.setInt(10, c.getCustomer_id());
            ps.setInt(11, c.getPaymentmethod_id());
            ps.setInt(12, c.getUsersId());

            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    return true;
                }
            }

        } catch (Exception e) {
            return false;

        } finally {
            Conexion.CloseConexion();
        }

        return false;
    }

    @Override
    public boolean Update(HeaderPurchaseOrder c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {

            ps = con.getCon().prepareStatement(Update);

            ps.setString(1, c.getPurchasecode());
            ps.setString(2, c.getTypedocument());
            ps.setString(3, c.getOrderdate());
            ps.setDouble(4, c.getSubtotal());
            ps.setDouble(5, c.getIgv());
            ps.setDouble(6, c.getCommission());
            ps.setDouble(7, c.getTotalamount());
            ps.setString(8, c.getModifidate());
            ps.setString(9, c.getState());
            ps.setInt(10, c.getCustomer_id());
            ps.setInt(11, c.getPaymentmethod_id());
            ps.setDouble(12, c.getId());

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
            ps = con.getCon().prepareStatement(DeleteByKey);
            ps.setInt(1, key.hashCode());
            
            if (ps.executeUpdate()>0) {
                
                return true;
            }
            
        } catch (Exception e) {
            
            return false;
        }
        
        return false;
    }

    
    public int insertGetId(HeaderPurchaseOrder c){
    
         try {

            ps = con.getCon().prepareStatement(Insert, PreparedStatement.RETURN_GENERATED_KEYS);

            //ps.setDouble(,c.get id());
            ps.setString(1, c.getPurchasecode());
            ps.setString(2, c.getTypedocument());
            ps.setString(3, c.getOrderdate());
            ps.setDouble(4, c.getSubtotal());
            ps.setDouble(5, c.getIgv());
            ps.setDouble(6, c.getCommission());
            ps.setDouble(7, c.getTotalamount());
            ps.setString(8, c.getModifidate());
            ps.setString(9, c.getState());
            ps.setInt(10, c.getCustomer_id());
            ps.setInt(11, c.getPaymentmethod_id());
            ps.setInt(12, c.getUsersId());

            if (ps.executeUpdate() > 0) {
                rs = ps.getGeneratedKeys();
                while (rs.next()) {
                    return rs.getInt(1);
                }
            }

        } catch (Exception e) {
            return -1;

        } finally {
            Conexion.CloseConexion();
        }

        return -1;
    }
}
