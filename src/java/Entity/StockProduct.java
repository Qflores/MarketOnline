
package Entity;


public class StockProduct {
    private int id ;
    private Double quantity ;	
    private String fupdate ;    
    private String products_sku ;
    private int humantalent_id ;

   
    public StockProduct() {
    }
    
    public StockProduct(Double quantity) {
        this.quantity = quantity;
    }

    public StockProduct(Double quantity, String products_sku) {
        this.quantity = quantity;
        this.products_sku = products_sku;
    }
       
    
    public StockProduct(int id, Double quantity, String fupdate,  String products_sku, int humantalent_id) {
        this.id = id;
        this.quantity = quantity;
        this.fupdate = fupdate;
        this.humantalent_id = humantalent_id;
        this.products_sku = products_sku;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getFupdate() {
        return fupdate;
    }

    public void setFupdate(String fupdate) {
        this.fupdate = fupdate;
    }

    public int getHumantalent_id() {
        return humantalent_id;
    }

    public void setHumantalent_id(int humantalent_id) {
        this.humantalent_id = humantalent_id;
    }

    public String getProducts_sku() {
        return products_sku;
    }

    public void setProducts_sku(String products_sku) {
        this.products_sku = products_sku;
    }
    
    
    
}
