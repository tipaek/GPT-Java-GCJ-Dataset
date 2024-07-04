import java.io.*;
import java.util.*;

public class Solution {

    static class Task implements Comparable<Task> {
        int index, time, type;

        public Task(int index, int time, int type) {
            this.index = index;
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Task other) {
            if (this.time == other.time) {
                return this.type - other.type;
            }
            return this.time - other.time;
        }

        @Override
        public String toString() {
            return index + " " + time + " " + type;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[2 * n];

            for (int i = 0; i < n; i++) {
                tasks[2 * i] = new Task(i, scanner.nextInt(), 1);
                tasks[2 * i + 1] = new Task(i, scanner.nextInt(), -1);
            }

            Arrays.sort(tasks);

            boolean cameronAvailable = false;
            boolean jamieAvailable = false;
            int[] assignedTasks = new int[n];
            Arrays.fill(assignedTasks, -1);

            boolean possible = true;

            for (Task task : tasks) {
                if (task.type == 1) { // Task start
                    if (!cameronAvailable) {
                        cameronAvailable = true;
                        assignedTasks[task.index] = 0;
                    } else if (!jamieAvailable) {
                        jamieAvailable = true;
                        assignedTasks[task.index] = 1;
                    } else {
                        System.out.println("Case #" + testCase + ": IMPOSSIBLE");
                        possible = false;
                        break;
                    }
                } else { // Task end
                    if (assignedTasks[task.index] == 0) {
                        cameronAvailable = false;
                    } else {
                        jamieAvailable = false;
                    }
                }
            }

            if (possible) {
                System.out.print("Case #" + testCase + ": ");
                for (int assignment : assignedTasks) {
                    System.out.print(assignment == 0 ? 'C' : 'J');
                }
                System.out.println();
            }
        }
    }
}