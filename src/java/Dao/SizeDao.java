package Dao;

import Config.Conexion;
import Entity.Size;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SizeDao implements Icrud<Size> {

    private static final String DeleteByKey = "Delete from size where id = ?;";
    private static final String SelectAll = "SELECT id, simbol FROM  size ORDER BY name asc;";
    private static final String Insert = "INSERT INTO size(name, simbol) VALUES(?,?);";
    private static final String Update = "UPDATE size SET name=?, simbol=? WHERE id=?;";
    private static final String SelectByAtrib = "SELECT * FROM size WHERE name = ?;";
    private static final String SelectBykey = "SELECT * FROM size WHERE id = ?;";

    private static final Conexion con = Conexion.knowConexion();

    PreparedStatement ps = null;
    ResultSet rs = null;

    Size size = null;

    @Override
    public Size ListByAtrib(Object key) {//prueba finalizada

        try {

            ps = con.getCon().prepareStatement(SelectBykey);

            ps.setInt(1, key.hashCode());

            rs = ps.executeQuery();

            while (rs.next()) {
                size = new Size(rs.getInt(1), rs.getString(2), rs.getString(3));
            }

            return size;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.CloseConexion();
        }

        return null;

    }

    @Override
    public List<Size> ListByKey(Object key) {//prueba finalizada

        ArrayList<Size> lista = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectByAtrib);
            ps.setString(1, key.toString());

            rs = ps.executeQuery();

            while (rs.next()) {

                size = new Size();

                size.setId(rs.getInt("id"));
                size.setName(rs.getString("name"));
                size.setSimbolo(rs.getString("simbol"));

                lista.add(size);
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
    public boolean Insert(Size c) {

        try {
            ps = con.getCon().prepareStatement(Insert);

            ps.setString(1, c.getName());
            ps.setString(2, c.getSimbolo());

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
    public boolean Update(Size c) {

        try {
            ps = con.getCon().prepareStatement(Update);
            ps.setString(1, c.getName());
            ps.setString(2, c.getSimbolo());
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

    public List<Size> ListSize() {
        
        ArrayList<Size> lista = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectAll);
            rs = ps.executeQuery();

            while (rs.next()) {                
                size = new Size(rs.getInt(1),rs.getString(2));   
                lista.add(size);
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
    public List<Size> ListByPag(Object key, int start, int end) {

        ArrayList<Size> lista = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectAll);
            rs = ps.executeQuery();

            while (rs.next()) {

                size = new Size();

                size.setId(rs.getInt("id"));
                size.setSimbolo(rs.getString("simbol"));

                lista.add(size);
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
    public Size ListByName(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
