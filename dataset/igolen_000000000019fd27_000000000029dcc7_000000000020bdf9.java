
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author Holenko I.
 * @since 2020-04-04
 */
public class Solution {

    public static void main(String[] args) throws FileNotFoundException {

                        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        Scanner in = new Scanner(new BufferedReader(new FileReader(new File("/home/illia/Workspace/java_examples/java_simple/src/main/resources/jam3.txt"))));
        int     t  = in.nextInt();


        for (int tCase = 1; tCase <= t; tCase++) {
            System.out.println("Case #" + tCase + ": " + process(in));
        }
    }

    private static String process(Scanner in) {
        List<Task> tasks = new ArrayList<>();
        int        n     = in.nextInt();
        for (int i = 0; i < n; i++) {
            int b = in.nextInt();
            int e = in.nextInt();
            tasks.add(new Task(b, e, i));
        }

        tasks.sort((o1, o2) -> {
            if (o1.b == o2.b)
                return o1.e - o2.e;

            return o1.b - o2.b;
        });

        Task j = null, c = null;
        for (Task task : tasks) {
            if (j == null || j.e <= task.b) {
                j = task;
                task.assignee = 'J';
            } else if (c == null || c.e <= task.b) {
                c = task;
                task.assignee = 'C';
            } else {
                return "IMPOSSIBLE";
            }

        }

        tasks.sort(Comparator.comparingInt(o -> o.i));

        StringBuilder b = new StringBuilder();
        for (Task task : tasks) {
            b.append(task.assignee);
        }

        return b.toString();
    }

    public static class Task {
        int b, e, i;
        char assignee;

        public Task(int b, int e, int i) {
            this.b = b;
            this.e = e;
            this.i = i;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "b=" + b +
                    ", e=" + e +
                    ", i=" + i +
                    ", assignee=" + assignee +
                    '}';
        }
    }
}


