/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;
import Dao.NumfactDao;

public class GenerateNumFact {

    private int dato;
    private int cont = 1;
    private String num = "";
    
    private String tipo = "";
    
    private String serie= "";

    public String lastID(String tipo) {
        
        this.tipo = tipo;
        this.TipeDoc();
        NumfactDao FactDao = new NumfactDao();
        int idFac = FactDao.Numfact();

        if (idFac != 0) {
            this.generar(idFac);
            return this.serie+this.num;
        } else {
            return null;
        }
    }

    private void generar(int dato) {
        this.dato = dato;
        if ((this.dato >= 10000000) || (this.dato < 100000000)) {
            int can = cont + this.dato;
            num = "0" + can;
        }
        if ((this.dato >= 1000000) || (this.dato < 10000000)) {
            int can = cont + this.dato;
            num = "00" + can;
        }
        if ((this.dato >= 100000) || (this.dato < 1000000)) {
            int can = cont + this.dato;
            num = "000" + can;
        }
        if ((this.dato >= 10000) || (this.dato < 100000)) {
            int can = cont + this.dato;
            num = "0000" + can;
        }
        if ((this.dato >= 1000) || (this.dato < 10000)) {
            int can = cont + this.dato;
            num = "00000" + can;
        }
        if ((this.dato >= 100) || (this.dato < 1000)) {
            int can = cont + this.dato;
            num = "000000" + can;
        }
        if ((this.dato >= 9) || (this.dato < 100)) {
            int can = cont + this.dato;
            num = "0000000" + can;
        }
        if (this.dato < 9) {
            int can = cont + this.dato;
            num = "00000000" + can;
        }

    }
    
    private void TipeDoc(){
        this.tipo = tipo;
        
        if (tipo.equals("f")) {
            this.serie = "F001-";
        }else if(tipo.equals("b")){
            
            this.serie = "B001-";
        }else{
            this.serie = "S-001-001-";
        }
        
    }
}
