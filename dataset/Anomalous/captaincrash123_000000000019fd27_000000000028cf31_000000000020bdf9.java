import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
                tasks[i] = new Task(startTimes[i], endTimes[i], i);
            }

            Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));

            char[] assignments = new char[n];
            boolean possible = true;

            int cameronEnd = 0;
            int jamieEnd = 0;

            for (Task task : tasks) {
                if (task.start >= cameronEnd) {
                    assignments[task.index] = 'C';
                    cameronEnd = task.end;
                } else if (task.start >= jamieEnd) {
                    assignments[task.index] = 'J';
                    jamieEnd = task.end;
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.print("Case #" + testCase + ": ");
                System.out.println(new String(assignments));
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
        scanner.close();
    }

    static class Task {
        int start, end, index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}