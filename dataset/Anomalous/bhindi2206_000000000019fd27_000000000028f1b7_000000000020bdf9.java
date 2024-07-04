import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static class Task implements Comparable<Task> {
        public int start;
        public int end;
        public int index;
        
        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfTests = sc.nextInt();

        for (int t = 1; t <= noOfTests; t++) {
            int n = sc.nextInt();
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                Task task = new Task();
                task.start = sc.nextInt();
                task.end = sc.nextInt();
                task.index = i;
                tasks.add(task);
            }

            Collections.sort(tasks);

            int cEnd = 0, jEnd = 0;
            char[] result = new char[n];
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
                System.out.println("Case #" + t + ": " + new String(result));
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}