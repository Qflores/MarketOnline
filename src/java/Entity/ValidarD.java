package Entity;

public class ValidarD {

    public static boolean getValidar(String validarD) {

        double num = -1;
        
        try {
            num = Double.parseDouble(validarD);

            return true;

        } catch (NumberFormatException nfe) {

            return false;
        }
    }
}
