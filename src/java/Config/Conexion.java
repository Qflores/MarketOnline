package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class Conexion {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/businessmary";//"jdbc:mysql://localhost:3306/businessmary?serverTimezone=UTC&useSSL=false";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "1234";//version drive
    private static Driver driver = null;
    private static Connection con = null;
    public static Conexion instance = null; //Singleton

    private Conexion() throws InstantiationException, IllegalAccessException {
        try {
            Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
            driver = (Driver) jdbcDriverClass.newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }//end methos Conexion
   
    public static synchronized Conexion knowConexion() {
        if (instance == null) {
            try {
                instance = new Conexion();
            } catch (InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }//end method getCon()

    public static void CloseConexion() {

        instance = null;
    }//end method close

}
