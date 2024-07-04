import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.add(new Task(i, start, end));
            }

            tasks.sort(Comparator.comparingInt(task -> task.start));

            int cEnd = 0, jEnd = 0;
            boolean isPossible = true;

            for (Task task : tasks) {
                if (task.start >= cEnd) {
                    task.assignedTo = 'C';
                    cEnd = task.end;
                } else if (task.start >= jEnd) {
                    task.assignedTo = 'J';
                    jEnd = task.end;
                } else {
                    isPossible = false;
                    break;
                }
            }

            String result = isPossible ? getResultString(tasks) : "IMPOSSIBLE";
            System.out.printf("Case #%d: %s%n", t, result);
        }
    }

    private static String getResultString(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(task -> task.index));
        StringBuilder resultBuilder = new StringBuilder();

        for (Task task : tasks) {
            resultBuilder.append(task.assignedTo);
        }

        return resultBuilder.toString();
    }

    static class Task {
        int index;
        int start;
        int end;
        char assignedTo;

        Task(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }
    }
}