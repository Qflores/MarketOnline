
package Entity;


public class TypeCustomer {
    
    private int id;
    private String name;
    private String state;

    public TypeCustomer() {
    }

    public TypeCustomer(String name) {
        this.name = name;
    }

    
    
    public TypeCustomer(int id, String name, String state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
    
    
    
}
