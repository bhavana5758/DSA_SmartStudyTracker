import java.io.*;
import java.util.*;

public class FileManager {

    public static void saveTasks(ArrayList<Task> tasks){

        try{

            BufferedWriter bw =
                    new BufferedWriter(new FileWriter("tasks.txt"));

            for(Task t : tasks){

                bw.write(t.name + "," +
                        t.priority + "," +
                        t.completed + "," +
                        t.deadline);

                bw.newLine();

            }

            bw.close();

        }

        catch(Exception e){

            System.out.println("Error saving tasks");

        }

    }

    public static ArrayList<Task> loadTasks(){

        ArrayList<Task> tasks = new ArrayList<>();

        try{

            BufferedReader br =
                    new BufferedReader(new FileReader("tasks.txt"));

            String line;

            while((line = br.readLine()) != null){

                String[] data = line.split(",");

                Task t = new Task(
                        data[0],
                        Integer.parseInt(data[1]),
                        data[3]
                );

                t.completed =
                        Boolean.parseBoolean(data[2]);

                tasks.add(t);

            }

            br.close();

        }

        catch(Exception e){

            System.out.println("No previous tasks found");

        }

        return tasks;

    }

}