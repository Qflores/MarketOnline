
package Entity;

import java.sql.Date;

public class Repayment {
    
    private int id;
    private String returndate;
    private double amount;
    private String HeaderPurchaseOrder;

    public Repayment() {
    }

    public Repayment(int id, String returndate, double amount, String HeaderPurchaseOrder) {
        this.id = id;
        this.returndate = returndate;
        this.amount = amount;
        this.HeaderPurchaseOrder = HeaderPurchaseOrder;
    }

    public String getHeaderPurchaseOrder() {
        return HeaderPurchaseOrder;
    }

    public void setHeaderPurchaseOrder(String HeaderPurchaseOrder) {
        this.HeaderPurchaseOrder = HeaderPurchaseOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
    
    
    
    
}
