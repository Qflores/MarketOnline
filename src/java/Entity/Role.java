
package Entity;

import java.sql.Date;

public class Role {
    
    
    private int id ;
    private String name;
    private String expire;

    public Role() {
    }

    public Role(String name, String expire) {        
        this.name = name;
        this.expire = expire;
    }
    
    public Role(int id, String name, String expire) {
        this.id = id;
        this.name = name;
        this.expire = expire;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
    
    
    
}
