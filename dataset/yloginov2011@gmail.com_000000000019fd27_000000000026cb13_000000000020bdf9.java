import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int N = in.nextInt();
            int n = 0;
            Queue<Interval> q = new PriorityQueue<>();
            while (n < N) {
                int s = in.nextInt();
                int e = in.nextInt();
                q.offer(new Interval(s, e, n));
                n++;
            }
            String res = solve(q);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static String solve(Queue<Interval> q) {
        char[] res = new char[q.size()];
        Interval lastJ = q.poll();
        res[lastJ.id] = 'J';
        Interval lastC = q.poll();
        res[lastC.id] = 'C';
        while (!q.isEmpty()) {
            Interval next = q.poll();
            if (next.start >= lastJ.end) {
                res[next.id] = 'J';
                lastJ = next;
            } else if (next.start >= lastC.end) {
                res[next.id] = 'C';
                lastC = next;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(res);
    }

    private static class Interval implements Comparable<Interval> {
        int start;
        int end;
        int id;
        public Interval(int s, int e, int id) {
            this.start = s;
            this.end = e;
            this.id = id;
        }

        @Override
        public int compareTo(Interval o) {
            if (o.start == start) {
                return end - o.end;
            }
            return start - o.start;
        }
    }
}
