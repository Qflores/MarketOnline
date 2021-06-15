
package Utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Validate {
    private static int entero;
    private static double decimal;
    private static String cadena;
    private static long doc;

    public static boolean esEntero(String cadena) {
        try {
            entero = Integer.parseInt(cadena);
            return true;
        } catch (Exception a) {
            return false;
        }
    }

    public static boolean esLongPositivo(String cadena) {//validad documento
        try {
            doc = Long.parseLong(cadena);
            if (doc <= 0) {
                return false;
            }
            return true;
        } catch (Exception a) {
            return false;
        }
    }
    
    public static boolean esEnteroPositivo(String cadena) {
        try {
            entero = Integer.parseInt(cadena);
            if (entero <= 0) {
                return false;
            }
            return true;
        } catch (Exception a) {
            return false;
        }
    }

    public static boolean isEmpty(String mensaje) {
        return mensaje.trim().equals("");
    }

    public static boolean esDecimal(String cadena) {
        try {
            decimal = Double.parseDouble(cadena);
            return true;
        } catch (Exception a) {
            return false;
        }
    }

    public static boolean esDecimalPositivo(String cadena) {
        try {
            decimal = Double.parseDouble(cadena);
            if (decimal <= 0) {
                return false;
            }
            return true;
        } catch (Exception a) {
            return false;
        }
    }

    public static boolean esTelefono(String cadena) {
        Pattern pat = Pattern.compile("[267][0-9]{3}-[0-9]{7}");
        Matcher mat = pat.matcher(cadena);
        return mat.matches();
    }
    
    public static boolean Telefono(String cadena) {
        Pattern pat = Pattern.compile("^[0-9]{5,20}$");
        Matcher mat = pat.matcher(cadena);
        return mat.matches();
    }
    
    public static boolean esCodigoEditorial(String cadena) {
        Pattern pat = Pattern.compile("EDI[0-9]{20}");
        Matcher mat = pat.matcher(cadena);
        return mat.matches();
    }
    
    public static boolean esCodigoAutor(String cadena) {
        Pattern pat = Pattern.compile("AUT[0-9]{3}");
        Matcher mat = pat.matcher(cadena);
        return mat.matches();
    }
    
    public static boolean esCodigoLibro(String cadena) {
        Pattern pat = Pattern.compile("LIB[0-9]{6}");
        Matcher mat = pat.matcher(cadena);
        return mat.matches();
    }
    
    public static boolean esCadena(String cadena){
        Pattern pat = Pattern.compile("^([a-zA-ZáéúíóÁÉÚÍÓÑñ]+[ ]?){1,7}$");
        Matcher mat = pat.matcher(cadena);
        
        return mat.matches();
    }
    
    public static boolean Documento(String cadena){
        Pattern pat = Pattern.compile("^[0-9]{5,20}$");
        Matcher mat = pat.matcher(cadena);
        
        return mat.matches();
    }
    
    public static Double RedondearDec(Double subtotal ){
        
        BigDecimal bd = new BigDecimal(subtotal);
        bd = bd.setScale(3, RoundingMode.HALF_UP);
        
        return bd.doubleValue();
    }
}
