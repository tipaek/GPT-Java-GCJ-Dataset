import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int o = 1; o <= t; o++) {
            int n = sc.nextInt();
            Task[] tasks = new Task[n];
            
            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                tasks[i] = new Task(start, end, i);
            }
            
            Arrays.sort(tasks, Comparator.comparingInt(task -> task.end));
            
            char[] result = new char[n];
            Arrays.fill(result, 'x');
            
            int cEnd = 0, jEnd = 0;
            boolean possible = true;
            
            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    result[task.index] = 'C';
                    cEnd = task.end;
                } else if (task.start >= jEnd) {
                    result[task.index] = 'J';
                    jEnd = task.end;
                } else {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println("Case #" + o + ": " + new String(result));
            } else {
                System.out.println("Case #" + o + ": IMPOSSIBLE");
            }
        }
    }
}

class Task {
    int start;
    int end;
    int index;
    
    Task(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}