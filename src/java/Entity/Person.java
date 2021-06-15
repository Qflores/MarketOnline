
package Entity;

public class Person {
    
    private int Id=0;
    private String name="";
    private String firstname="";
    private String lastname="";
    private String firstmidname="";
    private String enrollmentdate="";
    private String birthdate="";
    private String sexo="N";
    private String numdoc="";
    
    // for conulta
    private Contact address;
    
    public Person() {
    }
    
    public Person(int id) {
        this.Id=id;
    }
    
    public Person(int id,  String nombres) {
        this.Id=id;
        this.name = nombres;
    }
    
    public Person(int id,  String nombres, String numdoc) {
        this.Id=id;
        this.name = nombres;
        this.numdoc=numdoc;
    }
    
    
    public Person(String numdoc) {
        this.numdoc=numdoc;
    }
    
    public Person(String name, String firstname, String lastname, String firstmidname) {
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.firstmidname = firstmidname;
    }
    public Person(int id, String name, String firstname, String doc) {//para actualizar
        this.Id = id;
        this.name = name;
        this.firstname = firstname;
        this.numdoc = doc;
    }
    
     public Person(String name, String firstname, String lastname,String sexo, String numdoc) {
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.sexo = sexo;
        this.numdoc = numdoc;
    }
    public Person(int Id, String name, String firstname, String lastname, String firstmidname, String enrollmentdate, String birthdate, String sexo, String numdoc) {
        this.Id = Id;
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.firstmidname = firstmidname;
        this.enrollmentdate = enrollmentdate;
        this.birthdate = birthdate;
        this.sexo = sexo;
        this.numdoc = numdoc;
    }

    public Person(String name, String firstname, String lastname, String firstmidname, String enrollmentdate, String birthdate, String sexo, String numdoc) {        
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.firstmidname = firstmidname;
        this.enrollmentdate = enrollmentdate;
        this.birthdate = birthdate;
        this.sexo = sexo;
        this.numdoc = numdoc;
    }
    public Person(int Id, String name, String firstname, String lastname, String firstmidname, String enrollmentdate, String birthdate, String sexo, String numdoc, Contact address) {
        this.Id = Id;
        this.name = name;
        this.firstname = firstname;
        this.lastname = lastname;
        this.firstmidname = firstmidname;
        this.enrollmentdate = enrollmentdate;
        this.birthdate = birthdate;
        this.sexo = sexo;
        this.numdoc = numdoc;
        this.address = address;
    }
    
    
    

    public String getNumdoc() {
        return numdoc;
    }

    public void setNumdoc(String numdoc) {
        this.numdoc = numdoc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstmidname() {
        return firstmidname;
    }

    public void setFirstmidname(String firstmidname) {
        this.firstmidname = firstmidname;
    }

    public String getEnrollmentdate() {
        return enrollmentdate;
    }

    public void setEnrollmentdate(String enrollmentdate) {
        this.enrollmentdate = enrollmentdate;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Contact getAddress() {
        return address;
    }

    public void setAddress(Contact address) {
        this.address = address;
    }
    
    
    
    
}
