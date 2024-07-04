import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    private static class Task {
        int id;
        int start;
        int end;
        char name;

        Task(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        static Comparator<Task> sComparator = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.start - o2.start;
            }
        };
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            Task[] tasks = new Task[n];
            for (int j = 0; j < n; j++) {
                tasks[j] = new Task(j, in.nextInt(), in.nextInt());
            }

            Task[] sorted = tasks.clone();
            Arrays.sort(sorted, Task.sComparator);

            int[] ends = new int[2];
            sorted[0].name = 'C';
            ends[0] = sorted[0].end;
            for (int j = 1; j < sorted.length; j++) {
//                System.out.println(j + " " + sorted[j].end);
                if (sorted[j].start < ends[0] && sorted[j].start < ends[1]) {
                    tasks = null;
                    break;
                }
                if (ends[0] < ends[1]) {
                    if (sorted[j].start >= ends[0]) {
                        sorted[j].name = 'C';
                        ends[0] = sorted[j].end;
                    } else {
                        sorted[j].name = 'J';
                        ends[1] = sorted[j].end;
                    }
                } else {
                    if (sorted[j].start >= ends[1]) {
                        sorted[j].name = 'J';
                        ends[1] = sorted[j].end;
                    } else {
                        sorted[j].name = 'C';
                        ends[0] = sorted[j].end;
                    }
                }
            }

            StringBuilder builder = new StringBuilder();
            if (tasks == null) builder.append("IMPOSSIBLE");
            else for (Task task : tasks) {
                builder.append(task.name);
            }
            System.out.println(builder);
        }
    }
}