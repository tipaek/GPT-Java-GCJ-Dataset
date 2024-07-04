import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int taskCount = Integer.parseInt(reader.readLine());
            List<Task> tasks = new ArrayList<>(taskCount);

            for (int i = 0; i < taskCount; i++) {
                String[] timeRange = reader.readLine().split(" ");
                int start = Integer.parseInt(timeRange[0]);
                int end = Integer.parseInt(timeRange[1]);
                tasks.add(new Task(start, end));
            }

            tasks.sort(Comparator.comparingInt((Task task) -> task.start).thenComparingInt(task -> task.end));

            StringBuilder schedule = new StringBuilder();
            boolean cAvailable = true, jAvailable = true, isImpossible = false;
            int cLastTaskIndex = -1, jLastTaskIndex = -1;

            for (int i = 0; i < tasks.size() && !isImpossible; i++) {
                int currentStartTime = tasks.get(i).start;

                if (cLastTaskIndex >= 0 && tasks.get(cLastTaskIndex).end <= currentStartTime) cAvailable = true;
                if (jLastTaskIndex >= 0 && tasks.get(jLastTaskIndex).end <= currentStartTime) jAvailable = true;

                if (cAvailable) {
                    cAvailable = false;
                    schedule.append("C");
                    cLastTaskIndex = i;
                } else if (jAvailable) {
                    jAvailable = false;
                    schedule.append("J");
                    jLastTaskIndex = i;
                } else {
                    if (tasks.get(cLastTaskIndex).end <= currentStartTime) {
                        schedule.append("C");
                        cLastTaskIndex = i;
                    } else if (tasks.get(jLastTaskIndex).end <= currentStartTime) {
                        schedule.append("J");
                        jLastTaskIndex = i;
                    } else {
                        isImpossible = true;
                    }
                }
            }

            assert isImpossible || taskCount == schedule.length();
            System.out.print("Case #" + caseNumber + ": ");
            System.out.println(isImpossible ? "IMPOSSIBLE" : schedule.toString());
        }
    }
}

class Task {
    int start, end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
}