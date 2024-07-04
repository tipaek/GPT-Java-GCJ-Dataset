import java.util.*;
import java.io.*;

class Task implements Comparable<Task> {
    int start;
    int end;
    int index;
    boolean assignedToCameron;

    @Override
    public int compareTo(Task other) {
        if (this.start != other.start) {
            return Integer.compare(this.start, other.start);
        } else {
            return Integer.compare(this.end, other.end);
        }
    }
}

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int n = scanner.nextInt();
            Task[] tasks = new Task[n];

            for (int i = 0; i < n; i++) {
                tasks[i] = new Task();
                tasks[i].start = scanner.nextInt();
                tasks[i].end = scanner.nextInt();
                tasks[i].index = i;
            }

            Arrays.sort(tasks);

            Task cameronLastTask = null;
            Task jamieLastTask = null;
            boolean isPossible = true;

            for (int i = 0; i < n; i++) {
                Task currentTask = tasks[i];

                if (cameronLastTask == null || cameronLastTask.end <= currentTask.start) {
                    currentTask.assignedToCameron = true;
                    cameronLastTask = currentTask;
                } else if (jamieLastTask == null || jamieLastTask.end <= currentTask.start) {
                    currentTask.assignedToCameron = false;
                    jamieLastTask = currentTask;
                } else {
                    isPossible = false;
                    break;
                }
            }

            String result;
            if (isPossible) {
                char[] schedule = new char[n];
                for (Task task : tasks) {
                    schedule[task.index] = task.assignedToCameron ? 'C' : 'J';
                }
                result = new String(schedule);
            } else {
                result = "IMPOSSIBLE";
            }

            System.out.println("Case #" + testCase + ": " + result);
        }

        scanner.close();
    }
}