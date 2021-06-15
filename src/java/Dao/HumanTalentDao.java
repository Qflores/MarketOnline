/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.Contact;
import Entity.HumanTalent;
import Entity.Person;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class HumanTalentDao implements Icrud<HumanTalent>{
    
    
    //private static final String DeleteByKey= "";
    private static final String SelectByPage = "call sp_listHumanT(?,?);";
    private static final String Insert = "INSERT INTO humantalent(starwork, salary, endwork, person_Id, horario_Id) VALUES (?,?,?,?,?);";
    private static final String Update = "UPDATE humantalent SET starwork=?, salary=?,endwork=?, horario_Id=? WHERE person_Id=?;";
    //private static final String SelectByAtrib = "";
    private static final String SelectBykey ="SELECT * FROM humantalent WHERE horario_Id=?;";
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    HumanTalent humantalent = null;

    @Override
    public HumanTalent ListByAtrib(Object key) {
        
        
        try {
            ps = con.getCon().prepareStatement(SelectBykey); 
            ps.setInt(1,key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                humantalent = new HumanTalent(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getInt(5), rs.getInt(6));        
            }
            
            return humantalent;
            
        } catch (Exception e) {
            
            e.printStackTrace(System.out);
             
        }finally{        
            Conexion.CloseConexion();
        }     
       
        return null;
          
    }

    @Override
    public List<HumanTalent> ListByPag(Object key, int start, int end) {
       
        ArrayList<HumanTalent>ListHuman = new ArrayList<>();
        
        try {
            
            ps = con.getCon().prepareCall(SelectByPage);
            
            ps.setString(1, "%"+key.toString()+"%");
            ps.setString(2, "%"+key.toString()+"%");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {  
                
                humantalent = new HumanTalent();
                humantalent.setPerson_Id(rs.getInt(""));
                humantalent.setPersona(new Person(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
                humantalent.setAddress(new Contact(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                
                ListHuman.add(humantalent);
            }
            
            return ListHuman;
            
        } catch (Exception e) {
            
            return null;
        }
        
    }

    @Override
    public List<HumanTalent> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HumanTalent ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(HumanTalent c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            ps = con.getCon().prepareStatement(Insert);
            
            ps.setString(1,c.getStarwork());
            ps.setDouble(2,c.getSalary());
            ps.setString(3,c.getEndwork());
            ps.setInt(4,c.getPerson_Id());
            ps.setInt(5,c.getHorario_Id());
            
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
    public boolean Update(HumanTalent c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
            ps = con.getCon().prepareStatement(Update);
            
            ps.setString(1,c.getStarwork());
            ps.setDouble(2,c.getSalary());
            ps.setString(3,c.getEndwork());            
            ps.setInt(4,c.getHorario_Id());
            ps.setInt(5,c.getPerson_Id());
            
            
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
