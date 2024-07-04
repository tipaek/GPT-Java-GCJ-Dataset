import java.io.OutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            Task[] tasks = new Task[n];
            for (int i = 0; i < n; i++) {
                tasks[i] = new Task(i, in.nextInt(), in.nextInt());
            }
            Arrays.sort(tasks);

            char[] parents = {'C', 'J'};
            int[] lastEndTime = new int[2];
            StringBuilder result = new StringBuilder();

            for (Task task : tasks) {
                boolean assigned = false;
                for (int j = 0; j < 2; j++) {
                    if (lastEndTime[j] <= task.start) {
                        lastEndTime[j] = task.end;
                        task.assignedTo = parents[j];
                        assigned = true;
                        break;
                    }
                }
                if (!assigned) {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            if (result.length() == 0) {
                Arrays.sort(tasks, (o1, o2) -> Integer.compare(o1.index, o2.index));
                for (Task task : tasks) {
                    result.append(task.assignedTo);
                }
            }

            out.println("Case #" + testNumber + ": " + result);
        }

        class Task implements Comparable<Task> {
            int index;
            int start;
            int end;
            char assignedTo;

            public Task(int index, int start, int end) {
                this.index = index;
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(Task other) {
                return Integer.compare(this.start, other.start);
            }
        }
    }
}