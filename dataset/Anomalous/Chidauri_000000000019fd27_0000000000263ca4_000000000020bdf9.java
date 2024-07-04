import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];
            
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end, i);
            }
            
            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));
            
            char[] result = new char[n];
            int cameronEnd = 0, jamieEnd = 0;
            boolean possible = true;
            
            for (Task task : tasks) {
                if (task.start >= cameronEnd) {
                    cameronEnd = task.end;
                    result[task.index] = 'C';
                } else if (task.start >= jamieEnd) {
                    jamieEnd = task.end;
                    result[task.index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.print("Case #" + t + ": ");
                for (char c : result) {
                    System.out.print(c);
                }
                System.out.println();
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
        
        scanner.close();
    }
    
    static class Task {
        int start;
        int end;
        int index;
        
        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}