
package Entity;

public class Credits {
    
    private int id;
    private double amount=0;
    private String state="";
    private String description="";
    private int period=0;
    private String expirationdate="";
    private String namecustomer;    
    private int headerId=0;
    
    private CreditDetails Cdetalle;
    
    public Credits() {
    }

    public Credits(String state) {
        this.state = state;
    }
    
    public Credits(double amount){
        this.amount = amount;
    }
    
    public Credits(int id, double amount, String state, String description, int period, String expirationdate, String namecustomer, int headerId) {
        this.id = id;
        this.amount = amount;
        this.state = state;
        this.description = description;
        this.period = period;
        this.expirationdate = expirationdate;
        this.namecustomer = namecustomer;
        this.headerId = headerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getExpirationdate() {
        return expirationdate;
    }

    public void setExpirationdate(String expirationdate) {
        this.expirationdate = expirationdate;
    }

    public String getNamecustomer() {
        return namecustomer;
    }

    public void setNamecustomer(String namecustomer) {
        this.namecustomer = namecustomer;
    }

    public int getHeaderId() {
        return headerId;
    }

    public void setHeaderId(int headerId) {
        this.headerId = headerId;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    public CreditDetails getCdetalle() {
        return Cdetalle;
    }
    
    public void setCdetalle(CreditDetails cd)
    {
        this.Cdetalle = cd;
    }
    
    
    
    
    
}
