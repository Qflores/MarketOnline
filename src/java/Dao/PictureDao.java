/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import Entity.Picture;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PictureDao implements Icrud<Picture> {

    private static final String DeleteByKey = "DELETE FROM picture WHERE id=?;;";
    private static final String SelectAll = "SELECT * FROM picture;";
    private static final String Insert = "INSERT INTO picture(name, path, alt, products_sku) VALUES (?,?,?,?);";
    private static final String Update = "UPDATE picture SET name=? path=?, alt=?, products_sku=? WHERE id = ?;;";
    private static final String SelectByAtrib = "SELECT * FROM picture WHERE products_sku =?;";
    private static final String SelectBykey = "SELECT * FROM picture WHERE id = ?;";

    private static final Conexion con = Conexion.knowConexion();

    PreparedStatement ps = null;

    ResultSet rs = null;

    Picture picture = null;

    @Override
    public Picture ListByAtrib(Object key) {

        try {

            ps = con.getCon().prepareStatement(SelectBykey);
            
            ps.setInt(1, key.hashCode());
            
            rs = ps.executeQuery();

            while (rs.next()) {
                
                picture = new Picture(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            
            return picture;

        } catch (Exception e) {
            
            e.printStackTrace(System.out);
            
        } finally {
            
            Conexion.CloseConexion();
        }
        
        return null;

    }

    @Override
    public List<Picture> ListByPag(Object key, int start, int end) {
        
        ArrayList<Picture> lista = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectAll);
            rs = ps.executeQuery();

            while (rs.next()) {

                picture = new Picture();

                picture.setId(rs.getInt("id"));
                picture.setName(rs.getString("name"));
                picture.setPath(rs.getString("path"));
                picture.setAlt(rs.getString("alt"));
                picture.setProduct_sku(rs.getString("products_sku"));
                        

                lista.add(picture);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.CloseConexion();
        }

        return null;
    }

    @Override
    public List<Picture> ListByKey(Object key) {

        ArrayList<Picture> lista = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectByAtrib);
            ps.setString(1, key.toString());
            
            rs = ps.executeQuery();

            while (rs.next()) {

                picture = new Picture();

                picture.setId(rs.getInt("id"));
                picture.setName(rs.getString("name"));
                picture.setPath(rs.getString("path"));
                picture.setAlt(rs.getString("alt"));
                picture.setProduct_sku(rs.getString("products_sku"));
                        

                lista.add(picture);
            }
            return lista;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.CloseConexion();
        }

        return null;
    }

    @Override
    public boolean Insert(Picture c) {
        
        try {
            
            ps = con.getCon().prepareStatement(Insert);

            ps.setString(1, c.getName());
            ps.setString(2, c.getPath());
            ps.setString(3, c.getAlt());
            ps.setString(4, c.getProduct_sku());
            
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
    public boolean Update(Picture c) {
        
        try {
            
            ps = con.getCon().prepareStatement(Update);

            ps.setString(1, c.getName());
            ps.setString(2, c.getPath());
            ps.setString(3, c.getAlt());
            ps.setString(4, c.getProduct_sku());
            ps.setInt(5, c.getId());

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

    @Override
    public Picture ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
