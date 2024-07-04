import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jasper van Merle
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int activityCount = in.nextInt();
            List<ParentingPartneringReturns.Activity> activities = new ArrayList<>(activityCount);

            for (int i = 0; i < activityCount; i++) {
                activities.add(new ParentingPartneringReturns.Activity(i, in.nextInt(), in.nextInt()));
            }

            activities.sort(Comparator.comparingInt(a -> a.start));

            int cameron = -1;
            int jamie = -1;

            for (ParentingPartneringReturns.Activity activity : activities) {
                if (activity.start >= cameron) {
                    cameron = activity.end;
                    activity.person = 'C';
                } else if (activity.start >= jamie) {
                    jamie = activity.end;
                    activity.person = 'J';
                } else {
                    out.println(String.format("Case #%s: IMPOSSIBLE", testNumber));
                    return;
                }
            }

            activities.sort(Comparator.comparingInt(a -> a.id));

            StringBuilder output = new StringBuilder();
            for (ParentingPartneringReturns.Activity activity : activities) {
                output.append(activity.person);
            }

            out.println(String.format("Case #%s: %s", testNumber, output.toString()));
        }

        static class Activity {
            public int id;
            public int start;
            public int end;
            public char person = '?';

            public Activity(int id, int start, int end) {
                this.id = id;
                this.start = start;
                this.end = end;
            }

        }

    }

    static class InputReader {
        private BufferedReader br;
        private StringTokenizer st;

        public InputReader(InputStream in) {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

