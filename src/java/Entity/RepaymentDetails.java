
package Entity;

public class RepaymentDetails {
    
    private int id;
    private double quantity;
    private double amount;
    private String description;
    private int repayment_id;

    public RepaymentDetails() {
    }

    public RepaymentDetails(int id, double quantity, double amount, String description, int repayment_id) {
        this.id = id;
        this.quantity = quantity;
        this.amount = amount;
        this.description = description;
        this.repayment_id = repayment_id;
    }

    public int getRepayment_id() {
        return repayment_id;
    }

    public void setRepayment_id(int repayment_id) {
        this.repayment_id = repayment_id;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
  
   
    
}
