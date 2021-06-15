
package Entity;

public class ProveedorProduct {
    
    private int id;
    private int proveedor_id;
    private String products_sku;

    public ProveedorProduct() {
    }

    public ProveedorProduct(int id, int proveedor_id, String products_sku) {
        this.id = id;
        this.proveedor_id = proveedor_id;
        this.products_sku = products_sku;
    }

    public String getProducts_sku() {
        return products_sku;
    }

    public void setProducts_sku(String products_sku) {
        this.products_sku = products_sku;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProveedor_id() {
        return proveedor_id;
    }

    public void setProveedor_id(int proveedor_id) {
        this.proveedor_id = proveedor_id;
    }
    
    
    
    
    
    
}
