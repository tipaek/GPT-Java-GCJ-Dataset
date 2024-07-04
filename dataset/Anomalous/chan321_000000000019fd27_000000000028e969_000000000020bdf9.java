import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    
    public static class Task {
        int start;
        int end;
        int index;
        String assignedTo;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine().trim());
            List<Task> tasks = new ArrayList<>();

            for (int i = 1; i <= n; i++) {
                String[] times = reader.readLine().trim().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);

                Task task = new Task();
                task.start = start;
                task.end = end;
                task.index = i;
                tasks.add(task);
            }

            Collections.sort(tasks, (a, b) -> Integer.compare(a.start, b.start));
            assignTasks(tasks, t);
        }
    }

    public static void assignTasks(List<Task> tasks, int testCaseNumber) {
        int cameronEnd = 0;
        int jamieEnd = 0;
        StringBuilder result = new StringBuilder();
        boolean isPossible = true;

        for (Task task : tasks) {
            if (task.start >= cameronEnd) {
                cameronEnd = task.end;
                task.assignedTo = "C";
            } else if (task.start >= jamieEnd) {
                jamieEnd = task.end;
                task.assignedTo = "J";
            } else {
                result.append("IMPOSSIBLE");
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            Collections.sort(tasks, (a, b) -> Integer.compare(a.index, b.index));
            for (Task task : tasks) {
                result.append(task.assignedTo);
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + result.toString());
    }
}