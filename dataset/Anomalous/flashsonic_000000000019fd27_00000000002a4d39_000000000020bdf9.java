import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int cases = scanner.nextInt();

        for (int n = 0; n < cases; n++) {
            int tasks = scanner.nextInt();
            
            Task[] tasksArray = new Task[tasks];
            Task[] originalTasks = new Task[tasks];
            
            for (int i = 0; i < tasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasksArray[i] = new Task(start, end);
                originalTasks[i] = new Task(start, end);
            }
            
            Arrays.sort(tasksArray);
            
            int cEnd = 0;
            int jEnd = 0;
            boolean isPossible = true;
            char[] result = new char[tasks];
            boolean[] assigned = new boolean[tasks];
            
            for (int i = 0; i < tasks; i++) {
                if (cEnd <= tasksArray[i].start) {
                    cEnd = tasksArray[i].end;
                    assignTask(tasksArray[i], originalTasks, result, assigned, 'C');
                } else if (jEnd <= tasksArray[i].start) {
                    jEnd = tasksArray[i].end;
                    assignTask(tasksArray[i], originalTasks, result, assigned, 'J');
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            StringBuilder ans = new StringBuilder();
            for (char c : result) {
                ans.append(c);
            }
            
            System.out.print("Case #" + (n + 1) + ": ");
            
            if (isPossible) {
                System.out.println(ans.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static void assignTask(Task task, Task[] originalTasks, char[] result, boolean[] assigned, char person) {
        for (int i = 0; i < originalTasks.length; i++) {
            if (!assigned[i] && task.equals(originalTasks[i])) {
                assigned[i] = true;
                result[i] = person;
                break;
            }
        }
    }
}

class Task implements Comparable<Task> {
    int start;
    int end;
    
    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return start == task.start && end == task.end;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}