import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int T = scanner.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int N = scanner.nextInt();
            Task[] tasks = new Task[N];
            for (int i = 0; i < N; i++) {
                tasks[i] = new Task(scanner.nextInt(), scanner.nextInt(), i);
            }
            Arrays.sort(tasks, Comparator.comparingInt((Task t) -> t.s).thenComparingInt(t -> t.e));
            int cEnd = -1, jEnd = -1;
            boolean possible = true;
            for (Task task : tasks) {
                if (task.s >= cEnd) {
                    cEnd = task.e;
                    task.assignedTo = 'C';
                } else if (task.s >= jEnd) {
                    jEnd = task.e;
                    task.assignedTo = 'J';
                } else {
                    possible = false;
                    break;
                }
            }
            System.out.print("Case #" + cs + ": ");
            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                Arrays.sort(tasks, Comparator.comparingInt(t -> t.index));
                for (Task task : tasks) {
                    System.out.print(task.assignedTo);
                }
                System.out.println();
            }
        }
    }

    static class Task {
        int s, e, index;
        char assignedTo;

        Task(int s, int e, int index) {
            this.s = s;
            this.e = e;
            this.index = index;
        }
    }
}