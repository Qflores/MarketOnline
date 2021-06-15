
package Dao;

import Config.Conexion;
import Entity.Color;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ColorDao implements  Icrud<Color> {
    
    private static final String DeleteByKey= "Delete from color where id = ?;";
    private static final String ListAllColor = "SELECT * FROM color ORDER BY name asc;";
    private static final String SelectByPage = "SELECT * FROM  color order by id asc;";
    private static final String Insert = "INSERT INTO color (name) VALUES(?)";
    private static final String Update = "UPDATE color set name=? WHERE id=?;";
    private static final String SelectByAtrib = "SELECT * FROM color WHERE name like ?;";
    private static final String SelectBykey ="SELECT * FROM color where id =?;";
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    Color color = null;
    
    @Override
    public Color ListByAtrib(Object key) { //retorn una solo color       
        
        try {
            ps = con.getCon().prepareStatement(SelectBykey); 
            ps.setInt(1,key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                color = new Color(rs.getInt(1),rs.getString(2));        
            }
            
            return color;
            
        } catch (Exception e) {
            
            e.printStackTrace(System.out);
             
        }finally{        
            Conexion.CloseConexion();
        }     
       
        return null;
    }
   
    @Override 
    public List<Color> ListByKey(Object key) { // retorna una lista de colores      
        
       ArrayList<Color>listac = new ArrayList<>();
        
        try {
            ps = con.getCon().prepareStatement(SelectByAtrib);
            
            ps.setString(1, "%"+key.toString()+"%");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                color = new Color();
                
                color.setId(rs.getInt("id"));
                color.setName(rs.getString("name"));                
                listac.add(color);
            }
            
            return listac;
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{        
            Conexion.CloseConexion();
        }
        
        return null;
    }
    
    public List<Color> ListColor(){
        
        ArrayList<Color> listaC = new ArrayList<>();
        
        try {
            
            ps = con.getCon().prepareStatement(ListAllColor);            
            rs = ps.executeQuery();
            
             while (rs.next()) {                
               color = new Color(rs.getInt(1),rs.getString(2));
               listaC.add(color);
            }
            
            return listaC;
            
        }catch (Exception e) {
            
            e.printStackTrace(System.out);
            
        }finally{  
            
            Conexion.CloseConexion();
        }
        return null;  
    }
    
    
    @Override
    public List<Color> ListByPag(Object key,int start, int end) { //retorna una lista de colores por nombre
        
        ArrayList<Color> listaC = new ArrayList<>();
        try {
            ps = con.getCon().prepareStatement(SelectByPage);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
               color = new Color();
               
               color.setId(rs.getInt("id"));
               color.setName(rs.getString("name"));
               
               listaC.add(color);
            }
            
            return listaC;
            
        } catch (Exception e) {
            
            e.printStackTrace(System.out);
            
        }finally{  
            
            Conexion.CloseConexion();
        }
        return null;      
    }
 
    @Override
    public boolean Insert(Color c) {       
        
        try {
            ps = con.getCon().prepareStatement(Insert);
            
            ps.setString(1, c.getName());
            
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
    public boolean Update(Color c) {
        
       try {
            ps = con.getCon().prepareStatement(Update);
            ps.setString(1, c.getName());
            ps.setInt(2, c.getId());
            
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
            
            ps.setInt(1, key.hashCode() );
            
            
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
    public Color ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
