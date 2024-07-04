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
            String res = "";
            int tasks = sc.nextInt();
            Task[] ts = new Task[tasks];
            for (int j = 0; j < tasks; j++) {
                ts[j] = new Task(j, sc.nextInt(), sc.nextInt());
            }
            Arrays.sort(ts, (a, b) -> a.start == b.start ? a.end - b.end : a.start - b.start);

            int cur = 0;
            int start = 0;
            int end = 0;
            Task last = null;
            for (Task t : ts) {
                if (cur == 0) {
                    t.assign = "C";
                    cur++;
                    start = t.start;
                    end = t.end;
                    last = t;
                    continue;
                }
                if (cur == 1) {
                    last = t.end > last.end ? t : last;
                    if (t.start >= end) {
                        t.assign = "C";
                        start = t.start;
                        end = t.end;
                        continue;
                    } else {
                        t.assign = "J";
                        cur++;
                        start = Math.max(start, t.start);
                        end = Math.min(end, t.end);
                        continue;
                    }
                }
                if (cur == 2) {
                    if (t.start < end) {
                        res = "IMPOSSIBLE";
                        continue;
                    }
                    if (t.start >= last.end) {
                        cur = 1;
                        t.assign = "C";
                        start = t.start;
                        end = t.end;
                        continue;
                    } else {
                        t.assign = last.assign.equals("C") ? "J" : "C";
                        start = Math.max(last.start, t.start);
                        end = Math.min(last.end, t.end);
                        continue;
                    }
                }
            }
            if (!res.isEmpty()) {
                System.out.println("Case #"+i+": "+res);
                continue;
            }
            Arrays.sort(ts, (a, b) -> a.index - b.index);
            for(Task t:ts) res += t.assign;
            System.out.println("Case #"+i+": "+res);
        }
    }
}

