import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(i, start, end));
            }
            
            tasks.sort(Comparator.comparingInt(task -> task.start));
            
            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;
            
            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    task.assignedTo = 'C';
                    cEnd = task.end;
                } else if (task.start >= jEnd) {
                    task.assignedTo = 'J';
                    jEnd = task.end;
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                tasks.sort(Comparator.comparingInt(task -> task.index));
                StringBuilder result = new StringBuilder();
                for (Task task : tasks) {
                    result.append(task.assignedTo);
                }
                System.out.println(String.format("Case #%d: %s", t, result.toString()));
            } else {
                System.out.println(String.format("Case #%d: IMPOSSIBLE", t));
            }
        }
    }
    
    static class Task {
        int index;
        int start;
        int end;
        char assignedTo;
        
        Task(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}