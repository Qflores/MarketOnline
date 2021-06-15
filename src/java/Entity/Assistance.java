
package Entity;

public class Assistance {    
    private int id;
    private String fecha;
    private String starttime;
    private String endtime;
    private String  cause;
    private int humantalent_id;

    public Assistance() {
    }

    public Assistance(int id, String fecha, String starttime, String endtime, String cause, int humantalent_id) {
        this.id = id;
        this.fecha = fecha;
        this.starttime = starttime;
        this.endtime = endtime;
        this.cause = cause;
        this.humantalent_id = humantalent_id;
    }

    public int getHumantalent_id() {
        return humantalent_id;
    }

    public void setHumantalent_id(int humantalent_id) {
        this.humantalent_id = humantalent_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
    
    
    
    
}
