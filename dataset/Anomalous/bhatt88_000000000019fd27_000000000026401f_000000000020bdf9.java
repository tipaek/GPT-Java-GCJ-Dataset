import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int cases = Integer.parseInt(br.readLine());
            for (int c = 0; c < cases; c++) {
                int n = Integer.parseInt(br.readLine());
                List<Task> tasks = new ArrayList<>();
                for (int l = 0; l < n; l++) {
                    String[] parts = br.readLine().split(" ");
                    int start = Integer.parseInt(parts[0]);
                    int end = Integer.parseInt(parts[1]);
                    tasks.add(new Task(start, end, l));
                }
                System.out.println("Case #" + (c + 1) + ": " + assignTasks(tasks, n));
            }
        }
    }

    private static String assignTasks(List<Task> tasks, int n) {
        tasks.sort(Comparator.comparingInt(task -> task.start));
        int maxJ = 0, maxC = 0;
        char[] assignment = new char[n];

        for (Task task : tasks) {
            if (maxC <= task.start) {
                assignment[task.index] = 'C';
                maxC = task.end;
            } else if (maxJ <= task.start) {
                assignment[task.index] = 'J';
                maxJ = task.end;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(assignment);
    }

    private static class Task {
        int start, end, index;

        Task(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}