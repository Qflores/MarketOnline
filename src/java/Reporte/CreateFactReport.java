
package Reporte;

import Config.Conexion;
import java.io.FileOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import java.util.HashMap;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.view.JasperViewer;


public class CreateFactReport {
    private static final Conexion con = Conexion.knowConexion();
    
    private String codigo = "";
    
    //generar reporte
    public void GenerateFactPDF(String cod){
        
        this.codigo = cod;
        
        try {
            JasperReport factura = null;            
            
            InputStream path = getClass().getResourceAsStream("repfact.jasper");
            HashMap<String, Object> parameters = new HashMap<>();
        
            parameters.put("codfact", this.codigo);
            
            factura = (JasperReport) JRLoader.loadObject(path);
            
            
            JasperPrint jprint = JasperFillManager.fillReport(factura, parameters, con.getCon());
            
            JasperViewer jview = new JasperViewer(jprint, false);
            
            jview.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            
            jview.setVisible(true);
                     
            
        } catch (JRException ex) {
            
            Logger.getLogger(CreateFactReport.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error: algo paso"+ex.getMessage());
            
        }       
        
    }
    
    
    
}
