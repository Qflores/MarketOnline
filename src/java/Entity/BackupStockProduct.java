
package Entity;

import java.sql.Date;


public class BackupStockProduct {
    private int id;
    private String NewDatetime;
    private Double OldQuantity;
    private Double NewQuantity;
    private int IdEmployee;
    private String product_sku;

    public BackupStockProduct() {
    }

    public BackupStockProduct(int id, String NewDatetime, Double OldQuantity, Double NewQuantity, int IdEmployee, String product_sku) {
        this.id = id;
        this.NewDatetime = NewDatetime;
        this.OldQuantity = OldQuantity;
        this.NewQuantity = NewQuantity;
        this.IdEmployee = IdEmployee;
        this.product_sku = product_sku;
    }

    public int getIdEmployee() {
        return IdEmployee;
    }

    public void setIdEmployee(int IdEmployee) {
        this.IdEmployee = IdEmployee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNewDatetime() {
        return NewDatetime;
    }

    public void setNewDatetime(String NewDatetime) {
        this.NewDatetime = NewDatetime;
    }

    public Double getOldQuantity() {
        return OldQuantity;
    }

    public void setOldQuantity(Double OldQuantity) {
        this.OldQuantity = OldQuantity;
    }

    public Double getNewQuantity() {
        return NewQuantity;
    }

    public void setNewQuantity(Double NewQuantity) {
        this.NewQuantity = NewQuantity;
    }

    public String getProduct_sku() {
        return product_sku;
    }

    public void setProduct_sku(String product_sku) {
        this.product_sku = product_sku;
    }
    
    
    
}
