import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    static class Task {
        int startTime;
        int endTime;

        Task(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = Integer.parseInt(reader.readLine().trim());
            List<Task> tasks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] times = reader.readLine().trim().split(" ");
                int startTime = Integer.parseInt(times[0]);
                int endTime = Integer.parseInt(times[1]);
                tasks.add(new Task(startTime, endTime));
            }

            Collections.sort(tasks, (task1, task2) -> Integer.compare(task1.startTime, task2.startTime));
            assignTasks(tasks, testCase);
        }
    }

    private static void assignTasks(List<Task> tasks, int testCaseNo) {
        int cameronEnd = 0;
        int jamieEnd = 0;
        StringBuilder schedule = new StringBuilder();

        for (Task task : tasks) {
            if (task.startTime >= cameronEnd) {
                cameronEnd = task.endTime;
                schedule.append('C');
            } else if (task.startTime >= jamieEnd) {
                jamieEnd = task.endTime;
                schedule.append('J');
            } else {
                schedule = new StringBuilder("IMPOSSIBLE");
                break;
            }
        }

        System.out.println("Case #" + testCaseNo + ": " + schedule);
    }
}