
package Entity;

public class Color{
    private int id=0;
    private String name="";

    public Color() {
    }

    public Color( String name) {        
        this.name = name;
    } 
    
    public Color(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
