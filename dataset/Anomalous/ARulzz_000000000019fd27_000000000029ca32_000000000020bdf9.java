import java.util.*;
import java.io.*;

class Task {
    int startTime;
    int endTime;
    int originalIndex;

    public Task(int startTime, int endTime, int originalIndex) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.originalIndex = originalIndex;
    }

    @Override
    public String toString() {
        return startTime + " " + endTime;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int activitiesCount = scanner.nextInt();
            Task[] tasks = new Task[activitiesCount];

            for (int i = 0; i < activitiesCount; i++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();
                tasks[i] = new Task(startTime, endTime, i);
            }

            System.out.println("Case #" + t + ": " + assignTasks(tasks));
        }
    }

    private static String assignTasks(Task[] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(task -> task.startTime));
        
        char[] assignments = new char[tasks.length];
        int cameronEndTime = -1;
        int jamieEndTime = -1;

        for (Task task : tasks) {
            if (task.startTime >= cameronEndTime) {
                cameronEndTime = task.endTime;
                assignments[task.originalIndex] = 'C';
            } else if (task.startTime >= jamieEndTime) {
                jamieEndTime = task.endTime;
                assignments[task.originalIndex] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        return new String(assignments);
    }
}