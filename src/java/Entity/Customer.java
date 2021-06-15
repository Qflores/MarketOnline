
package Entity;

public class Customer {
    
    private int id=0;
    private int person_id=0;
    private int typecustomer_id=1;
    private double linecredito=0.0;
    private double lineacumulada=0.0;
    
    
    // for query
    private TypeCustomer typecustomer;
    private Person persona ;    
    private Contact address;
    
    public Customer() {
    }

    public Customer(int id, int person_id) {
        this.person_id = person_id;
    }
    
    public Customer(int person_id, double lineacumulada) {
        this.person_id = person_id;
        this.lineacumulada = lineacumulada;
    }
    
    
    
    public Customer(int person_id, double linecredito, double lineacumulada) {
        
        this.person_id = person_id;
        this.linecredito = linecredito;
        this.lineacumulada = lineacumulada;
    }
    
    
    public Customer(int id, int person_id, int typecustomer_id, double linecredito, double lineacumulada, TypeCustomer typecustomer, Person persona, Contact address) {
        this.id = id;
        this.person_id = person_id;
        this.typecustomer_id = typecustomer_id;
        this.linecredito = linecredito;
        this.lineacumulada = lineacumulada;
        this.typecustomer = typecustomer;
        this.persona = persona;
        this.address = address;
    }

    public Contact getAddress() {
        return address;
    }

    public void setAddress(Contact address) {
        this.address = address;
    }

    public TypeCustomer getTypecustomer() {
        return typecustomer;
    }

    public void setTypecustomer(TypeCustomer typecustomer) {
        this.typecustomer = typecustomer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public int getTypecustomer_id() {
        return typecustomer_id;
    }

    public void setTypecustomer_id(int typecustomer_id) {
        this.typecustomer_id = typecustomer_id;
    }

    public double getLinecredito() {
        return linecredito;
    }

    public void setLinecredito(double linecredito) {
        this.linecredito = linecredito;
    }

    public double getLineacumulada() {
        return lineacumulada;
    }

    public void setLineacumulada(double lineacumulada) {
        this.lineacumulada = lineacumulada;
    }

    public Person getPersona() {
        return persona;
    }

    public void setPersona(Person persona) {
        this.persona = persona;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
