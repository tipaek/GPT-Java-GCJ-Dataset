import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            int cases = Integer.parseInt(br.readLine().trim());
            for (int j = 0; j < cases; j++) {
                int n = Integer.parseInt(br.readLine());
                Task[] tasks = new Task[n];

                for (int taskIndex = 0; taskIndex < n; taskIndex++) {
                    String[] timeRange = br.readLine().split(" ");
                    int start = Integer.parseInt(timeRange[0]);
                    int end = Integer.parseInt(timeRange[1]);
                    tasks[taskIndex] = new Task(start, end);
                }

                Arrays.sort(tasks);
                StringBuilder schedule = new StringBuilder();
                boolean isImpossible = false;

                Task[] assignedTasks = {new Task(0, 0), new Task(0, 0)};

                for (Task task : tasks) {
                    if (task.start < assignedTasks[0].end && task.start < assignedTasks[1].end) {
                        isImpossible = true;
                        break;
                    } else {
                        if (assignedTasks[0].end <= assignedTasks[1].end) {
                            assignedTasks[0] = task;
                            schedule.append('C');
                        } else {
                            assignedTasks[1] = task;
                            schedule.append('J');
                        }
                    }
                }

                String result = isImpossible ? "IMPOSSIBLE" : schedule.toString();
                System.out.println(String.format("Case #%d: %s", j + 1, result));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Comparable<Task> {
    int start;
    int end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}