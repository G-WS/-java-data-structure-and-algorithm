import java.util.ArrayList;
import java.util.List;

public class Queue {
    List<Object> list = new ArrayList<Object>();
    int index = 0;
    public void in(Object m){
        list.add(m);
        index++;
    }
    public Object out(){
       if(!list.isEmpty()){
           index--;
           return list.remove(0);
       }
       return list;
    }
}
