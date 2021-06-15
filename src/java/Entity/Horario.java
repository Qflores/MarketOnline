
package Entity;

public class Horario {
    
    private int id;
    private String starttime;
    private String endtime;

    public Horario() {
    }
    
    public Horario(String starttime, String endtime) {        
        this.starttime = starttime;
        this.endtime = endtime;
    }
    

    public Horario(int id, String starttime, String endtime) {
        this.id = id;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
        
    
}
