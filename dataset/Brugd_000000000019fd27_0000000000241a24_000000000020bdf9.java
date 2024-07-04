import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    
    private static final class Task {
        int startTime;
        int endTime;
        int taskNdx;
        char owner;
        
        public Task(int ndx, int start, int end) {
            startTime = start;
            endTime = end;
            taskNdx = ndx;
        }
        
        public void assignTo(char person) {
            this.owner = person;
        }
        
        public String toString() {
            return String.format("ndx: %d ask: %d -> %d owner: %c", taskNdx, startTime, endTime, owner);
        }
    }
    
    public static final String impossible = "IMPOSSIBLE";
    
    public static void main(String[] args) {
        Scanner input =  new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        
        int T;
        T = input.nextInt();
        
        for (int i = 0; i < T; i++) {
            String res = solution(input);
            output.println(String.format("Case #%d: %s",(i+1), res));
            output.flush();
        }
    }
    
    public static String solution(Scanner input) {
        StringBuilder builder = new  StringBuilder();
        int nbrTasks = input.nextInt();
        Task[] tasks = new Task[nbrTasks];
        Task cameronsTask = new Task(-1, Integer.MIN_VALUE, Integer.MIN_VALUE);
        Task jamiesTask = new Task(-1, Integer.MIN_VALUE, Integer.MIN_VALUE);
        
        for (int i = 0; i < nbrTasks; i++) {
            tasks[i] = new Task(i, input.nextInt(), input.nextInt());
        }
        
        Arrays.sort(tasks, (Task a, Task b) -> a.startTime - b.startTime);
                        
        // Assign Task
        for (int i = 0; i < nbrTasks; i++) {
            Task curr = tasks[i];
            if (jamiesTask.endTime <= curr.startTime) {
                // Jamie was free, giving task to Jamie
                jamiesTask = curr;
                curr.assignTo('C');
            } else if (cameronsTask.endTime <= curr.startTime) {
                // Cameron  was free, giving task to Cameron
                cameronsTask = curr;
                curr.assignTo('J');              
            } else {
                // No one was free to take the task...
                // Our universe is doomed, doooooomed...
                return impossible;
            }
        }
        
        // Resort on taskNdx to get the correct order
        Arrays.sort(tasks, (Task a, Task b) -> a.taskNdx - b.taskNdx);
        for (int i = 0; i < tasks.length; i++) {
            builder.append(tasks[i].owner);
        }
        
        return builder.toString();
    }
}