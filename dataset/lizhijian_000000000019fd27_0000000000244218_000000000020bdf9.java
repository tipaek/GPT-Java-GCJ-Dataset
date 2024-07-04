import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task task = new Task();
        task.solve(in, out);
        out.close();
    }

    static class Activity implements Comparable<Activity> {
        public int s;
        public int e;
        
        public Activity(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Activity that) {
            if (this.s < that.s) { return -1; }
            if (this.s > that.s) { return 1; }
            if (this.e > that.e) { return -1; }
            if (this.e < that.e) { return 1; }
            return 0;
        }
    }

    static class Task {
        public void solve(InputReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int k = 1; k <= t; ++k) {
                int n = in.nextInt();
                Activity[] activities = new Activity[n];
                for (int i = 0; i < n; ++i) {
                    int s = in.nextInt(), e = in.nextInt();
                    activities[i] = new Activity(s, e);
                }
                Arrays.sort(activities);
                int c = 0, j = 0;
                StringBuilder ans = new StringBuilder();
                for (int i = 0; i < n; ++i) {
                    if (activities[i].s >= c) {
                        ans.append('C');
                        c = activities[i].e;
                    } else if (activities[i].s >= j) {
                        ans.append('J');
                        j = activities[i].e;
                    } else {
                        ans = new StringBuilder("IMPOSSIBLE");
                        break;
                    }
                }
                out.printf("Case #%d: %s\n", k, ans.toString());
            }
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
        public int nextInt() { return Integer.parseInt(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
