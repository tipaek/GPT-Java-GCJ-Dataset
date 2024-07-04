import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static class Activity implements Comparable<Activity> {
        int s;
        int e;
        int i;

        public Activity(int s, int e, int i) {
            this.s = s;
            this.e = e;
            this.i = i;
        }

        @Override
        public int compareTo(Activity activity) {
            return this.s - activity.s;
        }

        @Override
        public String toString() {
            return "[" + this.s + ", " + this.e + ", " + this.i + "]";
        }
    }

    public static String solve(Activity[] activities) {
        char[] schedule = new char[activities.length];
        int c = -1;
        int j = -1;

        for (int i = 0; i < activities.length; i++) {
            if (activities[i].s >= c) {
                c = activities[i].e;
                schedule[activities[i].i] = 'C';
            } else if (activities[i].s >= j) {
                j = activities[i].e;
                schedule[activities[i].i] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return String.valueOf(schedule);
    }

    public static void main(final String[] args) throws IOException {
        FastReader in = new FastReader();
        PrintWriter out = new PrintWriter(System.out, true);

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            Activity[] activities = new Activity[n];
            for (int j = 0; j < n; j++) {
                activities[j] = new Activity(in.nextInt(), in.nextInt(), j);
            }
            Arrays.sort(activities);
            out.printf("Case #%d: %s%n", i, solve(activities));
        }
    }
}
