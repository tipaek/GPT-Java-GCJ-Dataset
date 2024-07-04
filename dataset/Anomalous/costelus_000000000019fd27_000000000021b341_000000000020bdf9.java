import java.util.Arrays;
import java.util.Scanner;

class Task {
    int start;
    int end;
    int pos;
    String assignee;

    Task(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    void solve() {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        String[] results = new String[testCases];

        for (int i = 0; i < testCases; i++) {
            int taskCount = scanner.nextInt();
            Task[] tasks = new Task[taskCount];

            for (int j = 0; j < taskCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[j] = new Task(start, end, j);
            }

            results[i] = assignTasks(tasks);
        }

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    String assignTasks(Task[] tasks) {
        Arrays.sort(tasks, (task1, task2) -> Integer.compare(task1.start, task2.start));

        int endTimeC = 0;
        int endTimeJ = 0;

        for (Task task : tasks) {
            if (endTimeC <= task.start) {
                endTimeC = task.end;
                task.assignee = "C";
            } else if (endTimeJ <= task.start) {
                endTimeJ = task.end;
                task.assignee = "J";
            } else {
                return "IMPOSSIBLE";
            }
        }

        Arrays.sort(tasks, (task1, task2) -> Integer.compare(task1.pos, task2.pos));
        StringBuilder resultBuilder = new StringBuilder();

        for (Task task : tasks) {
            resultBuilder.append(task.assignee);
        }

        return resultBuilder.toString();
    }
}