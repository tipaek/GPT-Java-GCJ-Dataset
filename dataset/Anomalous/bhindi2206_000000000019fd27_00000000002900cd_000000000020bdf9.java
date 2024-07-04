import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static class Task implements Comparable<Task> {
        public Integer start;
        public Integer end;
        public Integer index;

        @Override
        public int compareTo(Task other) {
            return this.start.compareTo(other.start);
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

            int CEnd = 0, JEnd = 0;
            boolean possible = true;
            char[] result = new char[n];

            for (Task task : tasks) {
                if (task.start >= CEnd) {
                    result[task.index] = 'C';
                    CEnd = task.end;
                } else if (task.start >= JEnd) {
                    result[task.index] = 'J';
                    JEnd = task.end;
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

        sc.close();
    }
}