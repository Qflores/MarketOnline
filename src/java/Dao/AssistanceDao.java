/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.Assistance;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class AssistanceDao implements Icrud<Assistance>{
 
    
    private static final String DeleteByKey= "DELETE FROM assistance WHERE id=?;";
    private static final String DeleteByFeHumanId= "DELETE FROM assistance WHERE fecha=? AND humantalent_id=?;";
    //private static final String SelectByPage = "";
    private static final String Insert = "INSERT INTO assistance(fecha, starttime, endtime, cause, humantalent_id) VALUES (?,?,?,?,?);";
    private static final String Update = "UPDATE assistance SET fecha=?, starttime=?, endtime=?, cause=?, humantalent_id=?  WHERE id=?;";
    private static final String UpdateEndWord ="UPDATE assistance SET endtime=? WHERE  fecha=? AND humantalent_id=?;";
    private static final String UpdateEndPause ="UPDATE assistance SET endtime=?, cause=? WHERE fecha=? AND humantalent_id=?;";
    private static final String SelectByAtrib = "SELECT * FROM assistance WHERE humantalent_id=? ORDER BY fecha DESC LIMIT 50;";
    private static final String SelectBykey ="SELECT *  FROM assistance WHERE id = ?;";
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    Assistance assistance = null;

    @Override
    public Assistance ListByAtrib(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {

            ps = con.getCon().prepareStatement(SelectBykey);

            ps.setInt(1, key.hashCode());

            rs = ps.executeQuery();

            while (rs.next()) {
                assistance = new Assistance(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
            }

            return assistance;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.CloseConexion();
        }

        return null;
    }

    @Override
    public List<Assistance> ListByPag(Object key, int start, int end) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //SelectByAtrib
        ArrayList<Assistance> listAs = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectByAtrib);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();

            while (rs.next()) {

                assistance = new Assistance();

                assistance.setId(rs.getInt("id"));
                assistance.setFecha(rs.getString("fecha"));
                assistance.setStarttime(rs.getString("starttime"));
                assistance.setEndtime(rs.getString("endtime"));
                assistance.setCause(rs.getString("cause"));
                assistance.setHumantalent_id(rs.getInt("humantalent_id"));               
                
                listAs.add(assistance);
            }
            
            return listAs;
            
        } catch (Exception e) {
            //e.printStackTrace(System.out);
            
            return null;
        } finally {
            Conexion.CloseConexion();
        }

        //return null;
    }

    @Override
    public List<Assistance> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Assistance ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(Assistance c) {
        
        try {
            ps = con.getCon().prepareStatement(Insert);

            //ps.setString(1,c.get id());
            ps.setString(1,c.getFecha());
            ps.setString(2,c.getStarttime());
            ps.setString(3,c.getEndtime());							
            ps.setString(4,c.getCause());
            ps.setInt(5,c.getHumantalent_id());

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
    public boolean Update(Assistance c) {
        
        try {
            ps = con.getCon().prepareStatement(Update);

            
            ps.setString(1,c.getFecha());
            ps.setString(2,c.getStarttime());
            ps.setString(3,c.getEndtime());							
            ps.setString(4,c.getCause());
            ps.setInt(5,c.getHumantalent_id());
            ps.setInt(6, c.getId());

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

    public boolean UpdateEndWord(Object endtime, Object hoy, Object HumanId){
        try {
            ps = con.getCon().prepareStatement(UpdateEndWord);

            ps.setString(1, endtime.toString() );
            ps.setString(2, hoy.toString());
            ps.setInt(3, HumanId.hashCode());

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
    
    public boolean UpdateEndWordCause(Object endtime, Object cause, Object hoy, Object HumanId){
        try {
            ps = con.getCon().prepareStatement(UpdateEndPause);

            ps.setString(1, endtime.toString());
            ps.setString(2, cause.toString());
            ps.setString(3, hoy.toString());
            ps.setInt(4, HumanId.hashCode());

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
        
         try {
            ps = con.getCon().prepareStatement(DeleteByKey);

            ps.setInt(1, key.hashCode());

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
    
    public boolean DeleteByDayHumanId(Object fecha, Object HumanId){
    
    
     try {
            ps = con.getCon().prepareStatement(DeleteByFeHumanId);

            ps.setString(1, fecha.toString());
            ps.setInt(2, HumanId.hashCode());

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
    
}
