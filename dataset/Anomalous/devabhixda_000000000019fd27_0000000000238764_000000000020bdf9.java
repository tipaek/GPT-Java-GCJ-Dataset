import java.util.*;
import java.io.*;

public class Solution {
    private static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(start, end, i));
            }

            tasks.sort(Comparator.comparingInt(task -> task.start));

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

    private static class Task {
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