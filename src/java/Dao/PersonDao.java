/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
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
public class PersonDao implements Icrud<Person>{
    
    
    private static final String SelectByPage = "SELECT * FROM person ORDER BY name ASC;";
    private static final String Insert = "INSERT INTO person(name, firstname, lastname, firstmidname, enrollmentdate, birthdate, sex, numdoc) VALUES (?,?,?,?,?,?,?,?);";
    private static final String Update = "UPDATE person SET name=?,firstname=?, enrollmentdate=?, sex='N' WHERE Id=?;";
    private static final String SelectByAtrib = "SELECT * FROM person WHERE name LIKE ? OR numdoc LIKE ? ORDER BY name";
    private static final String SelectBykey ="SELECT * FROM person WHERE id = ?;";
    private static final String SelectByDoc ="SELECT * FROM person WHERE numdoc = ?;";
    private static final String SelectID ="SELECT id FROM person WHERE numdoc = ?;";
    private static final String SearchPersonBydoc= "SELECT id, CONCAT(name ,' ',COALESCE(firstname,''),' ', IFNULL(lastname , '')) as nombres FROM person WHERE numdoc = ?;";
    
    
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    Person person = null;
    
    
    public Person SearchBydoc(Object key) {//return id and names
         try {
             
            ps = con.getCon().prepareStatement(SearchPersonBydoc);
            
            ps.setString(1, key.toString());
            
            rs =  ps.executeQuery();
            
            while (rs.next()) {                
                
                person = new Person(rs.getInt(1), rs.getString(2));
            }
            
            return person;
            
        } catch (Exception e) {
            return null;
        }finally{
            Conexion.CloseConexion();
        }
        
    }
    
    
    @Override
    public Person ListByAtrib(Object key) {
        //hrow new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //ArrayList<Person> person = new ArrayList
        try {
            ps = con.getCon().prepareStatement(SelectBykey);
            
            ps.setInt(1, key.hashCode());
            
            rs =  ps.executeQuery();
            
            while (rs.next()) {                
                
                person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
            
            return person;
            
        } catch (Exception e) {
            return null;
        }finally{
            Conexion.CloseConexion();
        }
    }

    @Override
    public List<Person> ListByPag(Object key, int start, int end) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        ArrayList<Person> listperson = new ArrayList<>();
        
        try {
           ps = con.getCon().prepareStatement(SelectByPage);
           
           //ps.setString(1, "%"+key.toString()+"%");           
           //ps.setString(2, "%"+key.toString()+"%");
           
           rs = ps.executeQuery();
           
           while (rs.next()) {                
                
                person = new Person();
                
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setFirstmidname(rs.getString("firstmidname"));
                person.setEnrollmentdate(rs.getString("enrollmentdate"));
                person.setBirthdate(rs.getString("birthdate"));
                person.setSexo(rs.getString("sex"));
                person.setNumdoc(rs.getString("numdoc"));
                
                
                listperson.add(person);
            }
            
            return listperson;
            
        } catch (Exception e) {
            
            return null;
        }finally{
            Conexion.CloseConexion();
        }
 
        //return null;
        
    }

    @Override
    public List<Person> ListByKey(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
       ArrayList<Person> listperson = new ArrayList<>();
        
        try {
           ps = con.getCon().prepareStatement(SelectByAtrib);
           
           ps.setString(1, "%"+key.toString()+"%");           
           ps.setString(2, "%"+key.toString()+"%");
           
           rs = ps.executeQuery();
           
           while (rs.next()) {                
                
                person = new Person();
                
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setFirstname(rs.getString("firstname"));
                person.setLastname(rs.getString("lastname"));
                person.setFirstmidname(rs.getString("firstmidname"));
                person.setEnrollmentdate(rs.getString("enrollmentdate"));
                person.setBirthdate(rs.getString("birthdate"));
                person.setSexo(rs.getString("sex"));
                person.setNumdoc(rs.getString("numdoc"));
                
                
                listperson.add(person);
            }
            
            return listperson;
            
        } catch (Exception e) {
            
            return null;
        }finally{
            Conexion.CloseConexion();
        } 
        
    }

    @Override
    public Person ListByName(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //SelectByDoc
        try {
            ps = con.getCon().prepareStatement(SelectByDoc);
            
            ps.setString(1, key.toString());
            
            rs =  ps.executeQuery();
            
            while (rs.next()) {                
                
                person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
            }
            
            return person;
            
        } catch (Exception e) {
            return null;
        }finally{
            Conexion.CloseConexion();
        }
    }
    
    
    //SelectID
    public Person selectIdPerson(Object key) {
        
        try {
            ps = con.getCon().prepareStatement(SelectByDoc);
            
            ps.setString(1, key.toString());
            
            rs =  ps.executeQuery();
            
            while (rs.next()) {                
                
                person = new Person(rs.getInt(1));
            }
            
            return person;
            
        } catch (Exception e) {
            return null;
        }finally{
            Conexion.CloseConexion();
        }
    }

    @Override
    public boolean Insert(Person c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
            
            ps= con.getCon().prepareStatement(Insert);
           
            ps.setString(1, c.getName());
            ps.setString(2, c.getFirstname());
            ps.setString(3, c.getLastname());
            ps.setString(4, c.getFirstmidname());
            ps.setString(5, c.getEnrollmentdate());
            ps.setString(6, c.getBirthdate());
            ps.setString(7, c.getSexo());
            ps.setString(8, c.getNumdoc());
            
            if (ps.executeUpdate()> 0) {
                
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
    public boolean Update(Person c) {
        
        
        try {
            ps = con.getCon().prepareStatement(Update);
            ps.setString(1, c.getName());
            ps.setString(2, c.getFirstname());
            ps.setString(3, c.getEnrollmentdate());
            ps.setInt(4, c.getId());
            
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
