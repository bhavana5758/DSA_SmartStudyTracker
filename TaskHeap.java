import java.util.*;

public class TaskHeap {

    PriorityQueue<Task> heap =
            new PriorityQueue<>((a,b)->b.priority - a.priority);

    void add(Task t){
        heap.add(t);
    }

    Task poll(){
        return heap.poll();
    }

    void printHeap(){

        if(heap.isEmpty()){
            System.out.println("No high priority tasks");
            return;
        }

        PriorityQueue<Task> copy = new PriorityQueue<>(heap);

        while(!copy.isEmpty()){
            Task t = copy.poll();
            System.out.println(t.name+" (Priority:"+t.priority+") Deadline:"+t.deadline);
        }

    }

}
