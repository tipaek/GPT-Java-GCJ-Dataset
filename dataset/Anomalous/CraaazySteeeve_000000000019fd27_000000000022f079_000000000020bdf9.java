import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        
        for (int t = 0; t < testCaseCount; t++) {
            int taskCount = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();
            StringBuilder taskAssignment = new StringBuilder("X".repeat(taskCount));
            
            for (int i = 0; i < taskCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                tasks.add(new Task(startTime, endTime, i));
            }
            
            Collections.sort(tasks);
            
            Task cTask = null;
            Task jTask = null;
            boolean possible = true;
            
            for (Task currentTask : tasks) {
                if (cTask == null || cTask.endTime <= currentTask.startTime) {
                    cTask = currentTask;
                    taskAssignment.setCharAt(currentTask.taskId, 'C');
                } else if (jTask == null || jTask.endTime <= currentTask.startTime) {
                    jTask = currentTask;
                    taskAssignment.setCharAt(currentTask.taskId, 'J');
                } else {
                    possible = false;
                    break;
                }
            }
            
            System.out.println("Case #" + (t + 1) + ": " + (possible ? taskAssignment.toString() : "IMPOSSIBLE"));
        }
        
        scanner.close();
    }
}

class Task implements Comparable<Task> {
    public int startTime;
    public int endTime;
    public int taskId;
    
    public Task(int startTime, int endTime, int taskId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskId = taskId;
    }
    
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}