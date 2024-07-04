package qualification.parenting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private class PairInt implements Comparable {

        int a, b;
        PairInt(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof PairInt)) {
                throw new RuntimeException();
            }
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
            intervals.add(new PairInt(in.nextInt(), in.nextInt()));
        }
        Collections.sort(intervals);
        PairInt c = null;
        PairInt j = null;
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; ++i) {
            PairInt pi = intervals.get(i);
            if (c == null || c.b <= pi.a) {
                c = pi;
                res.append('C');
                continue;
            }
            if (j == null || j.b <= pi.a) {
                j = pi;
                res.append('J');
                continue;
            }
            return "IMPOSSIBLE";
        }
        return res.toString();
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

