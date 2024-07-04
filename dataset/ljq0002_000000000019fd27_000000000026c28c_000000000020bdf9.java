import java.util.*;
import java.io.*;

class Task {
    public int index;
    public int start;
    public int end;
    public String assign;

    Task(int index, int start, int end) {
        this.index = index;
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            StringBuilder res = new StringBuilder();
            int tasks = sc.nextInt();
            Task[] ts = new Task[tasks];
            for (int j = 0; j < tasks; j++) {
                ts[j] = new Task(j, sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(ts, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
            int end = ts[0].end;
            ts[0].assign = "C";
            for (int j = 1; j < tasks; j++) {
                Task cur = ts[j];
                if (end > cur.start) continue;
                end = cur.end;
                cur.assign = "C";
            }
            end = 0;
            for (int j = 1; j < tasks; j++) {
                Task cur = ts[j];
                if (cur.assign != null && !cur.assign.isEmpty()) continue;
                if (end > cur.start) continue;
                end = cur.end;
                cur.assign = "J";
            }
            boolean flag = false;
            for (Task t : ts)
                if (t.assign == null || t.assign.isEmpty()) {
                    flag = true;
                    break;
                }

            if (flag) {
                System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
                continue;
            }
            Arrays.sort(ts, (a, b) -> a.index - b.index);
            for (Task t : ts) res.append(t.assign);
            System.out.println("Case #" + i + ": " + res);
        }
    }
}

