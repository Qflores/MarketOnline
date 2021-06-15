
package Dao;
import Config.Conexion;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class NumfactDao implements Icrud{
    
    
    private static final String Insert = "INSERT INTO indexfac (id) VALUES (NULL);";
    private static final String SelectMaxId = "SELECT max(id) FROM indexfac;";
   
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    int numFact = 0;
    
    public int Numfact(){
        try {            
            ps = con.getCon().prepareStatement(SelectMaxId);            
            rs = ps.executeQuery();            
            while (rs.next()) { 
                numFact = rs.getInt(1);
            }            
        } catch (Exception e) {            
            return 0;
        }
        
        return numFact;
    }
    
    @Override
    public Object ListByAtrib(Object key) {
        
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public List ListByPag(Object key, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(Object c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {            
            ps = con.getCon().prepareStatement(Insert);           
            
            if(ps.executeUpdate() > 0){
                
                return true;
            }
                       
        } catch (Exception e) { 
            System.out.println("Error: "+e);
            return false;
        }
        
        return false;
    }

    @Override
    public boolean Update(Object c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
