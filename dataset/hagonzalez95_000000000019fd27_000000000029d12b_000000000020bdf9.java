import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        
        int numOfCases = scanner.nextInt();
        
        for (int caseIndex = 1; caseIndex <= numOfCases; ++caseIndex)
        {
            int numOfTasks = scanner.nextInt();
            
            ArrayList<Task> tasks = new ArrayList<Task>(numOfTasks);
            for (int taskIndex = 0; taskIndex < numOfTasks; ++taskIndex)
            {
                Task t = new Task();
                t.begin = scanner.nextInt();
                t.end = scanner.nextInt();
                
                tasks.add(t);
            }
            
            System.out.println("Case #" + caseIndex + ": " + ScheduleTasks(tasks));
        }
        
    }
    
    private static String ScheduleTasks(ArrayList<Task> tasks)
    {
        ArrayList<Task> originalOrderTasks = new ArrayList<Task>(tasks);
        
        Collections.sort(tasks);
        
        int cEnd = 0;
        int jEnd = 0;
        
        for (Task t : tasks)
        {
            if(t.begin >= cEnd)
            {
                cEnd = t.end;
                t.owner = 'C';
            }
            else if(t.begin >= jEnd)
            {
                jEnd = t.end;
                t.owner = 'J';
            }
            else
            {
                return "IMPOSSIBLE";
            }
        }
        
        StringBuilder strB = new StringBuilder();
        
        for (Task t : originalOrderTasks)
        {
            strB.append(t.owner);
        }
        
        return strB.toString();
    }
    
    private static class Task implements Comparable<Task>
    {
        char owner;
        int begin;
        int end;
        
        @Override
        public int compareTo(Task t)
        {
            if(this.begin == t.begin)
                return this.end - t.end;
            else
                return this.begin - t.begin;
        }
    }
}