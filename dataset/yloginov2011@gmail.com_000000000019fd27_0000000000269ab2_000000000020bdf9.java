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
                q.offer(new Interval(s, e));
                n++;
            }
            String res = solve(q);
            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static String solve(Queue<Interval> q) {
        StringBuilder sb = new StringBuilder();
        Interval lastJ = q.poll();
        sb.append('J');
        Interval lastC = q.poll();
        sb.append('C');
        while (!q.isEmpty()) {
            Interval next = q.poll();
            if (next.start >= lastJ.end) {
                sb.append('J');
                lastJ = next;
            } else if (next.start >= lastC.end) {
                sb.append('C');
                lastC = next;
            } else {
                return "IMPOSSIBLE";
            }
        }
        return sb.toString();
    }

    private static class Interval implements Comparable<Interval> {
        int start;
        int end;
        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Interval o) {
            return o.start - start;
        }
    }
}
