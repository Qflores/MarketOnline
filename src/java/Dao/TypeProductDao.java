
package Dao;

import Config.Conexion;
import Entity.TypeProduct;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TypeProductDao implements  Icrud<TypeProduct>{
    
    private static final String DeleteByKey = "DELETE FROM typeproduct WHERE id= ?;";
    private static final String SelectByPage = "SELECT id, name FROM typeproduct ORDER BY name asc;";
    private static final String Insert = "INSERT INTO typeproduct (name) VALUES (?);";
    private static final String Update = "UPDATE typeproduct SET name=? WHERE id = ?;";
    private static final String  SelectByKey = "SELECT * FROM typeproduct WHERE id =?;";
    private static final String  SelectByAtrib = "SELECT * FROM typeproduct WHERE name like ?;";  
    
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    TypeProduct TProduct = null;
    
    @Override
    public TypeProduct ListByAtrib(Object key) { 
        
        try {
            
            ps = con.getCon().prepareStatement(SelectByKey);
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                TProduct = new TypeProduct(rs.getInt(1),rs.getString(2));
            } 
            
            return TProduct;
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{        
            Conexion.CloseConexion();
        }
        return null;
       
    }
    
    @Override
    public List<TypeProduct> ListByKey(Object key) {
         
        ArrayList<TypeProduct>Listat = new ArrayList<>();  
        
        try {
            
            ps = con.getCon().prepareStatement(SelectByAtrib);
            
            ps.setString(1, "%"+key.toString()+"%");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                TProduct = new TypeProduct();
                
                TProduct.setId(rs.getInt("id"));
                TProduct.setName(rs.getString("name"));
                
                Listat.add(TProduct);
            }
            
            return Listat;
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{        
            Conexion.CloseConexion();
        }
        return null;
    }
    
    
    public List<TypeProduct> ListCategoria(){
        
        ArrayList<TypeProduct>ListaT = new ArrayList<>();  
        
        try {
            ps = con.getCon().prepareStatement(SelectByPage);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                TProduct = new TypeProduct(rs.getInt(1),rs.getString(2));
                ListaT.add(TProduct);
            }
            
            return ListaT;
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{        
            Conexion.CloseConexion();
        }
        return null;
    }
    
    
    @Override
    public List<TypeProduct> ListByPag(Object key,int start, int end) {
        
        ArrayList<TypeProduct>ListaT = new ArrayList<>();  
        
        try {
            ps = con.getCon().prepareStatement(SelectByPage);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {  
                
                TProduct = new TypeProduct();
                
                TProduct.setId(rs.getInt("id"));
                TProduct.setName(rs.getString("name"));
                
                ListaT.add(TProduct);
            }
            
            return ListaT;
            
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }finally{        
            Conexion.CloseConexion();
        }
        return null;
    }



    @Override
    public boolean Insert(TypeProduct c) {
        
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
    public boolean Update(TypeProduct c) {
        
         try {
            ps = con.getCon().prepareStatement(Update);
            
            ps.setString(1, c.getName());
            ps.setInt(1, c.getId());
            
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
    public TypeProduct ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
