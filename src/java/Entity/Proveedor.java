
package Entity;


public class Proveedor {
    
   private int id;
    private String Businessname;
    private String contactname;
    private int person_Id; 
    
    // for query
    private Person persona;
    private Contact address;

    public Proveedor(int id, String Businessname, String contactname, Person persona, Contact address) {
        this.id = id;
        this.Businessname = Businessname;
        this.contactname = contactname;
        this.persona = persona;
        this.address = address;
    }
    

    public Proveedor() {
    }

    public Proveedor(int id, String Businessname, String contactname, int person_Id) {
        this.id = id;
        this.Businessname = Businessname;
        this.contactname = contactname;
        this.person_Id = person_Id;
    }
    
    

    public int getPerson_Id() {
        return person_Id;
    }

    public void setPerson_Id(int person_Id) {
        this.person_Id = person_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessname() {
        return Businessname;
    }

    public void setBusinessname(String Businessname) {
        this.Businessname = Businessname;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public Person getPersona() {
        return persona;
    }

    public void setPersona(Person persona) {
        this.persona = persona;
    }

    public Contact getAddress() {
        return address;
    }

    public void setAddress(Contact address) {
        this.address = address;
    }
    
    
    
    
    
}
