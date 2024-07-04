import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Task {
    int start;
    int end;
    int pos;

    Task(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        return Integer.compare(t1.start, t2.start);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];
            
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[j] = new Task(start, end, j);
            }
            
            Arrays.sort(tasks, new TaskComparator());
            
            int cEndTime = -1;
            int jEndTime = -1;
            boolean possible = true;
            char[] result = new char[n];
            
            for (Task task : tasks) {
                if (cEndTime <= task.start) {
                    cEndTime = task.end;
                    result[task.pos] = 'C';
                } else if (jEndTime <= task.start) {
                    jEndTime = task.end;
                    result[task.pos] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }
            
            String output = possible ? new String(result) : "IMPOSSIBLE";
            System.out.println("Case #" + i + ": " + output);
        }
        
        scanner.close();
    }
}