import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.lang.*;

class Task{
    int start;
    int finish;

    public Task(int start, int finish){
        this.start = start;
        this.finish = finish;
    }
}

class SortbyFinish implements Comparator<Task>
{
    // Used for sorting in ascending order of
    // roll number
    public int compare(Task a, Task b)
    {
        return a.finish - b.finish;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner fileScanner = new Scanner(System.in);
        int cases = fileScanner.nextInt();
        fileScanner.nextLine();


        for (int i = 0; i < cases; i++) {
            int J = 0;
            int C = 0;
            HashMap<Task, Integer> indexes = new HashMap<Task, Integer>();
            ArrayList<Task> sortedTask = new ArrayList<Task>();
            int tasks = fileScanner.nextInt();
            char[] result = new char[tasks];
            fileScanner.nextLine();
            boolean impossible = false;

            for (int j = 0; j < tasks; j++){
                int start = fileScanner.nextInt();
                int finish = fileScanner.nextInt();
                fileScanner.nextLine();
                Task task = new Task(start, finish);
                indexes.put(task, j);
                sortedTask.add(task);
            }

            Collections.sort(sortedTask, new SortbyFinish());
            for (Task t: sortedTask) {
                if (t.start >= J ){
                    result[indexes.get(t)] = 'J';
                    J = t.finish;
                    continue;
                } else if(t.start >= C){
                    result[indexes.get(t)] = 'C';
                    C = t.finish;
                    continue;
                } else{
                    //System.out.println(t.start);
                    impossible = true;
                    break;
                }
            }

            if (impossible){
                System.out.println("Case #" + (i+1) + " : IMPOSSIBLE");
            } else{
                System.out.print("Case #" + (i+1) + " :");
                for (char r: result) {
                    System.out.print(r);
                }
                System.out.println();
            }
        }
        fileScanner.close();
    }
}