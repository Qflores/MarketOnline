
package Entity;

public class HumanTalent {
    
    
    private int id;
    private String starwork;
    private Double salary;
    private String endwork;
    private int person_Id;
    private int horario_Id;
    
    // for query 
    private Person persona ;
    private Contact address;
    private Horario horario;
    
    
    
    public HumanTalent() {
    }

    public HumanTalent(int id, String starwork, Double salary, String endwork, int person_Id, int horario_Id) {
        this.id = id;
        this.starwork = starwork;
        this.salary = salary;
        this.endwork = endwork;
        this.person_Id = person_Id;
        this.horario_Id = horario_Id;
    }

    public HumanTalent(int id, String starwork, Double salary, String endwork, Person persona, Contact address, Horario horario) {
        this.id = id;
        this.starwork = starwork;
        this.salary = salary;
        this.endwork = endwork;
        this.persona = persona;
        this.address = address;
        this.horario = horario;
    }
    
    public int getHorario_Id() {
        return horario_Id;
    }

    public void setHorario_Id(int horario_Id) {
        this.horario_Id = horario_Id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStarwork() {
        return starwork;
    }

    public void setStarwork(String starwork) {
        this.starwork = starwork;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getEndwork() {
        return endwork;
    }

    public void setEndwork(String endwork) {
        this.endwork = endwork;
    }

    public int getPerson_Id() {
        return person_Id;
    }

    public void setPerson_Id(int person_Id) {
        this.person_Id = person_Id;
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

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
