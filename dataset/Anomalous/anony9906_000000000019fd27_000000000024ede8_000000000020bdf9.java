import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader reader = new FastReader(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);
        CodeJam solver = new CodeJam();
        solver.solve(1, reader, writer);
        writer.close();
    }

    static class CodeJam {
        public void solve(int testNumber, FastReader reader, PrintWriter writer) {
            int T = reader.nextInt();
            for (int t = 1; t <= T; t++) {
                int n = reader.nextInt();
                Interval[] intervals = new Interval[n];
                for (int i = 0; i < n; i++) {
                    intervals[i] = new Interval(reader.nextInt(), reader.nextInt(), i);
                }
                Arrays.sort(intervals, (a, b) -> a.start != b.start ? Integer.compare(a.start, b.start) : Integer.compare(a.end, b.end));

                boolean possible = true;
                char[] result = new char[n];
                int lastC = 0, lastJ = 0;

                for (Interval interval : intervals) {
                    if (lastC <= interval.start) {
                        lastC = interval.end;
                        result[interval.index] = 'C';
                    } else if (lastJ <= interval.start) {
                        lastJ = interval.end;
                        result[interval.index] = 'J';
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (possible) {
                    writer.println("Case #" + t + ": " + new String(result));
                } else {
                    writer.println("Case #" + t + ": IMPOSSIBLE");
                }
            }
        }

        static class Interval {
            int start;
            int end;
            int index;

            Interval(int start, int end, int index) {
                this.start = start;
                this.end = end;
                this.index = index;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream), 32768);
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}