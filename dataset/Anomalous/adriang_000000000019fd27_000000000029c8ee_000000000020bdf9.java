import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            List<Task> tasks = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                tasks.add(new Task(start, end));
            }
            String result = assignTasks(tasks);
            System.out.println("Case #" + i + ": " + result);
        }
    }

    private static String assignTasks(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(task -> task.start));
        StringBuilder sb = new StringBuilder();
        int cEnd = 0, jEnd = 0;
        for (Task task : tasks) {
            if (task.start >= cEnd) {
                task.handler = 'C';
                cEnd = task.end;
            } else if (task.start >= jEnd) {
                task.handler = 'J';
                jEnd = task.end;
            } else {
                return "IMPOSSIBLE";
            }
            sb.append(task.handler);
        }
        return sb.toString();
    }

    static class Task {
        int start;
        int end;
        char handler;

        Task(int start, int end) {
            this.start = start;
            this.end = end;
            this.handler = '0';
        }
    }
}