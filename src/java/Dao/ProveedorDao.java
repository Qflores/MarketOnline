/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.Contact;
import Entity.Person;
import Entity.Proveedor;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class ProveedorDao implements Icrud<Proveedor>{
    
    //private static final String DeleteByKey= "";
    private static final String SelectByPage = "call sp_listprovedor(?,?)";    
    private static final String Insert = "INSERT INTO proveedor(Businessname, contactname, person_Id) VALUES (?,?,?);";
    private static final String Update = "UPDATE proveedor SET Businessname=?, contactname=? WHERE person_Id=?;";
    //private static final String SelectByAtrib = "";
    private static final String SelectBykey ="SELECT  * FROM proveedor WHERE person_Id = ?";
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    Proveedor proveedor = null;
  

    @Override
    public Proveedor ListByAtrib(Object key) {
        
        try {

            ps = con.getCon().prepareStatement(SelectBykey);
            ps.setInt(1, key.hashCode());

            rs = ps.executeQuery();

            while (rs.next()) {
                
                proveedor = new Proveedor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }

            return proveedor;

        } catch (Exception e) {
            //e.printStackTrace(System.out);
            return null;
        } finally {
            Conexion.CloseConexion();
        }
        
        //return null;
    }

    @Override
    public List<Proveedor> ListByPag(Object key, int start, int end) {
        
        ArrayList<Proveedor> listPro = new ArrayList<>();
        
        try {
            ps = con.getCon().prepareStatement(SelectByPage);
            
            ps.setString(1, key.toString());
            ps.setInt(2, start);

            rs = ps.executeQuery();

            while (rs.next()) {
                
                proveedor = new Proveedor();
                
                proveedor.setPerson_Id(rs.getInt("person_Id"));
                proveedor.setBusinessname(rs.getString("Businessname"));
                proveedor.setContactname(rs.getString("contactname"));
                proveedor.setPersona(new Person(rs.getString("numdoc")));
                proveedor.setAddress(new Contact(rs.getString("numphone"), rs.getString("numhouse"), rs.getString("numwork"), rs.getString("email")));
                
                listPro.add(proveedor);
            }

            return listPro;

        } catch (Exception e) {
            //e.printStackTrace(System.out);
            return null;
        } finally {
            Conexion.CloseConexion();
        }
        
        
        
    }

    @Override
    public List<Proveedor> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Proveedor ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(Proveedor c) {
        
        try {
            ps = con.getCon().prepareStatement(Insert);

            ps.setString(1, c.getBusinessname());
            ps.setString(2, c.getContactname());
            ps.setInt(3, c.getPerson_Id());

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
    public boolean Update(Proveedor c) {
        
       try {
            ps = con.getCon().prepareStatement(Update);

            ps.setString(1, c.getBusinessname());
            ps.setString(2, c.getContactname());
            
            ps.setInt(3, c.getPerson_Id());

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
