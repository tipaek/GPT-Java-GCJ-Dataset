import java.io.*;
import java.util.*;

public class Solution {

    private static class Activity {
        int start;
        int end;
        int index;
        char assignedPerson;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    private String getSchedule(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

        int cEnd = 0;
        int jEnd = 0;
        for (Activity activity : activities) {
            if (activity.start >= cEnd) {
                cEnd = activity.end;
                activity.assignedPerson = 'C';
            } else if (activity.start >= jEnd) {
                jEnd = activity.end;
                activity.assignedPerson = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }

        Arrays.sort(activities, Comparator.comparingInt(a -> a.index));
        StringBuilder schedule = new StringBuilder();
        for (Activity activity : activities) {
            schedule.append(activity.assignedPerson);
        }

        return schedule.toString();
    }

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        int testCount = in.nextInt();
        for (int i = 0; i < testCount; i++) {
            int n = in.nextInt();
            Activity[] activities = new Activity[n];
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities[j] = new Activity(start, end, j);
            }

            String result = new Solution().getSchedule(activities);
            out.printf("Case #%d: %s%n", i + 1, result);
        }

        out.close();
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] nextLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public double[] nextDoubleArray(int n) {
            double[] array = new double[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextDouble();
            }
            return array;
        }
    }
}