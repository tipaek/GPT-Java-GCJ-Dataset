import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    private static final Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static final PrintWriter w = new PrintWriter(System.out);
    private static final String NEW_LINE = "\n";

    public static void main(String[] args) {
        int T = sc.nextInt();
        StringBuilder result = new StringBuilder();
        
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            int[][] times = new int[N][2];
            
            for (int i = 0; i < N; i++) {
                times[i][0] = sc.nextInt();
                times[i][1] = sc.nextInt();
            }
            
            result.append("Case #").append(t).append(": ").append(assignTasks(times)).append(NEW_LINE);
        }
        
        w.print(result.toString());
        w.close();
    }

    private static String assignTasks(int[][] times) {
        List<Task> tasks = new ArrayList<>();
        
        for (int[] time : times) {
            tasks.add(new Task(time[0], time[1]));
        }
        
        Collections.sort(tasks);

        StringBuilder schedule = new StringBuilder();
        Task cameron = null;
        Task jamie = null;

        for (Task task : tasks) {
            if (cameron == null || cameron.end <= task.start) {
                cameron = task;
                schedule.append("C");
            } else if (jamie == null || jamie.end <= task.start) {
                jamie = task;
                schedule.append("J");
            } else {
                return "IMPOSSIBLE";
            }
        }
        
        return schedule.toString();
    }

    private static class Task implements Comparable<Task> {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Task other) {
            if (this.start == other.start) {
                return Integer.compare(this.end, other.end);
            }
            return Integer.compare(this.start, other.start);
        }
    }
}