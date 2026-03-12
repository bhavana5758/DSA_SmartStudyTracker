import java.util.*;

public class TaskHash {

    HashMap<String,Task> map = new HashMap<>();

    void add(Task t){
        map.put(t.name,t);
    }

    Task search(String name){
        return map.getOrDefault(name,null);
    }

}