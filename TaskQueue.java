import java.util.*;

public class TaskQueue {

    LinkedList<Task> queue = new LinkedList<>();

    void enqueue(Task t){
        queue.addLast(t);
    }

    Task dequeue(){
        return queue.isEmpty()?null:queue.removeFirst();
    }

    void printQueue(){

        if(queue.isEmpty()){
            System.out.println("No tasks for today");
            return;
        }

        for(Task t: queue){
            System.out.println(t.name+" (Priority:"+t.priority+") Deadline:"+t.deadline);
        }

    }

}