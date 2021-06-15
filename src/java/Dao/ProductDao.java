package Dao;

import Config.Conexion;
import Entity.Color;
import Entity.Picture;
import Entity.Product;
import Entity.ProductPrice;
import Entity.Size;
import Entity.StockProduct;
import Entity.TypeProduct;
import Interface.Icrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements Icrud<Product> {

    private static final String DeleteByKey = "UPDATE products SET state=?  WHERE sku=?;";
    private static final String SelectByPage = "SELECT * FROM products WHERE sku LIKE ? OR  name LIKE ? ORDER BY name ASC limit  ?,?;";
    private static final String Insert = "INSERT INTO products(sku, name, description, quantityperpackage, ranking, observation, state, stockmin, stockmax, peso, color_id, size_id, typeproduct_id) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String Update = "UPDATE products SET name=?, description=?, quantityperpackage=?, ranking=?, observation=?, state=?, stockmin=?, stockmax=?, peso=?, color_id=?, size_id=?, typeproduct_id=? WHERE sku=?;";
    private static final String SelectByAtrib = "SELECT * FROM products WHERE state = ?  ORDER BY name ASC;";
    private static final String ListByType = "SELECT * FROM products WHERE  typeproduct_id =? ORDER BY name ASC;";
    private static final String deletebySku = "DELETE FROM products WHERE sku= ?;";
    private static final String SelectProcedurep = "call sp_viewproduct(?,?,?,?);";
    private static final String viewDetailP = "call sp_viewDetailProduct(?);";
    private static final String LoadDetailProd = "call sp_loadprodupdate(?);";
    private static final String UpdatePrice = "UPDATE product_price SET price=? WHERE products_sku=?;";
    private static final String SelectBySkup = "SELECT p.sku, p.name, p.peso,s.simbol, pp.price, pp.pricepromo FROM product_price as pp inner JOIN products as p on pp.products_sku = p.sku inner join size as s on p.size_id = s.id where pp.products_sku =?;";

    private static final Conexion con = Conexion.knowConexion();

    PreparedStatement ps = null;
    ResultSet rs = null;

    Product producto = null;

    public List<Product> ListByType(Object key) {

        ArrayList<Product> ListaPT = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(ListByType);

            ps.setInt(1, key.hashCode());

            rs = ps.executeQuery();

            while (rs.next()) {

                producto = new Product();

                producto.setSku(rs.getString("sku"));
                producto.setName(rs.getString("name"));
                producto.setDescription(rs.getString("description"));
                producto.setQuantityperpackage(rs.getDouble("quantityperpackage"));
                producto.setRanking(rs.getInt("ranking"));
                producto.setObservation(rs.getString("observation"));
                producto.setState(rs.getString("state"));
                producto.setStockmin(rs.getDouble("stockmin"));
                producto.setStockmax(rs.getDouble("stockmax"));
                producto.setPeso(rs.getDouble("peso"));
                producto.setColor_id(rs.getInt("color_id"));
                producto.setSize_id(rs.getInt("size_id"));
                producto.setTypeproduct_id(rs.getInt("typeproduct_id"));

                ListaPT.add(producto);
            }

            return ListaPT;

        } catch (Exception e) {

            e.printStackTrace(System.out);
        }

        return null;
    }

    @Override

    public List<Product> ListByPag(Object key, int start, int end) {

        ArrayList<Product> Lista = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectByPage);

            ps.setString(1, "%" + key.toString() + "%");
            ps.setString(2, "%" + key.toString() + "%");
            ps.setInt(3, start);
            ps.setInt(4, end);

            rs = ps.executeQuery();

            while (rs.next()) {

                producto = new Product();

                producto.setSku(rs.getString("sku"));
                producto.setName(rs.getString("name"));
                producto.setDescription(rs.getString("description"));
                producto.setQuantityperpackage(rs.getDouble("quantityperpackage"));
                producto.setRanking(rs.getInt("ranking"));
                producto.setObservation(rs.getString("observation"));
                producto.setState(rs.getString("state"));
                producto.setStockmin(rs.getDouble("stockmin"));
                producto.setStockmax(rs.getDouble("stockmax"));
                producto.setPeso(rs.getDouble("peso"));
                producto.setColor_id(rs.getInt("color_id"));
                producto.setSize_id(rs.getInt("size_id"));
                producto.setTypeproduct_id(rs.getInt("typeproduct_id"));

                Lista.add(producto);
            }
            return Lista;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.CloseConexion();
        }

        return null;

    }//end method

    @Override
    public List<Product> ListByKey(Object key) {

        ArrayList<Product> Listap = new ArrayList<>();

        try {

            ps = con.getCon().prepareStatement(SelectByAtrib);

            ps.setString(1, key.toString());

            rs = ps.executeQuery();

            while (rs.next()) {

                producto = new Product();

                producto.setSku(rs.getString("sku"));
                producto.setName(rs.getString("name"));
                producto.setDescription(rs.getString("description"));
                producto.setQuantityperpackage(rs.getDouble("quantityperpackage"));
                producto.setRanking(rs.getInt("ranking"));
                producto.setObservation(rs.getString("observation"));
                producto.setState(rs.getString("state"));
                producto.setStockmin(rs.getDouble("stockmin"));
                producto.setStockmax(rs.getDouble("stockmax"));
                producto.setPeso(rs.getDouble("peso"));
                producto.setColor_id(rs.getInt("color_id"));
                producto.setSize_id(rs.getInt("size_id"));
                producto.setTypeproduct_id(rs.getInt("typeproduct_id"));

                Listap.add(producto);
            }
            return Listap;

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.CloseConexion();
        }

        return null;
    }

    @Override
    public boolean Insert(Product c) {

        try {

            ps = con.getCon().prepareStatement(Insert);

            ps.setString(1, c.getSku());
            ps.setString(2, c.getName());
            ps.setString(3, c.getDescription());
            ps.setDouble(4, c.getQuantityperpackage());
            ps.setInt(5, c.getRanking());
            ps.setString(6, c.getObservation());
            ps.setString(7, c.getState());
            ps.setDouble(8, c.getStockmin());
            ps.setDouble(9, c.getStockmax());
            ps.setDouble(10, c.getPeso());
            ps.setInt(11, c.getColor_id());
            ps.setInt(12, c.getSize_id());
            ps.setInt(13, c.getTypeproduct_id());

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            //e.printStackTrace(System.out);
            return false;
        } finally {
            Conexion.CloseConexion();
        }
        return false;
    }

    @Override
    public boolean Update(Product c) {

        try {

            ps = con.getCon().prepareStatement(Update);

            ps.setString(1, c.getName());
            ps.setString(2, c.getDescription());
            ps.setDouble(3, c.getQuantityperpackage());
            ps.setInt(4, c.getRanking());
            ps.setString(5, c.getObservation());
            ps.setString(6, c.getState());
            ps.setDouble(7, c.getStockmin());
            ps.setDouble(8, c.getStockmax());
            ps.setDouble(9, c.getPeso());
            ps.setInt(10, c.getColor_id());
            ps.setInt(11, c.getSize_id());
            ps.setInt(12, c.getTypeproduct_id());
            ps.setString(13, c.getSku());

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

    //funcion para eliminar pero solo actualizamos el estado
    public boolean DeleteByKeyState(String state, String sku) {

        try {

            ps = con.getCon().prepareStatement(DeleteByKey);
            ps.setString(1, state);
            ps.setString(2, sku);

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            //e.printStackTrace(System.out);

            return false;
        }

        return false;
    }

    @Override
    public boolean DeleteByKey(Object key) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
        try {
            ps = con.getCon().prepareStatement(deletebySku);

            ps.setString(1, key.toString());

            if (ps.executeUpdate() > 0) {

                return true;
            }
        } catch (Exception e) {

            return false;
        }
        return false;
    }

    public List<Product> listAll(Object skuname, int startl, int endl) {//para consulta con buscador con trigger

        ArrayList<Product> listpro = new ArrayList<>();
        try {
            ps = con.getCon().prepareCall(SelectProcedurep);
            ps.setString(1, "%" + skuname.toString() + "%");
            ps.setString(2, "%" + skuname.toString() + "%");
            ps.setInt(3, startl);
            ps.setInt(4, endl);

            rs = ps.executeQuery();
            while (rs.next()) {

                Product prl = new Product();

                prl.setSku(rs.getString("codigo"));
                prl.setName(rs.getString("producto"));
                prl.setDescription(rs.getString("description"));
                prl.setPeso(rs.getDouble("peso"));
                prl.setState(rs.getString("state"));
                prl.setColor(new Color(rs.getString("color")));
                prl.setSize(new Size(rs.getString("simbolo")));
                prl.setCategory(new TypeProduct(rs.getString("categoria")));
                prl.setStock(new StockProduct(rs.getDouble("catstock")));
                prl.setPrice(new ProductPrice(rs.getDouble("price"), rs.getDouble("pricepromo"), rs.getDouble("cantidadpromo"), rs.getString("fexpiration")));

                listpro.add(prl);
            }
            return listpro;

        } catch (Exception e) {
            return null;
        } finally {
            Conexion.CloseConexion();
        }
    }

    @Override
    public Product ListByAtrib(Object key) {

        try {

            ps = con.getCon().prepareCall(viewDetailP);
            ps.setString(1, key.toString());

            rs = ps.executeQuery();

            while (rs.next()) {

                producto = new Product();

                producto.setSku(rs.getString("codigo"));
                producto.setName(rs.getString("producto"));
                producto.setDescription(rs.getString("description"));
                producto.setPeso(rs.getDouble("peso"));
                producto.setState(rs.getString("state"));
                producto.setColor(new Color(rs.getString("color")));
                producto.setSize(new Size(rs.getString("simbolo")));
                producto.setCategory(new TypeProduct(rs.getString("categoria")));
                producto.setPicture(new Picture(rs.getString("rutaimagen"), rs.getString("nameimagen")));
                producto.setStock(new StockProduct(rs.getDouble("catstock")));
                producto.setPrice(new ProductPrice(rs.getDouble("price"), rs.getDouble("pricepromo"), rs.getDouble("cantidadpromo"), rs.getString("fexpiration")));

            }

            return producto;

        } catch (Exception e) {

            //e.printStackTrace(System.out);
           return null;

        } finally {
            Conexion.CloseConexion();
        }

        //return null;
    }
    
    //Mostrar datos del producto en modal Actualizar
    public Product ViewProdUpdate(Object p) {
        
        try {
            ps = con.getCon().prepareCall(LoadDetailProd);
            ps.setString(1, p.toString());

            rs = ps.executeQuery();

            while (rs.next()) {

                producto = new Product();

                producto.setSku(rs.getString("codp"));
                producto.setName(rs.getString("namep"));
                producto.setDescription(rs.getString("dscp"));
                producto.setQuantityperpackage(rs.getInt("qxp"));
                producto.setObservation(rs.getString("obsp"));
                producto.setStockmin(rs.getInt("stockmin"));
                producto.setStockmax(rs.getInt("stockmax"));
                producto.setState(rs.getString("state"));
                producto.setPeso(rs.getDouble("peso"));    
                producto.setColor_id(rs.getInt("cidp"));
                producto.setSize_id(rs.getInt("sizp"));
                producto.setTypeproduct_id(rs.getInt("catp"));
                producto.setPrice(new ProductPrice(rs.getDouble("price"), rs.getDouble("pricepromo"), rs.getDouble("catprom"), rs.getString("fexp")));                               
                producto.setColor(new Color(rs.getString("color")));
                producto.setCategory(new TypeProduct(rs.getString("categoria")));
                producto.setSize(new Size(rs.getString("simbolo")));               
                
            }

            return producto;

        } catch (Exception e) {

            e.printStackTrace(System.out);

        } finally {
            Conexion.CloseConexion();
        }

        return null;
    }

    @Override
    public Product ListByName(Object key) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // actualizando precio del  producto mediante ajax
    public boolean UpdateProductPrice(Product p) {

        try {
            ps = con.getCon().prepareStatement(UpdatePrice);
            ps.setDouble(1, p.getPrice().getPrice());
            ps.setString(2, p.getPrice().getProducts_sku());

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {

            return false;
        }
        return false;
    }

    // Validar producto si esta registrado
    public Product SearchBySku(Object p) {

        try {
            ps = con.getCon().prepareStatement(SelectBySkup);
            ps.setString(1, p.toString());

            rs = ps.executeQuery();

            if (rs.next()) {
                producto = new Product();
                
                producto.setSku(rs.getString(1));//sku
                producto.setName(rs.getString(2));//name
                producto.setPeso(rs.getDouble(3));//peso
                producto.setSize(new Size(rs.getString(4)));// simbolo
                producto.setPrice(new ProductPrice(rs.getDouble(5),rs.getDouble(6))); // precio y precio promocion
            }

            return producto;

        } catch (Exception e) {

            return null;
        }

    }    
   
}
