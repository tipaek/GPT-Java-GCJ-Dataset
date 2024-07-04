import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Solution {
    private static final FastReader in = new FastReader();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static class Pair implements Comparable<Pair> {
        int start, end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.start != other.start) {
                return this.start - other.start;
            } else {
                return this.end - other.end;
            }
        }
    }

    public static void main(String[] args) {
        int t = in.nextInt();
        StringBuilder result = new StringBuilder();
        ArrayList<Pair> activities;
        int cameronEnd = 0, jamieEnd = 0, n;
        boolean impossible;

        for (int i = 1; i <= t; i++) {
            n = in.nextInt();
            activities = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new Pair(start, end));
            }
            Collections.sort(activities);

            StringBuilder schedule = new StringBuilder();
            impossible = false;
            cameronEnd = jamieEnd = 0;

            for (Pair activity : activities) {
                if (activity.getStart() >= cameronEnd) {
                    schedule.append('C');
                    cameronEnd = activity.getEnd();
                } else if (activity.getStart() >= jamieEnd) {
                    schedule.append('J');
                    jamieEnd = activity.getEnd();
                } else {
                    impossible = true;
                    break;
                }
            }

            if (impossible) {
                result.append(String.format("Case #%d: IMPOSSIBLE\n", i));
            } else {
                result.append(String.format("Case #%d: %s\n", i, schedule));
            }
        }

        out.print(result.toString());
        out.flush();
    }

    private static class FastReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
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