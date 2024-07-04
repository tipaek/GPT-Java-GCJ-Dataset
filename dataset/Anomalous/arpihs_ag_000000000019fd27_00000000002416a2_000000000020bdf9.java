import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class TaskComparator implements Comparator<Task> { 
    @Override
    public int compare(Task a, Task b) { 
        return Integer.compare(a.start, b.start); 
    } 
} 

public class Solution {
    
    public static class Task {
        public int start;
        public int end;
        public int index;

        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end, i);
            }

            char[] schedule = new char[n];
            Arrays.sort(tasks, new TaskComparator());

            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    cEnd = task.end;
                    schedule[task.index] = 'C';
                } else if (task.start >= jEnd) {
                    jEnd = task.end;
                    schedule[task.index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + new String(schedule));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }
}