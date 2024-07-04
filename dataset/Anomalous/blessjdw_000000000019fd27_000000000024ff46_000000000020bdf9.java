import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    static class Task {
        int start, end, index;
        public Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int taskCount = scanner.nextInt();
            Task[] tasks = new Task[taskCount];
            for (int i = 0; i < taskCount; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks[i] = new Task(start, end, i + 1);
            }

            Arrays.sort(tasks, (task1, task2) -> {
                if (task1.start != task2.start) {
                    return Integer.compare(task1.start, task2.start);
                }
                return Integer.compare(task1.end, task2.end);
            });

            StringBuilder result = new StringBuilder();
            boolean possible = true;
            for (int i = 0; i < taskCount - 2; i++) {
                int maxStart = Math.max(tasks[i].start, Math.max(tasks[i + 1].start, tasks[i + 2].start));
                int minEnd = Math.min(tasks[i].end, Math.min(tasks[i + 1].end, tasks[i + 2].end));
                if (maxStart < minEnd) {
                    result.append("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                Set<Integer> cameronTasks = new HashSet<>();
                for (int i = 0; i < taskCount; i++) {
                    if (i % 2 == 0) {
                        cameronTasks.add(tasks[i].index);
                    }
                }
                for (int i = 1; i <= taskCount; i++) {
                    if (cameronTasks.contains(i)) {
                        result.append("C");
                    } else {
                        result.append("J");
                    }
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
    }
}