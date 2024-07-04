import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Kattio scanner = new Kattio(System.in);
        int testCases = scanner.getInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.getInt();
            List<Activity> activities = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int start = scanner.getInt();
                int end = scanner.getInt();
                activities.add(new Activity(start, end, i));
            }

            int jEnd = 0;
            int cEnd = 0;
            int[] assignments = new int[n];
            boolean impossible = false;

            Collections.sort(activities, Comparator.comparingInt(a -> a.start));

            for (Activity activity : activities) {
                if (activity.start >= jEnd) {
                    jEnd = activity.end;
                    assignments[activity.index] = 'J';
                } else if (activity.start >= cEnd) {
                    cEnd = activity.end;
                    assignments[activity.index] = 'C';
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (int assignment : assignments) {
                    result.append((char) assignment);
                }
                System.out.println("Case #" + t + ": " + result.toString());
            }
        }
    }

    private static class Activity {
        int start;
        int end;
        int index;

        Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    private static class Kattio extends PrintWriter {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public Kattio(InputStream input) {
            super(new BufferedOutputStream(System.out));
            reader = new BufferedReader(new InputStreamReader(input));
        }

        public int getInt() {
            return Integer.parseInt(nextToken());
        }

        public double getDouble() {
            return Double.parseDouble(nextToken());
        }

        public long getLong() {
            return Long.parseLong(nextToken());
        }

        public String getWord() {
            return nextToken();
        }

        private String nextToken() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
    }
}