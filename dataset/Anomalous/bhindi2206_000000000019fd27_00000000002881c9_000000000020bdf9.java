import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static class Task implements Comparable<Task> {
        public int start;
        public int end;

        @Override
        public int compareTo(Task o) {
            return Integer.compare(this.start, o.start);
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
                tasks.add(task);
            }

            Collections.sort(tasks);

            int CEnd = 0, JEnd = 0;
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            for (Task task : tasks) {
                if (task.start >= CEnd) {
                    schedule.append('C');
                    CEnd = task.end;
                } else if (task.start >= JEnd) {
                    schedule.append('J');
                    JEnd = task.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + schedule.toString());
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}