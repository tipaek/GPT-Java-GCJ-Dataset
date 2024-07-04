import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int taskCount = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();
            
            for (int i = 0; i < taskCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end, i));
            }
            
            Collections.sort(tasks, (task1, task2) -> Integer.compare(task1.start, task2.start));
            
            List<Character> availableWorkers = new ArrayList<>();
            availableWorkers.add('C');
            availableWorkers.add('J');
            
            List<Task> activeTasks = new ArrayList<>();
            boolean isImpossible = false;
            StringBuilder schedule = new StringBuilder();
            
            for (Task task : tasks) {
                List<Task> finishedTasks = new ArrayList<>();
                
                for (Task activeTask : activeTasks) {
                    if (activeTask.end <= task.start) {
                        finishedTasks.add(activeTask);
                        availableWorkers.add(activeTask.worker);
                    }
                }
                
                activeTasks.removeAll(finishedTasks);
                
                if (availableWorkers.isEmpty()) {
                    isImpossible = true;
                    break;
                }
                
                task.worker = availableWorkers.remove(0);
                activeTasks.add(task);
            }
            
            Collections.sort(tasks, (task1, task2) -> Integer.compare(task1.index, task2.index));
            
            for (Task task : tasks) {
                schedule.append(task.worker);
            }
            
            if (isImpossible) {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", caseNumber));
            } else {
                System.out.println(String.format("Case #%d: %s", caseNumber, schedule.toString()));
            }
        }
    }

    static class Task {
        int start;
        int end;
        char worker;
        int index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}