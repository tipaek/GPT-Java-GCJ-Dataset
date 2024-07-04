import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int numTasks = scanner.nextInt();
            Task[] tasks = new Task[numTasks];
            for (int i = 0; i < numTasks; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(i, start, end);
            }
            Arrays.sort(tasks, Comparator.comparingInt(task -> task.startTime));
            String result = assignTasks(tasks);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static String assignTasks(Task[] tasks) {
        int cEnd = 0;
        int jEnd = 0;
        for (Task task : tasks) {
            if (cEnd <= task.startTime) {
                cEnd = task.endTime;
                task.setParent('C');
            } else if (jEnd <= task.startTime) {
                jEnd = task.endTime;
                task.setParent('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        Arrays.sort(tasks, Comparator.comparingInt(task -> task.idx));
        StringBuilder result = new StringBuilder();
        for (Task task : tasks) {
            result.append(task.parent);
        }
        return result.toString();
    }

    static class Task {
        int idx;
        int startTime;
        int endTime;
        char parent;

        public Task(int idx, int startTime, int endTime) {
            this.idx = idx;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public void setParent(char parent) {
            this.parent = parent;
        }
    }
}