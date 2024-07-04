import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {

        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {

        public class Interval implements Comparable<Interval> {
            int start;
            int end;

            Interval(int s, int e) {

                this.start = s;
                this.end = e;
            }

            @Override
            public int compareTo(Interval o) {
                int compareStart = o.start;
                return this.start - compareStart;
            }

            @Override
            public String toString() {
                return "Interval [start=" + start + ", end=" + end + "]";
            }
        }

        void solve(int testNumber, InputReader in, PrintWriter out) {

            int N = in.nextInt();

            List<Interval> intervals = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                intervals.add(new Interval(in.nextInt(), in.nextInt()));
            }

            Collections.sort(intervals);

            StringBuilder sb = new StringBuilder();

            boolean lastWasJ = false;
            Interval lastC = intervals.get(0);
            Interval lastJ = null;
            sb.append('C');

            for (int i = 1; i < N; i++) {
                Interval curr = intervals.get(i);

                if (lastWasJ) {

                    if (lastJ.end > curr.start) {

                        if (lastC.end <= curr.start) {
                            lastWasJ = false;
                            lastC = curr;
                            sb.append('C');
                        } else {
                            sb = null;
                            break;
                        }
                    } else {
                        lastWasJ = true;
                        lastJ = curr;
                        sb.append('J');
                    }
                } else {

                    if (lastC.end > curr.start) {
                        if (lastJ == null || lastJ.end <= curr.start) {
                            lastWasJ = true;
                            lastJ = curr;
                            sb.append('J');
                        } else {
                            sb = null;
                            break;
                        }
                    } else {
                        lastWasJ = false;
                        lastC = curr;
                        sb.append('C');
                    }
                }
            }

//            System.out.println(Arrays.toString(intervals.toArray()));

            out.printf("Case #%d: %s", testNumber, sb == null ? "IMPOSSIBLE" : sb.toString());
            out.println();
        }
    }
    
    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        InputReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            return nextToken();
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                String line;
                try {
                    line = br.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(nextToken());
        }
    }
}