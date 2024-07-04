import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    static class Task {
        int start;
        int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 1; t <= testCases; t++) {
            int n = Integer.parseInt(reader.readLine().trim().split(" ")[0]);
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] times = reader.readLine().trim().split(" ");
                int start = Integer.parseInt(times[0]);
                int end = Integer.parseInt(times[1]);
                tasks.add(new Task(start, end));
            }

            Collections.sort(tasks, (task1, task2) -> Integer.compare(task1.start, task2.start));
            assignTasks(tasks, t);
        }
    }

    private static void assignTasks(List<Task> tasks, int testCaseNumber) {
        int cameronEnd = 0;
        int jamieEnd = 0;
        StringBuilder schedule = new StringBuilder();

        for (Task task : tasks) {
            if (cameronEnd <= task.start) {
                cameronEnd = task.end;
                schedule.append('C');
            } else if (jamieEnd <= task.start) {
                jamieEnd = task.end;
                schedule.append('J');
            } else {
                schedule = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + testCaseNumber + ": " + schedule.toString());
    }
}