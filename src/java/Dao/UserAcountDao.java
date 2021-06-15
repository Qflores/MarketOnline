/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.Person;
import Entity.Role;
import Entity.UserAcount;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class UserAcountDao implements Icrud<UserAcount>{
    
    private static final String DeleteByKey= "DELETE FROM useraccount WHERE person_Id=?;";
    //private static final String SelectByPage = "";
    private static final String Insert = "INSERT INTO useraccount(user, password, state, enrollmentdate, question, answer, person_Id, roleid) VALUES (?,?,?,?,?,?,?,?);";
    private static final String Update = "UPDATE useraccount SET enrollmentdate=?, question=?, answer=? WHERE user=? AND person_Id=?;";
    private static final String SelectByLogin = "call sp_validuspass(?,?);";
    private static final String SelectBykey ="SELECT * FROM useraccount WHERE person_Id=?;";
    private static final String UpdatePass = "UPDATE useraccount SET password = ?  WHERE answer = ? AND person_Id = ?;";
    private static final String UpdateStates ="UPDATE useraccount SET state=?, fexpire=?, roleid=? WHERE user=? and person_Id=?;";
    private static final String PassReset = "call sp_validpassreset(?,?);";
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    UserAcount userac = null;

    @Override
    public UserAcount ListByAtrib(Object key) {
        
        try {
            ps = con.getCon().prepareStatement(SelectBykey); 
            ps.setInt(1,key.hashCode());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                userac = new UserAcount(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10), rs.getInt(11));
            }            
            return userac;
            
        } catch (Exception e) {
            
            e.printStackTrace(System.out);
             
        }finally{        
            Conexion.CloseConexion();
        }     
       
        return null; 
        
    }

    public UserAcount Login(Object us, Object pass){// inicio de sesion de usuario
        
         try {
            ps = con.getCon().prepareStatement(SelectByLogin); 
            ps.setString(1, us.toString());
            ps.setString(2, pass.toString());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                userac = new UserAcount();                
                userac.setState(rs.getString("state"));
                userac.setPerson_Id(rs.getInt("personid"));
                userac.setFexpire(rs.getString("fexpire"));
                userac.setRole(new Role(rs.getString("role") , rs.getString("expirarole")));
                userac.setPerson(new Person(rs.getString("nombre"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("sobrenombre")));
                
                
            }            
            return userac;
            
        } catch (Exception e) {
            
            e.printStackTrace(System.out);
             
        }finally{        
            Conexion.CloseConexion();
        }     
       
        return null; 
    }
    
    
    @Override
    public List<UserAcount> ListByPag(Object key, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserAcount> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserAcount ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(UserAcount c) {
        
        try {
            ps = con.getCon().prepareStatement(Insert);
            
            ps.setString(1, c.getUser());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getState());
            ps.setString(4, c.getEnrollmentdate());
            ps.setString(5, c.getQuestion());
            ps.setString(6, c.getAnswer());
            ps.setInt(7, c.getPerson_Id());
            ps.setInt(8, c.getRoleid());
            
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
    public boolean Update(UserAcount c) {// actualiza 3 campos del usuario 
        
        try {
            ps = con.getCon().prepareStatement(Update);
            
            ps.setString(1, c.getEnrollmentdate());
            ps.setString(2, c.getQuestion());
            ps.setString(3, c.getAnswer());            
            ps.setString(4, c.getUser());
            ps.setInt(5, c.getPerson_Id());
            
            
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
    
    
    public boolean UpdateStatus(UserAcount c){  // el administrador actualiza permisos y estado del usuario
        try {
            ps = con.getCon().prepareStatement(UpdateStates);
            
            ps.setString(1, c.getState());
            ps.setString(2, c.getFexpire());
            ps.setInt(3, c.getRoleid());
            
            ps.setString(4, c.getUser());
            ps.setInt(5, c.getPerson_Id());
            
            
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
    
    
    public boolean UpdatePass(UserAcount c){  // el usuario actualiza la contraseña
        try {
            ps = con.getCon().prepareStatement(UpdatePass);
            
            ps.setString(1, c.getPassword());
            
            ps.setString(2, c.getAnswer());
            ps.setInt(3, c.getPerson_Id());            
            
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
    public boolean DeleteByKey(Object key) {// el administrador elimina el usuario de forma permanente
        
        try {
            
            ps = con.getCon().prepareCall(DeleteByKey); 
            ps.setInt(1, key.hashCode());
            
            if (ps.executeUpdate() > 0) {
                
                return true;
            }
            
        } catch (Exception e) {
            
            //e.printStackTrace(System.out);
            return false;
             
        }finally{        
            Conexion.CloseConexion();
        }     
       
        return false; 
        
    
    }
    
    public UserAcount PassReset(Object us, Object passreset){//recuperar contraseña olvidada x correo
        
        try {
            
            ps = con.getCon().prepareCall(PassReset); 
            ps.setString(1,us.toString());
            ps.setString(2,passreset.toString());
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                userac = new UserAcount(rs.getInt("person_Id"));
            }            
            return userac;
            
        } catch (Exception e) {
            
            e.printStackTrace(System.out);
             
        }finally{        
            Conexion.CloseConexion();
        }     
       
        return null; 
        
    }
    
}
