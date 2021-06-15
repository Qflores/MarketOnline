
package Entity;

public class Picture {
    
    private int id;
    private String path;
    private String alt;
    private String name;
    private String product_sku;

    public Picture() {
    }
    //RETORN SOLO LA RUTA Y EL NOMBRE
    public Picture(String path, String alt) {        
        this.path = path;
        this.alt = alt;
    }
    
    public Picture(int id, String path, String alt, String name, String product_sku) {
        this.id = id;
        this.path = path;
        this.alt = alt;
        this.name = name;
        this.product_sku = product_sku;
    }

    public String getProduct_sku() {
        return product_sku;
    }

    public void setProduct_sku(String product_sku) {
        this.product_sku = product_sku;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
