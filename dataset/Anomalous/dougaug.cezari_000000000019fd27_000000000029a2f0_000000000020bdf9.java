import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static class Task implements Comparable<Task> {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int numTasks = scanner.nextInt();
            Task[] tasks = new Task[numTasks];

            for (int i = 0; i < numTasks; i++) {
                tasks[i] = new Task(scanner.nextInt(), scanner.nextInt());
            }

            Arrays.sort(tasks);

            StringBuilder schedule = new StringBuilder();
            int cEnd = 0, jEnd = 0;
            boolean possible = true;

            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    schedule.append('C');
                    cEnd = task.end;
                } else if (task.start >= jEnd) {
                    schedule.append('J');
                    jEnd = task.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", t);
            } else {
                System.out.printf("Case #%d: %s%n", t, schedule.toString());
            }
        }
        scanner.close();
    }
}