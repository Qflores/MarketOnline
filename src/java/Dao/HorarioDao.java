
package Dao;

import Config.Conexion;
import Entity.Horario;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class HorarioDao implements Icrud<Horario>{
    
    private static final String DeleteByKey= "";
    private static final String SelectByPage = "";
    private static final String Insert = "INSERT INTO horario(starttime, endtime) VALUES (?,?);";
    private static final String Update = "UPDATE horario SET starttime=?,endtime=? WHERE id=?;";
    private static final String SelectByAtrib = "SELECT * FROM horario;";
    private static final String SelectBykey ="SELECT * FROM horario WHERE id = ?;";
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    Horario horario = null;
    
    @Override
    public Horario ListByAtrib(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {

            ps = con.getCon().prepareStatement(SelectBykey);
            
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();

            while (rs.next()) {
                horario = new Horario(rs.getInt(1), rs.getString(2), rs.getString(3));
                
            }
            
            return horario;

        } catch (Exception e) {
            
            e.printStackTrace(System.out);
            
        } finally {
            
            Conexion.CloseConexion();
        }
        
        return null;
    }

    @Override
    public List<Horario> ListByPag(Object key, int start, int end) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        ArrayList<Horario> listaH = new ArrayList<>();
        try {

            ps = con.getCon().prepareStatement(SelectByAtrib);
            
            rs = ps.executeQuery();

            while (rs.next()) {
                
                horario = new Horario(rs.getInt(1), rs.getString(2), rs.getString(3));
                
                listaH.add(horario);
            }
            
            return listaH;

        } catch (Exception e) {
            
            e.printStackTrace(System.out);
            
        } finally {
            
            Conexion.CloseConexion();
        }
        
        return null;
    }

    @Override
    public List<Horario> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Horario ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(Horario c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
            
            ps = con.getCon().prepareStatement(Insert);

            ps.setString(1, c.getStarttime());
            ps.setString(2, c.getEndtime());

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
    public boolean Update(Horario c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
            
            ps = con.getCon().prepareStatement(Update);

            ps.setString(1, c.getStarttime());
            ps.setString(2, c.getEndtime());
            ps.setInt(3, c.getId());
            
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
