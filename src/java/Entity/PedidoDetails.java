
package Entity;


public class PedidoDetails {
    private int id;
    private String productsku;
    private String nameproduct;
    private String description;
    private double quantity;
    private double priceunit;
    private double pricesugerido;
    private double descuento;
    private double quantitypack;
    private double subtotal;
    private double importe;
    private double igvped;
    private int pedidoid;
    
    // for query
    private Product product;
    private PedidoHeader pedido;

    public PedidoDetails(int id) {
        this.id = id;
    }
    
    

    public PedidoDetails(int id, String productsku, String nameproduct, String description, double quantity, double priceunit, double pricesugerido, double descuento, double quantitypack, double subtotal, double importe, double igvped, int pedidoid) {
        this.id = id;
        this.productsku = productsku;
        this.nameproduct = nameproduct;
        this.description = description;
        this.quantity = quantity;
        this.priceunit = priceunit;
        this.pricesugerido = pricesugerido;
        this.descuento = descuento;
        this.quantitypack = quantitypack;
        this.subtotal = subtotal;
        this.importe = importe;
        this.igvped = igvped;
        this.pedidoid = pedidoid;
    }

    public PedidoDetails(int id, String productsku, String nameproduct, String description, double quantity, double priceunit, double pricesugerido, double descuento, double quantitypack, double subtotal, double importe, double igvped, int pedidoid, Product product, PedidoHeader pedido) {
        this.id = id;
        this.productsku = productsku;
        this.nameproduct = nameproduct;
        this.description = description;
        this.quantity = quantity;
        this.priceunit = priceunit;
        this.pricesugerido = pricesugerido;
        this.descuento = descuento;
        this.quantitypack = quantitypack;
        this.subtotal = subtotal;
        this.importe = importe;
        this.igvped = igvped;
        this.pedidoid = pedidoid;
        this.product = product;
        this.pedido = pedido;
    }

    public PedidoHeader getPedido() {
        return pedido;
    }

    public void setPedido(PedidoHeader pedido) {
        this.pedido = pedido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductsku() {
        return productsku;
    }

    public void setProductsku(String productsku) {
        this.productsku = productsku;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPriceunit() {
        return priceunit;
    }

    public void setPriceunit(double priceunit) {
        this.priceunit = priceunit;
    }

    public double getPricesugerido() {
        return pricesugerido;
    }

    public void setPricesugerido(double pricesugerido) {
        this.pricesugerido = pricesugerido;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getQuantitypack() {
        return quantitypack;
    }

    public void setQuantitypack(double quantitypack) {
        this.quantitypack = quantitypack;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getIgvped() {
        return igvped;
    }

    public void setIgvped(double igvped) {
        this.igvped = igvped;
    }

    public int getPedidoid() {
        return pedidoid;
    }

    public void setPedidoid(int pedidoid) {
        this.pedidoid = pedidoid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
    
    
}
