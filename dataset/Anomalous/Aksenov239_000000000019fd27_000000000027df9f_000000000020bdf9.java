import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        new Solution().run();
    }

    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter out;

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private static class Time implements Comparable<Time> {
        int c, e, id;

        Time(int c, int e, int id) {
            this.c = c;
            this.e = e;
            this.id = id;
        }

        @Override
        public int compareTo(Time other) {
            return Integer.compare(this.c, other.c);
        }
    }

    private void solve() throws IOException {
        int n = nextInt();
        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            times[i] = new Time(nextInt(), nextInt(), i);
        }

        char[] result = new char[n];
        Arrays.sort(times);
        int[] lastEnd = {-1, -1};

        for (Time time : times) {
            if (lastEnd[0] <= time.c) {
                lastEnd[0] = time.e;
                result[time.id] = 'C';
            } else if (lastEnd[1] <= time.c) {
                lastEnd[1] = time.e;
                result[time.id] = 'J';
            } else {
                out.println("IMPOSSIBLE");
                return;
            }
        }
        out.println(new String(result));
    }

    private void run() {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);

            int t = nextInt();
            for (int i = 0; i < t; i++) {
                out.printf("Case #%d: ", i + 1);
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}