import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.ArrayList;

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
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int no = in.nextInt();
            int c = -1;
            int j = -1;
            String[] sb = new String[no];
            boolean impossible = false;
            List<ParentingPartneringReturns.Interval> intervalList = new ArrayList<>();
            for (int _i = 0; _i < no; _i++) {
                int curStart = in.nextInt();
                int curEnd = in.nextInt();
                intervalList.add(new ParentingPartneringReturns.Interval(curStart, curEnd, _i));
            }
            intervalList.sort(Comparator.comparingInt(i -> i.start));

            for (ParentingPartneringReturns.Interval interval : intervalList) {
                if (c < j) {
                    if (c <= interval.start) {
                        c = interval.end;
                        sb[interval.posOrig] = "C";
                    } else {
                        impossible = true;
                        break;
                    }
                } else {
                    if (j <= interval.start) {
                        j = interval.end;
                        sb[interval.posOrig] = "J";
                    } else {
                        impossible = true;
                        break;
                    }
                }
            }
            if (!impossible) {
                StringBuilder res = new StringBuilder();
                out.printf("Case #%d: %s\n", testNumber, String.join("", sb));
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
            }
        }

        static class Interval {
            int start;
            int end;
            int posOrig;

            public Interval(int start, int end, int posOrig) {
                this.start = start;
                this.end = end;
                this.posOrig = posOrig;
            }

        }

    }
}

