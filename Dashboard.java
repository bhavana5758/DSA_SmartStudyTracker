import java.util.*;

public class Dashboard {

    static Scanner sc = new Scanner(System.in);

    static void start(){

        TaskStack completedStack = new TaskStack();
        TaskQueue todayQueue = new TaskQueue();
        TaskHeap priorityHeap = new TaskHeap();
        TaskHash taskMap = new TaskHash();

        ArrayList<Task> allTasks = FileManager.loadTasks();

        while(true){

            System.out.println("\n=== Dashboard ===");

            System.out.println("1 Add Task");
            System.out.println("2 View Today's Tasks");
            System.out.println("3 Mark Task Completed");
            System.out.println("4 View Recent Completed");
            System.out.println("5 View High Priority");
            System.out.println("6 Sort Tasks by Priority");
            System.out.println("7 Search Task");
            System.out.println("8 Exit");
System.out.println("Enter your Choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){

                case 1:

                    System.out.print("Task Name: ");
                    String n = sc.nextLine();

                    System.out.print("Priority (1-10): ");
                    int p = sc.nextInt(); sc.nextLine();

                    System.out.print("Deadline: ");
                    String d = sc.nextLine();

                    Task t = new Task(n,p,d);

                    allTasks.add(t);
                    todayQueue.enqueue(t);
                    priorityHeap.add(t);
                    taskMap.add(t);

                    System.out.println("Task added!");
                    break;

                case 2:

                    todayQueue.printQueue();
                    break;

                case 3:

                    System.out.print("Task name: ");
                    String cname = sc.nextLine();

                    Task ct = taskMap.search(cname);

                    if(ct!=null && !ct.completed){

                        ct.completed=true;
                        completedStack.push(ct);

                        System.out.println("Completed!");

                    }

                    else System.out.println("Task not found");

                    break;

                case 4:

                    completedStack.printStack();
                    break;

                case 5:

                    priorityHeap.printHeap();
                    break;

                case 6:

                    Task[] arr = allTasks.toArray(new Task[0]);

                    SearchingSorting.quickSortByPriority(arr,0,arr.length-1);

                    for(Task tt:arr){
                        System.out.println(tt.name+" Priority:"+tt.priority);
                    }

                    break;

                case 7:

                    System.out.print("Search name: ");
                    String s = sc.nextLine();

                    Task st = taskMap.search(s);

                    if(st!=null)
                        System.out.println("Found "+st.name);
                    else
                        System.out.println("Not found");

                    break;

                case 8:

    FileManager.saveTasks(allTasks);

    System.out.println("Tasks saved. Bye!");

    return;

            }

        }

    }

}