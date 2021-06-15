
package Entity;

public class Size {
    private int id;
    private String name;
    private String simbolo;

    public Size() {
    }

    public Size(int id) {
        this.id = id;
    }
    public Size(String simbolo) {
        
        this.simbolo = simbolo;
    }
    
    public Size(int id,  String simbolo) {
        this.id = id;
        this.simbolo = simbolo;
    }
 
    public Size(int id, String name, String simbolo) {
        this.id = id;
        this.name = name;
        this.simbolo = simbolo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
    
    
    
}
