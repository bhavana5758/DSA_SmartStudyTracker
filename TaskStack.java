import java.util.*;

public class TaskStack {

    LinkedList<Task> stack = new LinkedList<>();

    void push(Task t){
        stack.addFirst(t);
    }

    Task pop(){
        return stack.isEmpty()?null:stack.removeFirst();
    }

    void printStack(){

        if(stack.isEmpty()){
            System.out.println("No recent completed tasks");
            return;
        }

        for(Task t: stack){
            System.out.println(t.name+" (Priority:"+t.priority+") Deadline:"+t.deadline);
        }

    }

}