import java.io.*;
import java.util.*;

public class Solution {
    public static final PrintStream out = System.out;
    public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;

    public void doCase(int caseNumber) throws Exception {
        String line = in.readLine();
        Scanner scan = new Scanner(line);
        int N = scan.nextInt();
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = in.readLine();
            scan = new Scanner(line);
            Task task = new Task();
            task.start = scan.nextInt();
            task.end = scan.nextInt();
            task.order = i;
            tasks.add(task);
        }
        tasks.sort(Comparator.<Task, Integer>comparing(task -> task.start)
            .thenComparing(Comparator.comparing(task -> task.end))
            .thenComparing(Comparator.comparing(task -> task.order)));
        int cEnd = 0;
        int jEnd = 0;
        boolean impossible = false;
        for (Task task : tasks) {
            if (cEnd <= task.start) {
                task.who = 'C';
                cEnd = task.end;
            } else if (jEnd <= task.start) {
                task.who = 'J';
                jEnd = task.end;
            } else {
                impossible = true;
                break;
            }
        }
        if (impossible) {
            System.out.println("IMPOSSIBLE");
            return;
        }
        tasks.sort(Comparator.comparing(task -> task.order));
        for (Task task : tasks) {
            System.out.print(task.who);
        }
        System.out.println();
    }

    static class Task {
        int start;
        int end;
        int order;
        char who;
    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            out.print("Case #" + i + ": ");
            doCase(i);
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }

}
