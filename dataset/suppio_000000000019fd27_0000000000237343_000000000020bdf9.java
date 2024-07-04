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
        int index;

        public Activity(int s, int e, int index) {
            this.s = s;
            this.e = e;
            this.index = index;
        }

        @Override
        public int compareTo(Activity activity) {
            return this.s - activity.s;
        }

        @Override
        public String toString() {
            return this.s + " " + this.e + " " + this.index;
        }

    }

    public static String schedule(Activity[] activities) {
        String c = scheduleUtil(activities, 1, activities[0], null, "C");
        String j = scheduleUtil(activities, 1, null, activities[0], "J");

        String schedule = (c.length() > j.length()) ? c : j;
        if (schedule.length() < activities.length) {
            return "IMPOSSIBLE";
        } else {
            char[] answer = new char[activities.length];
            for (int i = 0; i < activities.length; i++) {
                answer[activities[i].index] = schedule.charAt(i);
            }
            return String.valueOf(answer);
        }
    }

    public static String scheduleUtil(Activity[] activities, int current, Activity lastC, Activity lastJ,
            String schedule) {
        if (current == activities.length) {
            return schedule;
        }

        String j = schedule;
        String c = schedule;

        if (lastC == null || lastC.e <= activities[current].s) {
            c = scheduleUtil(activities, current + 1, activities[current], lastJ, schedule + "C");
            if (c.length() == activities.length) {
                return c;
            }
        }
        if (lastJ == null || lastJ.e <= activities[current].s) {
            j = scheduleUtil(activities, current + 1, lastC, activities[current], schedule + "J");
            if (j.length() == activities.length) {
                return j;
            }
        }

        return "";
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
            out.printf("Case #%d: %s%n", i, schedule(activities));
        }
    }
}
