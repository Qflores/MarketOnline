
package Entity;

public class Contact {
    
    private int id;
    private String adress="";
    private String email="";
    private String numphone="";
    private String numhouse="";
    private String numwork="";
    private String namecontact="";
    private int person_Id;

    public Contact() {
    }
    
    public Contact(String adress) {
        this.adress = adress;        
    }
    
    public Contact(String adress,String email ,String numphone) {
        this.adress = adress;
        this.email = email;
        this.numphone = numphone;
    }
    public Contact(String adress,String email ,String numphone, String numhouse) {
        this.adress = adress;
        this.email = email;
        this.numphone = numphone;
        this.numhouse = numhouse;
    }
    
    public Contact(String adress, String email, String t1, String t2, int idp) {
        this.adress = adress;
        this.email = email;
        this.numphone = t1;
        this.numhouse = t2;
        this.person_Id = idp;
    }
    
    
    public Contact(int id, String adress, String email, String numphone, String numhouse, String numwork, String namecontact, int person_Id) {
        this.id = id;
        this.adress = adress;
        this.email = email;
        this.numphone = numphone;
        this.numhouse = numhouse;
        this.numwork = numwork;
        this.namecontact = namecontact;
        this.person_Id = person_Id;
    }
    
    public Contact(String adress, String email, String numphone, String numhouse, String numwork, String namecontact, int person_Id) {        
        this.adress = adress;
        this.email = email;
        this.numphone = numphone;
        this.numhouse = numhouse;
        this.numwork = numwork;
        this.namecontact = namecontact;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumphone() {
        return numphone;
    }

    public void setNumphone(String numphone) {
        this.numphone = numphone;
    }

    public String getNumhouse() {
        return numhouse;
    }

    public void setNumhouse(String numhouse) {
        this.numhouse = numhouse;
    }

    public String getNumwork() {
        return numwork;
    }

    public void setNumwork(String numwork) {
        this.numwork = numwork;
    }

    public String getNamecontact() {
        return namecontact;
    }

    public void setNamecontact(String namecontact) {
        this.namecontact = namecontact;
    }
    
    
    
}
