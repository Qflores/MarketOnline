
package Interface;

import java.util.List;

public interface Icrud <Anything>{
    
    public Anything ListByAtrib(Object key);
    public List<Anything> ListByPag(Object key,int start, int end);
    public List<Anything> ListByKey(Object key);
    
    public Anything ListByName(Object key);
    
    public boolean Insert(Anything c);
    public boolean Update(Anything c);
    public boolean DeleteByKey(Object key);
    
    
}
