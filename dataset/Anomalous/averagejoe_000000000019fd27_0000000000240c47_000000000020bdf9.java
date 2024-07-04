import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int cases = Integer.parseInt(br.readLine().trim());
            for (int j = 0; j < cases; j++) {
                int n = Integer.parseInt(br.readLine().trim());
                Task[] tasks = new Task[n];
                Map<Task, Integer> taskIndexMap = new HashMap<>();

                for (int i = 0; i < n; i++) {
                    String[] time = br.readLine().trim().split(" ");
                    int start = Integer.parseInt(time[0]);
                    int end = Integer.parseInt(time[1]);
                    tasks[i] = new Task(start, end);
                    taskIndexMap.put(tasks[i], i);
                }

                Arrays.sort(tasks);
                char[] schedule = new char[n];
                Task[] assignedTasks = {new Task(0, 0), new Task(0, 0)};
                boolean isImpossible = false;

                for (Task task : tasks) {
                    if (task.start < assignedTasks[0].end && task.start < assignedTasks[1].end) {
                        isImpossible = true;
                        break;
                    } else {
                        if (assignedTasks[0].end <= assignedTasks[1].end) {
                            assignedTasks[0] = task;
                            schedule[taskIndexMap.get(task)] = 'C';
                        } else {
                            assignedTasks[1] = task;
                            schedule[taskIndexMap.get(task)] = 'J';
                        }
                    }
                }

                String result = isImpossible ? "IMPOSSIBLE" : new String(schedule);
                System.out.printf("Case #%d: %s%n", j + 1, result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Comparable<Task> {
    int start, end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.start, other.start);
    }
}