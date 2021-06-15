/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.TalentSalary;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author QfloresRA
 */
public class TalentSalaryDao implements Icrud<TalentSalary>{
    
    
    private static final String DeleteByKey= "Delete from Color where id = ?;";
    private static final String SelectByPage = "SELECT * FROM  Color limit ?,?;";
    private static final String Insert = "INSERT INTO Color(name=?) values(?)";
    private static final String Update = "UPDATE Color set name=? WHERE id=?;";
    private static final String SelectByAtrib = "SELECT * FROM Color WHERE id =?;";
    private static final String SelectBykey ="SELECT * FROM Color;";
        
    private static final Conexion con = Conexion.knowConexion();
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    
    TalentSalary talentsalary = null;

    @Override
    public TalentSalary ListByAtrib(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TalentSalary> ListByPag(Object key, int start, int end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TalentSalary> ListByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TalentSalary ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Insert(TalentSalary c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Update(TalentSalary c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteByKey(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
