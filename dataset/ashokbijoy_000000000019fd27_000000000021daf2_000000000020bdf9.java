import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            Task[] tasks = new Task[N];

            for (int i = 0; i < N; i++) {
                tasks[i] = new Task(i, sc.nextInt(), sc.nextInt());
            }
            System.out.println("Case #" + test_case + ": " + solve(tasks));
        }
        sc.close();
    }

    static class Task implements Comparable<Task> {
        public int id;
        public int start;
        public int end;

        public Task(int id, int s, int e) {
            this.id = id;
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Task o) {
            return Integer.compare(end, o.end);
        }
    }

    static String solve (Task[] tasks) {
        final String impossible = "IMPOSSIBLE";

        if (tasks == null || tasks.length < 1) return impossible;
        if (tasks.length == 1) return "C";
        int N = tasks.length;

        Arrays.sort(tasks);

        int[] partition = new int[N];

        partition[0] = 1;
        boolean isLastOne = true;

        for (int i = 1; i < N; i++) {
            if (tasks[i].start < tasks[i-1].end) {
                // overlapping
                boolean overlaps1 = false, overlaps2 = false;

                for (int j = i-1; j >= 0; j--) {
                    if (tasks[i].start >= tasks[j].end) break;

                    if (partition[j] == 1) overlaps1 = true;
                    else if (partition[j] == 2) overlaps2 = true;

                    if (overlaps1 && overlaps2) return impossible;
                }

                if (overlaps1 && overlaps2) {
                    return impossible;
                } else if (overlaps1) {
                    partition[i] = 2;
                    isLastOne = false;
                } else if (overlaps2) {
                    partition[i] = 1;
                    isLastOne = true;
                } else {
                    partition[i] = partition[i-1];
                }
            } else {
                // non overlapping
                partition[i] = partition[i-1];
            }
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int id = tasks[i].id;
            if (partition[id] == 1) {
                builder.append("C");
            } else if (partition[id] == 2) {
                builder.append("J");
            }
        }

        return builder.toString();
    }

}
