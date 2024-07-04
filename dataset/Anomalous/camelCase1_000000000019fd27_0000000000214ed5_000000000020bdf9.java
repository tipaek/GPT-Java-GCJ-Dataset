import java.util.*;
import java.io.*;

public class Solution {

    static BufferedReader br;
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = nextInt();
            Activity[] activities = new Activity[n];
            for (int i = 0; i < n; i++) {
                activities[i] = new Activity(nextInt(), nextInt(), i);
            }
            Arrays.sort(activities);

            Activity cameron = null;
            Activity jamie = null;
            char[] result = new char[n];

            boolean possible = true;
            for (Activity activity : activities) {
                if (cameron == null || cameron.end <= activity.start) {
                    cameron = activity;
                    result[activity.index] = 'C';
                } else if (jamie == null || jamie.end <= activity.start) {
                    jamie = activity;
                    result[activity.index] = 'J';
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + caseNumber + ": " + new String(result));
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
            caseNumber++;
        }
    }

    public static String next() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) {
                throw new IOException();
            }
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    public static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static double nextDouble() throws IOException {
        return Double.parseDouble(next());
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
            if (this.end != other.end) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }
}