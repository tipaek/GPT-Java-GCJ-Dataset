import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OversizedPancakeChoppers solver = new OversizedPancakeChoppers();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OversizedPancakeChoppers {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] as = new long[n];
            for (int i = 0; i < n; i++) {
                as[i] = in.nextLong();
            }
            Arrays.sort(as);
            Set<Long> s = new HashSet<>();
            for (int i = 0; i < as.length; i++) {
                s.add(as[i]);
            }
            int target = 0;
            if (d == 2) {
                if (s.size() == as.length) {
                    target = 1;
                } else {
                    target = 0;
                }
            } else if (d == 3) {
                Map<Long, Integer> m = new HashMap<>();
                boolean one = false;
                boolean two = false;
                boolean containsDouble = false;
                long max = Long.MIN_VALUE;
                int numOne = 0;
                long oneElem = 0;
                for (int i = 0; i < as.length; i++) {
                    m.putIfAbsent(as[i], 0);
                    m.put(as[i], m.get(as[i]) + 1);
                    if (m.get(as[i]) > 1) {
                        one = true;
                        numOne++;
                        oneElem = as[i];
                    }
                    if (m.get(as[i]) > 2) {
                        two = true;
                    }
                    max = Math.max(as[i], max);
                    containsDouble = s.contains(as[i] + as[i]);
                }
                System.out.println("s = " + s);
                System.out.println("d = " + d);
                System.out.println("containsDouble = " + containsDouble);
                if (two) {
                    target = 0;
                } else if (containsDouble || (one && (numOne > 1 || oneElem != max))) {
                    target = 1;
                } else {
                    target = 2;
                }
            }


            out.println("Case #" + testNumber + ": " + target);
        }

    }
}

