
package Entity;

public class UseRole {
    
    private int id;
    private int useraccount_id;
    private int role_id;

    public UseRole() {
    }

    public UseRole(int id, int useraccount_id, int role_id) {
        this.id = id;
        this.useraccount_id = useraccount_id;
        this.role_id = role_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUseraccount_id() {
        return useraccount_id;
    }

    public void setUseraccount_id(int useraccount_id) {
        this.useraccount_id = useraccount_id;
    }
    
    
    
    
    
}
