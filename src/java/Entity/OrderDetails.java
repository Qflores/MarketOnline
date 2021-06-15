
package Entity;

public class OrderDetails {
    
    private int id;
    private double quantity;
    private double discount;
    private double amount;
    private double peso;
    private String simbolo;
    private String color;
    private String productname;
    private String product_sku;
    private int headerid;
    private double subtotal;
    private double totalPagar=0;

    public OrderDetails() {
    }

    
    public OrderDetails(int headerid) {
        this.headerid = headerid;
    }

        
    public OrderDetails(int id, double quantity, double discount, double amount, double peso, String simbolo, String color, String productname, String product_sku, int headerid) {
        this.id = id;
        this.quantity = quantity;
        this.discount = discount;
        this.amount = amount;
        this.peso = peso;
        this.simbolo = simbolo;
        this.color = color;
        this.productname = productname;
        this.product_sku = product_sku;
        this.headerid = headerid;
    }

    public int getHeaderid() {
        return headerid;
    }

    public void setHeaderid(int headerid) {
        this.headerid = headerid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProduct_sku() {
        return product_sku;
    }

    public void setProduct_sku(String product_sku) {
        this.product_sku = product_sku;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar += totalPagar;
    }
    
    
    
    
}
