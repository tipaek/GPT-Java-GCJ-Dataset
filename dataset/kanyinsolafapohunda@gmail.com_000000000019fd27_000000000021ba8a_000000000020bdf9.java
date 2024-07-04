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
            int position;
            char assignee;

            Interval(int s, int e, int position) {

                this.start = s;
                this.end = e;
                this.position = position;
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
                intervals.add(new Interval(in.nextInt(), in.nextInt(), i));
            }

            Collections.sort(intervals);

            boolean isImpossible = false;
            boolean lastWasJ = false;
            Interval lastC = intervals.get(0);
            Interval lastJ = null;
            lastC.assignee = 'C';

            for (int i = 1; i < N; i++) {
                Interval curr = intervals.get(i);

                if (lastWasJ) {

                    if (lastJ.end > curr.start) {

                        if (lastC.end <= curr.start) {
                            lastWasJ = false;
                            lastC = curr;
                            curr.assignee = 'C';
                        } else {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        lastWasJ = true;
                        lastJ = curr;
                        curr.assignee = 'J';
                    }
                } else {

                    if (lastC.end > curr.start) {
                        if (lastJ == null || lastJ.end <= curr.start) {
                            lastWasJ = true;
                            lastJ = curr;
                            curr.assignee = 'J';
                        } else {
                            isImpossible = true;
                            break;
                        }
                    } else {
                        lastWasJ = false;
                        lastC = curr;
                        curr.assignee = 'C';
                    }
                }
            }

        //    System.out.println(Arrays.toString(intervals.toArray()));

            char[] result = new char[N];

            for (Interval interval: intervals) {
                result[interval.position] = interval.assignee;
            }

            out.printf("Case #%d: %s", testNumber, isImpossible ? "IMPOSSIBLE" : String.valueOf(result));
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