/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.Contact;
import Entity.Customer;
import Entity.Person;
import Entity.TypeCustomer;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements Icrud<Customer>{
   
    
    private static final String Insert = "INSERT INTO customer(typecustomer_id, person_Id, linecredito, lineacumulada) VALUES (?,?,?,?);";
    private static final String Update = "UPDATE customer SET linecredito=?,  lineacumulada=? WHERE person_Id=?;";
    
    private static final String SelectBykey ="call sp_listcustomer(?,?);";
    private static final String UpdateLine ="UPDATE customer SET lineacumulada =? where Person_id = ?;";
    private static final String searchCustomeByIdPerson ="SELECT  id, person_Id FROM customer WHERE person_Id= ?;";    
    private static final String SelectByDoc = "call sp_viewcustomer(?);";
    private static final String validateCustomer = "SELECT * FROM customer AS c INNER JOIN person AS p ON c.person_id = p.Id WHERE p.numdoc =?";
    private static final String searchCustomer = "SELECT p.name, p.id, p.firstname, p.numdoc, c.linecredito, c.lineacumulada, co.adress, co.email, co.numphone, co.numhouse FROM person AS p LEFT JOIN  customer AS c ON c.person_id = p.Id LEFT JOIN contact AS co ON co.person_id = p.id WHERE p.id =?";
    private static final String SelectCustById = "SELECT * FROM customer AS c INNER JOIN person AS p ON c.person_id = p.Id WHERE c.id =?;";
    private static final String ListarClientes="SELECT p.id , p.name, firstname, p.numdoc, c.linecredito, c.lineacumulada, t.adress, t.email, t.numphone FROM customer AS c INNER JOIN person AS p ON c.person_id = p.Id INNER JOIN contact t ON t.person_id = p.id WHERE p.numdoc LIKE ?;";
        
    private static final String SelectKeyPress = "";
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;   
    
    Customer customer = null;

    
    public boolean validateC(String dni){
        try {
            
            ps = con.getCon().prepareStatement(validateCustomer);           
            ps.setString(1, dni); 
            
            while (ps.execute()) {
                return true;
            }            
        } catch (Exception e) {            
            return false;
        }
        
        return false;
    }
    
    //mostrar para editar
    public Customer searchByID(Object key){
       try {
             
            ps = con.getCon().prepareStatement(searchCustomer);            
            ps.setInt(1, key.hashCode());
            
            rs =  ps.executeQuery();
            
            while (rs.next()) {                
         
                customer = new Customer();
                customer.setLinecredito(rs.getDouble("linecredito"));
                customer.setLineacumulada(rs.getDouble("lineacumulada"));                
                
                customer.setAddress(new Contact(rs.getString("adress"),rs.getString("email"), rs.getString("numphone"),rs.getString("numhouse")));
                
                customer.setPersona(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("firstname"), rs.getString("numdoc")));
                
            }
            
            return customer;
            
        } catch (Exception e) {
            return null;
        }finally{
            Conexion.CloseConexion();
            
        }
   
   } 
    
    
   public Customer SelectByDoc(Object key){
       try {
             
            ps = con.getCon().prepareStatement(SelectByDoc);            
            ps.setString(1, key.toString());
            
            rs =  ps.executeQuery();
            
            while (rs.next()) {                
                
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setPerson_id(rs.getInt("person_id"));
                customer.setLinecredito(rs.getDouble("linecredito"));
                customer.setLineacumulada(rs.getDouble("lineacumulada"));
                
                customer.setAddress(new Contact(rs.getString("direccion")));
                
                customer.setPersona(new Person(rs.getInt("person_id"), rs.getString("nombres"), rs.getString("numdoc")));
                
            }
            
            return customer;
            
        } catch (Exception e) {
            return null;
        }finally{
            Conexion.CloseConexion();
            
        }
   
   } 
    
   public boolean CustomerByID(Object key){ 
       
       try {
             
            ps = con.getCon().prepareStatement(SelectCustById);            
            
            ps.setInt(1, key.hashCode());
            
            while (ps.execute()) {
                   return true;
               }            
           } catch (Exception e) {            
               return false;
           }
        
            return false;               
       
   }
    
    @Override
    public Customer ListByAtrib(Object key) {     
        try {
             
            ps = con.getCon().prepareStatement(searchCustomeByIdPerson);            
            ps.setInt(1, key.hashCode()); 
            
            rs =  ps.executeQuery();
            
            while (rs.next()) {                
                
                customer = new Customer(rs.getInt(1), rs.getInt(2));
            }
            
            return customer;
            
        } catch (Exception e) {
            return null;
        }finally{
            Conexion.CloseConexion();
            
        }
    }

    @Override
    public List<Customer> ListByPag(Object key, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); 
        
    }

    @Override
    public List<Customer> ListByKey(Object key) {
        
        ArrayList<Customer> listcus = new ArrayList<>();
        
        try {
            ps = con.getCon().prepareCall(ListarClientes);
            ps.setString(1, "%"+key.toString()+"%");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                customer = new Customer();
                customer.setLinecredito(rs.getDouble("linecredito"));
                customer.setLineacumulada(rs.getDouble("lineacumulada"));               
                
                customer.setPersona(new Person(rs.getInt("id"), rs.getString("name"), rs.getString("firstname"), rs.getString("numdoc")));
                customer.setAddress(new Contact(rs.getString("adress"), rs.getString("email"), rs.getString("numphone")));

                listcus.add(customer);
            }
            
            return listcus;
            
        } catch (Exception e) {
            
            return null;
        }finally{
            Conexion.CloseConexion();
        }       
        
        
    }

    @Override
    public Customer ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(Customer c) {
        
        
        try {
            
            ps = con.getCon().prepareStatement(Insert);
            
            ps.setInt(1, c.getTypecustomer_id());
            ps.setInt(2, c.getPerson_id());
            ps.setDouble(3, c.getLinecredito());
            ps.setDouble(4, c.getLineacumulada());
            
            if (ps.executeUpdate() > 0) {
                
                return true;
            }
            
        } catch (Exception e) {
            
            return false;
        }
        
        return false;
    }

    @Override
    public boolean Update(Customer c) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         try {
            
            ps = con.getCon().prepareStatement(Update);
            
            ps.setDouble(1, c.getLinecredito());
            ps.setDouble(2, c.getLineacumulada());
            ps.setInt(3, c.getPerson_id());
            
            if (ps.executeUpdate() > 0) {
                
                return true;
            }
            
        } catch (Exception e) {
            
            return false;
        }
        
        return false;
    }
    
    public boolean UpdateLinea(Customer c){
        
        try {
            
            ps = con.getCon().prepareStatement(UpdateLine);
            
            ps.setDouble(1, c.getLineacumulada());
            ps.setInt(2, c.getId());
            
            if (ps.executeUpdate() > 0) {
                
                return true;
            }
            
        } catch (Exception e) {
            
            return false;
        }
        
        return false;
    }
    
    
    
    @Override
    public boolean DeleteByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
    }
    
    
            
    public List<Customer> ListCliForOption(Object key) {
        
        ArrayList<Customer> listcus = new ArrayList<>();
        
        try {
            ps = con.getCon().prepareCall(SelectBykey);
            ps.setString(1, "%"+key.toString()+"%");
            ps.setString(2, "%"+key.toString()+"%");
            
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setPerson_id(rs.getInt("person_Id"));
                customer.setLinecredito(rs.getDouble("linecredito"));
                customer.setLineacumulada(rs.getDouble("lineacumulada"));
                customer.setTypecustomer(new TypeCustomer(rs.getString("tipocli")));
                customer.setPersona(new Person(rs.getString("nombre"), rs.getString("firstname"), rs.getString("lastname"), rs.getString("sexo"), rs.getString("numdoc")));
                customer.setAddress(new Contact(rs.getString("direccion"), rs.getString("email"), rs.getString("phone")));

                listcus.add(customer);
            }
            
            return listcus;
            
        } catch (Exception e) {
            
            return null;
        }finally{
            Conexion.CloseConexion();
        }       
        
    }
    
}
