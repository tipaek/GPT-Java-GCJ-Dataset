import java.util.Arrays;
import java.util.Scanner;

class Task {
    int start;
    int end;

    Task(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String[] results = new String[T];

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            Task[] tasks = new Task[n];
            for (int j = 0; j < n; j++) {
                tasks[j] = new Task(sc.nextInt(), sc.nextInt());
            }
            results[i] = assignTasks(tasks);
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Case #" + (i + 1) + ": " + results[i]);
        }
    }

    private String assignTasks(Task[] tasks) {
        int n = tasks.length;
        char[] schedule = new char[n];
        Task[] sortedTasks = tasks.clone();
        Arrays.sort(sortedTasks, (a, b) -> Integer.compare(a.start, b.start));

        int endC = 0, endJ = 0;
        for (int i = 0; i < n; i++) {
            if (endC <= sortedTasks[i].start) {
                endC = sortedTasks[i].end;
                schedule[i] = 'C';
            } else if (endJ <= sortedTasks[i].start) {
                endJ = sortedTasks[i].end;
                schedule[i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        StringBuilder result = new StringBuilder();
        for (Task task : tasks) {
            for (int j = 0; j < n; j++) {
                if (sortedTasks[j].start == task.start && sortedTasks[j].end == task.end) {
                    result.append(schedule[j]);
                    sortedTasks[j].start = -1; // Mark this task as used
                    break;
                }
            }
        }

        return result.toString();
    }
}