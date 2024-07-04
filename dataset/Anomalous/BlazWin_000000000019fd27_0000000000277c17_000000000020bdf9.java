import java.io.*;
import java.util.*;

/**
 * Main class to execute the solution for Parenting Partnering Returns problem.
 */
public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }

    static class ParentingPartneringReturns {

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                activities.add(new Activity(in.nextInt(), in.nextInt()));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            int lastC = 0;
            int lastJ = 0;
            StringBuilder result = new StringBuilder();

            for (Activity activity : activities) {
                if (activity.start >= lastC) {
                    result.append('C');
                    lastC = activity.end;
                } else if (activity.start >= lastJ) {
                    result.append('J');
                    lastJ = activity.end;
                } else {
                    out.println(String.format("Case #%d: IMPOSSIBLE", testNumber));
                    return;
                }
            }

            out.println(String.format("Case #%d: %s", testNumber, result.toString()));
        }

        static class Activity {
            int start;
            int end;

            Activity(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}