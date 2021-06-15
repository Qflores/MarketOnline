
package Entity;

public class PedidoHeader {
    private int id;
    private String numpedido;
    private String fechaped;
    private String fechaentrega;
    private double igvped;
    private double descuentoa;
    private double descuentob;
    private double subtotal;
    private double montototal;
    private String responsable;
    private String contacto;
    private String state;
    private int idproveedor;
    
    //
    private Proveedor proveedor;

    public PedidoHeader(int id) {
        this.id = id;
    }

    public PedidoHeader(String numpedido) {
        this.numpedido = numpedido;
    }

    
    
    public PedidoHeader() {
        
    }

    public PedidoHeader(int id, String numpedido, String fechaped, String fechaentrega, double igvped, double descuentoa, double descuentob, double subtotal, double montototal, String responsable, String contacto, String state,int idproveedor) {
        this.id = id;
        this.numpedido = numpedido;
        this.fechaped = fechaped;
        this.fechaentrega = fechaentrega;
        this.igvped = igvped;
        this.descuentoa = descuentoa;
        this.descuentob = descuentob;
        this.subtotal = subtotal;
        this.montototal = montototal;
        this.responsable = responsable;
        this.contacto = contacto;
        this.state = state;
        this.idproveedor = idproveedor;
    }

    public PedidoHeader(int id, String numpedido, String fechaped, String fechaentrega, double igvped, double descuentoa, double descuentob, double subtotal, double montototal, String responsable, String contacto, String state, int idproveedor, Proveedor proveedor) {
        this.id = id;
        this.numpedido = numpedido;
        this.fechaped = fechaped;
        this.fechaentrega = fechaentrega;
        this.igvped = igvped;
        this.descuentoa = descuentoa;
        this.descuentob = descuentob;
        this.subtotal = subtotal;
        this.montototal = montototal;
        this.responsable = responsable;
        this.contacto = contacto;
        this.state = state;
        this.idproveedor = idproveedor;
        this.proveedor = proveedor;
    }

    
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumpedido() {
        return numpedido;
    }

    public void setNumpedido(String numpedido) {
        this.numpedido = numpedido;
    }

    public String getFechaped() {
        return fechaped;
    }

    public void setFechaped(String fechaped) {
        this.fechaped = fechaped;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public double getIgvped() {
        return igvped;
    }

    public void setIgvped(double igvped) {
        this.igvped = igvped;
    }

    public double getDescuentoa() {
        return descuentoa;
    }

    public void setDescuentoa(double descuentoa) {
        this.descuentoa = descuentoa;
    }

    public double getDescuentob() {
        return descuentob;
    }

    public void setDescuentob(double descuentob) {
        this.descuentob = descuentob;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getMontototal() {
        return montototal;
    }

    public void setMontototal(double montototal) {
        this.montototal = montototal;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    
    
}
