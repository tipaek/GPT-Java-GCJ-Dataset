import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static class Task {
        public int start;
        public int end;
        public int pos;
        public char assignee;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt();
        for (int t = 1; t <= testCount; ++t) {
            int n = in.nextInt();
            Task[] caseInput = new Task[n];
            for (int i = 0; i < n; i++) {
                Task task = new Task();
                task.start = in.nextInt();
                task.end = in.nextInt();
                task.pos = i;
                caseInput[i] = task;

            }
            String res = calculate(n, caseInput);
            System.out.println("Case #" + t + ": " + res);
        }
    }

    private static String calculate(int n, Task[] tasks)
    {
        Arrays.sort(tasks, (a, b) -> {
            int compare = Integer.compare(a.start, b.start);
            if (compare != 0) {
                return compare;
            }
            return Integer.compare(a.end, b.end);
        });
        Task taskC = null, taskJ = null;
        boolean impossible = false;
        for (Task currentTask: tasks) {
            if (taskC == null || taskC.end <= currentTask.start) {
                currentTask.assignee = 'C';
                taskC = currentTask;
            } else if (taskJ == null || taskJ.end <= currentTask.start) {
                currentTask.assignee = 'J';
                taskJ = currentTask;
            } else {
                impossible = true;
                break; // can't assign
            }
        }
        if (impossible) {
            return "IMPOSSIBLE";
        }

        Arrays.sort(tasks, Comparator.comparingInt(a -> a.pos));
        StringBuilder s = new StringBuilder();
        for (Task currentTask: tasks) {
            s.append(currentTask.assignee);
        }

        return s.toString();
    }
}
