import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private class PairInt implements Comparable {

        int a, b, idx;
        PairInt(int a, int b, int idx) {
            this.a = a;
            this.b = b;
            this.idx = idx;
        }

        @Override
        public int compareTo(Object o) {
            PairInt op = (PairInt) o;
            if (a != op.a) {
                return a - op.a;
            }
            return b - op.b;
        }
    }


    public String solve(Scanner in) {
        int n = in.nextInt();
        List<PairInt> intervals = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            intervals.add(new PairInt(in.nextInt(), in.nextInt(), i));
        }
        Collections.sort(intervals);
        PairInt c = null;
        PairInt j = null;
        String res[] = new String[n];
        for(int i = 0; i < n; ++i) {
            PairInt pi = intervals.get(i);
            if (c == null || c.b <= pi.a) {
                c = pi;
                res[pi.idx] = "C";
                continue;
            }
            if (j == null || j.b <= pi.a) {
                j = pi;
                res[pi.idx] = "J";
                continue;
            }
            return "IMPOSSIBLE";
        }
        return String.join("", res);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        Solution sol = new Solution();
        for (int i = 1; i <= t; ++i) {
            System.out.println("Case #" + i + ": " + sol.solve(in));
        }
    }
}

