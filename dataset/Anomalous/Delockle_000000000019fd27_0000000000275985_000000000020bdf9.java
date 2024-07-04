import java.io.*;
import java.util.*;

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
            List<Activity> activities = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), i));
            }

            Collections.sort(activities);

            char[] result = new char[n];
            char[] parents = {'C', 'J'};
            Activity[] lastActivity = new Activity[2];

            for (Activity activity : activities) {
                boolean assigned = false;
                for (int j = 0; j < 2; j++) {
                    if (lastActivity[j] == null || lastActivity[j].end <= activity.start) {
                        lastActivity[j] = activity;
                        result[activity.index] = parents[j];
                        assigned = true;
                        break;
                    }
                }
                if (!assigned) {
                    out.printf("Case #%d: IMPOSSIBLE\n", testNumber);
                    return;
                }
            }

            out.printf("Case #%d: %s\n", testNumber, new String(result));
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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

    static class Activity implements Comparable<Activity> {
        int start, end, index;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }
}