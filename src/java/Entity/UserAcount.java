
package Entity;

public class UserAcount {
    
    private int id;
    private String user;
    private String password;
    private String passwordreset;
    private String state;
    private String enrollmentdate;
    private String fexpire;
    private String question;
    private String answer;
    private int person_Id;
    private int roleid;
    
    // query    
    private Role role;
    private Person person;
    
    
    
    public UserAcount() {
    }
    public UserAcount(int person_Id) {
         this.person_Id = person_Id;
    }
    
    public UserAcount(int id, String user, String password, String state, int person_Id, int roleid) {        
        this.id = id;
        this.user = user;
        this.password = password;
        this.state = state;
        this.person_Id = person_Id;
        this.roleid = roleid;
    }
    
    public UserAcount(int id, String user, String password, String passwordreset, String state, String enrollmentdate, String fexpire, String question, String answer, int person_Id ,int roleid) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.passwordreset = passwordreset;
        this.state = state;
        this.enrollmentdate = enrollmentdate;
        this.fexpire = fexpire;
        this.question = question;
        this.answer = answer;
        this.person_Id = person_Id;
        this.roleid = roleid;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordreset() {
        return passwordreset;
    }

    public void setPasswordreset(String passwordreset) {
        this.passwordreset = passwordreset;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEnrollmentdate() {
        return enrollmentdate;
    }

    public void setEnrollmentdate(String enrollmentdate) {
        this.enrollmentdate = enrollmentdate;
    }

    public String getFexpire() {
        return fexpire;
    }

    public void setFexpire(String fexpire) {
        this.fexpire = fexpire;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
