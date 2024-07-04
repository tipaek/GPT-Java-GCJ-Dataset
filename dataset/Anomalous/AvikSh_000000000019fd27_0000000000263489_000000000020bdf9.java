import java.util.*;
import java.io.*;

public class Solution {

    static class Task {
        int start;
        int end;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            int taskCount = scanner.nextInt();
            PriorityQueue<Task> tasks = new PriorityQueue<>(Comparator.comparingInt((Task task) -> task.start).thenComparingInt(task -> task.end));
            
            for (int j = 0; j < taskCount; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                tasks.offer(new Task(start, end));
            }

            int cEnd = Integer.MIN_VALUE;
            int jEnd = Integer.MIN_VALUE;
            StringBuilder schedule = new StringBuilder();

            boolean possible = true;
            while (!tasks.isEmpty()) {
                Task currentTask = tasks.poll();
                if (cEnd <= currentTask.start) {
                    cEnd = currentTask.end;
                    schedule.append("C");
                } else if (jEnd <= currentTask.start) {
                    jEnd = currentTask.end;
                    schedule.append("J");
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + (i + 1) + ": " + schedule.toString());
            }
        }
    }
}