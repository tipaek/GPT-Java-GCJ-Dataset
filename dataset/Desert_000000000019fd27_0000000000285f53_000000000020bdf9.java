import java.io.*;
import java.util.*;

public class Solution {

    private static class Activity {
        int start;
        int end;
        int index;
        char ch;

        public Activity(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    private String getAns(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparing(o -> o.end));

        int fEnd = Integer.MAX_VALUE;
        int sEnd = Integer.MAX_VALUE;
        for (int i = activities.length - 1; i >= 0; i--) {
            final Activity act = activities[i];
            if (act.end <= fEnd) {
                fEnd = act.start;
                act.ch = 'C';
            } else if (act.end <= sEnd) {
                sEnd = act.start;
                act.ch = 'J';
            } else {
                return "IMPOSSIBLE";
            }

        }

        Arrays.sort(activities, Comparator.comparingInt(o -> o.index));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < activities.length; i++) {
            sb.append(activities[i].ch);
        }

        return sb.toString();
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
                Activity activity = new Activity(start, end, j);
                activities[j] = activity;
            }

            writeTestCase(out, i + 1, new Solution().getAns(activities));
        }

        out.close();
    }

    static void writeTestCase(PrintWriter writer, int num, Object res) {
        writer.println(String.format("Case #%d: %s", num, res.toString()));
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextIntArr(int n) {
            int[] arr = new int[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextInt();
            }

            return arr;
        }

        public long[] nextLongArr(int n) {
            long[] arr = new long[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextLong();
            }

            return arr;
        }

        public double[] nextDoubleArr(int n) {
            double[] arr = new double[n];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = nextDouble();
            }

            return arr;
        }
    }
}