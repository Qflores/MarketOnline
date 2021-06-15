/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

public class TypePay {
    
    private String name;
    private int tipo;
    
    public TypePay(int tipo){
       switch(tipo){
            case 1:
                this.tipo = 1;
                this.name = "efectivo";            
                break;
            
            case 2:
                this.tipo = 2;
                this.name = "credito";
                break;
                
            case 3:
                this.tipo = 3;
                this.name="card";
                break;
                
            default:
                this.tipo = 0;
                this.name = "not found tipo";
        }       
    }
        
    public String getName() {
        return name;
    }
    
    public int getTipo() {
        return tipo;
    }

    
    
}
