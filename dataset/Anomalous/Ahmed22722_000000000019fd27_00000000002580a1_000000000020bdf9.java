import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static class Activity implements Comparable<Activity> {
        int start, end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        StringBuilder result = new StringBuilder();

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int n = in.nextInt();
            ArrayList<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Activity(start, end));
            }

            Collections.sort(activities);

            int cameronEnd = 0, jamieEnd = 0;
            boolean impossible = false;
            StringBuilder schedule = new StringBuilder();

            for (Activity activity : activities) {
                if (activity.start >= cameronEnd) {
                    schedule.append('C');
                    cameronEnd = activity.end;
                } else if (activity.start >= jamieEnd) {
                    schedule.append('J');
                    jamieEnd = activity.end;
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                result.append(String.format("Case #%d: IMPOSSIBLE%n", caseNum));
            } else {
                result.append(String.format("Case #%d: %s%n", caseNum, schedule.toString()));
            }
        }

        out.print(result.toString());
        out.flush();
    }

    private static final class FastReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}