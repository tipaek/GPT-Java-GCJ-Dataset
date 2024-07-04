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

    private class Time implements Comparable<Time> {
        int start, end, index;

        Time(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Time other) {
            return Integer.compare(this.start, other.start);
        }
    }

    private void solve() throws IOException {
        int n = nextInt();
        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            times[i] = new Time(nextInt(), nextInt(), i);
        }

        Arrays.sort(times);
        char[] result = new char[n];
        int[] lastEndTime = {-1, -1};

        for (Time time : times) {
            if (lastEndTime[0] <= time.start) {
                lastEndTime[0] = time.end;
                result[time.index] = 'C';
            } else if (lastEndTime[1] <= time.start) {
                lastEndTime[1] = time.end;
                result[time.index] = 'J';
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

            int testCases = nextInt();
            for (int i = 0; i < testCases; i++) {
                out.print(String.format("Case #%d: ", i + 1));
                solve();
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}