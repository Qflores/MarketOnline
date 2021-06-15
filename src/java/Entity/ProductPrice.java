
package Entity;

public class ProductPrice {
  
    private int id=0;
    private Double price=0.0;
    private String state="";
    private double pricepromo=0.0;
    private double cantidadpromo=0.0;
    private String fexpiration="";
    private String products_sku="";    
    
    public ProductPrice() {
    }
    
    public ProductPrice(Double price,String products_sku) {
        this.price = price;
        this.products_sku = products_sku;
    }
    public ProductPrice(Double price,Double pPromo) {
        this.price = price;
        this.pricepromo = pPromo;
    }
     public ProductPrice(Double price, double pricepromo, double cantidadpromo, String fexpiration, String products_sku) {        
        this.price = price;
        this.pricepromo = pricepromo;
        this.cantidadpromo = cantidadpromo;
        this.fexpiration = fexpiration;
        this.products_sku = products_sku;
        
    }
    
    
    
    public ProductPrice(Double price, double pricepromo, double cantidadpromo, String fexpiration) {        
        this.price = price;
        this.pricepromo = pricepromo;
        this.cantidadpromo = cantidadpromo;
        this.fexpiration = fexpiration;
        
    }
    
    
    public ProductPrice(int id, Double price, String state, double pricepromo, double cantidadpromo, String fexpiration, String products_sku) {
        this.id = id;
        this.price = price;
        this.state = state;
        this.pricepromo = pricepromo;
        this.cantidadpromo = cantidadpromo;
        this.fexpiration = fexpiration;
        this.products_sku = products_sku;
        
    }

    public double getPricepromo() {
        return pricepromo;
    }

    public void setPricepromo(double pricepromo) {
        this.pricepromo = pricepromo;
    }

    public double getCantidadpromo() {
        return cantidadpromo;
    }

    public void setCantidadpromo(double cantidadpromo) {
        this.cantidadpromo = cantidadpromo;
    }

    public String getFexpiration() {
        return fexpiration;
    }

    public void setFexpiration(String fexpiration) {
        this.fexpiration = fexpiration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProducts_sku() {
        return products_sku;
    }

    public void setProducts_sku(String products_sku) {
        this.products_sku = products_sku;
    }

   
    
}
