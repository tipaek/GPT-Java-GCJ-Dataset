import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static String solve(Task[] tasks) {
        StringBuilder result = new StringBuilder();
        ArrayList<Task> cTasks = new ArrayList<>();
        ArrayList<Task> jTasks = new ArrayList<>();
        for (Task t : tasks) {
            boolean overlaps = false;
            for (Task ct : cTasks) {
                if (ct.overlap(t)) {
                    overlaps = true;
                }
            }
            if (!overlaps) {
                cTasks.add(t);
                result.append('C');
                continue;
            }
            overlaps = false;
            for (Task jt : jTasks) {
                if (jt.overlap(t)) {
                    overlaps = true;
                }
            }
            if (!overlaps) {
                jTasks.add(t);
                result.append('J');
            } else {
                return "IMPOSSIBLE";
            }
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            Task[] tasks = new Task[N];
            for (int j = 0; j < N; j++) {
                tasks[j] = new Task(in.nextInt(), in.nextInt());
            }
            String result = solve(tasks);
            System.out.printf("Case #%d: %s\n", i + 1, result);
        }
        in.close();
    }
}

class Task {
    private int start;
    private int end;

    public Task(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlap(Task other) {
        return (start < other.start && other.start < end) || (start < other.end && other.end < end);
    }
}