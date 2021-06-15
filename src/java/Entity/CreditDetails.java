
package Entity;

public class CreditDetails {
    
    
    private int id;
    private int cuota;
    private double amountpay;
    private double mora;
    private String fechapago;
    private String namecustomer;
    private int credits_id;

    
    public CreditDetails() {
    }
     public CreditDetails(double amountpay) {
         this.amountpay = amountpay;
    }
     
    public CreditDetails(int id, int cuota, double amountpay, double mora, String fechapago, String namecustomer, int credits_id) {
        this.id = id;
        this.cuota = cuota;
        this.amountpay = amountpay;
        this.mora = mora;
        this.fechapago = fechapago;
        this.namecustomer = namecustomer;
        this.credits_id = credits_id;
    }

    public int getCredits_id() {
        return credits_id;
    }

    public void setCredits_id(int credits_id) {
        this.credits_id = credits_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public double getAmountpay() {
        return amountpay;
    }

    public void setAmountpay(double amountpay) {
        this.amountpay = amountpay;
    }

    public double getMora() {
        return mora;
    }

    public void setMora(double mora) {
        this.mora = mora;
    }

    public String getFechapago() {
        return fechapago;
    }

    public void setFechapago(String fechapago) {
        this.fechapago = fechapago;
    }

    public String getNamecustomer() {
        return namecustomer;
    }

    public void setNamecustomer(String namecustomer) {
        this.namecustomer = namecustomer;
    }

    
    
    
    
}
