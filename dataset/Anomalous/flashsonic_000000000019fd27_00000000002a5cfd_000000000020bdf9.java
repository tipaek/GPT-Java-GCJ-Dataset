import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int numberOfCases = scanner.nextInt();

        for (int caseIndex = 0; caseIndex < numberOfCases; caseIndex++) {
            int numberOfTasks = scanner.nextInt();
            
            Task[] tasks = new Task[numberOfTasks];
            Task[] originalTasks = new Task[numberOfTasks];
            
            for (int i = 0; i < numberOfTasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end);
                originalTasks[i] = new Task(start, end);
            }
            
            Arrays.sort(tasks);
            
            int cameronEndTime = 0;
            int jamieEndTime = 0;
            boolean isPossible = true;
            char[] schedule = new char[numberOfTasks];
            boolean[] assigned = new boolean[numberOfTasks];
            
            for (Task task : tasks) {
                if (cameronEndTime <= task.start) {
                    cameronEndTime = task.end;
                    assignTask(originalTasks, assigned, schedule, task, 'C');
                } else if (jamieEndTime <= task.start) {
                    jamieEndTime = task.end;
                    assignTask(originalTasks, assigned, schedule, task, 'J');
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            System.out.print("Case #" + (caseIndex + 1) + ": ");
            
            if (isPossible) {
                System.out.println(new String(schedule));
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
    
    private static void assignTask(Task[] originalTasks, boolean[] assigned, char[] schedule, Task task, char person) {
        for (int i = 0; i < originalTasks.length; i++) {
            if (!assigned[i] && originalTasks[i].equals(task)) {
                assigned[i] = true;
                schedule[i] = person;
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