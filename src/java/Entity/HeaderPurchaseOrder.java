
package Entity;

public class HeaderPurchaseOrder {
   private int id;
    private String purchasecode;
    private String typedocument;
    private String orderdate;
    private double subtotal;
    private double igv;
    private double commission;
    private double totalamount;
    private String state;
    private String modifidate;
    private int customer_id;
    private int paymentmethod_id;
    private int UsersId;
    
    // for query
    
    private PaymentMethod metodopago;
    private Customer cliente;
    
    public HeaderPurchaseOrder() {
    }

    public HeaderPurchaseOrder(int id, String purchasecode, String typedocument, String orderdate, double subtotal, double igv, double commission, double totalamount,String state, String modifidate, int customer_id, int paymentmethod_id) {
        this.id = id;
        this.purchasecode = purchasecode;
        this.typedocument = typedocument;
        this.orderdate = orderdate;
        this.subtotal = subtotal;
        this.igv = igv;
        this.commission = commission;
        this.totalamount = totalamount;
        this.state =state;
        this.modifidate = modifidate;
        this.customer_id = customer_id;
        this.paymentmethod_id = paymentmethod_id;
    }

    public HeaderPurchaseOrder(int id, String purchasecode, String typedocument, String orderdate, double subtotal, double igv, double commission, double totalamount, String modifidate, int customer_id, int paymentmethod_id, PaymentMethod metodopago, Customer cliente) {
        this.id = id;
        this.purchasecode = purchasecode;
        this.typedocument = typedocument;
        this.orderdate = orderdate;
        this.subtotal = subtotal;
        this.igv = igv;
        this.commission = commission;
        this.totalamount = totalamount;
        this.modifidate = modifidate;
        this.customer_id = customer_id;
        this.paymentmethod_id = paymentmethod_id;
        this.metodopago = metodopago;
        this.cliente = cliente;
    }

    public Customer getCliente() {
        return cliente;
    }

    public void setCliente(Customer cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPurchasecode() {
        return purchasecode;
    }

    public void setPurchasecode(String purchasecode) {
        this.purchasecode = purchasecode;
    }

    public String getTypedocument() {
        return typedocument;
    }

    public void setTypedocument(String typedocument) {
        this.typedocument = typedocument;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public String getModifidate() {
        return modifidate;
    }

    public void setModifidate(String modifidate) {
        this.modifidate = modifidate;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getPaymentmethod_id() {
        return paymentmethod_id;
    }

    public void setPaymentmethod_id(int paymentmethod_id) {
        this.paymentmethod_id = paymentmethod_id;
    }

    public PaymentMethod getMetodopago() {
        return metodopago;
    }

    public void setMetodopago(PaymentMethod metodopago) {
        this.metodopago = metodopago;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getUsersId() {
        return UsersId;
    }

    public void setUsersId(int UsersId) {
        this.UsersId = UsersId;
    }
    
    
}
