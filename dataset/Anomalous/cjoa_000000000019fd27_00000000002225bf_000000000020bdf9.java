import java.io.*;
import java.util.*;

class Interval implements Comparable<Interval> {
    public int id, startTime, endTime;

    public Interval(int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer st = new StringTokenizer("");

    private void run() throws IOException {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (Exception e) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        solve();
        out.close();
    }

    private void solve() throws IOException {
        int[][] cached = new int[1001][1001];
        boolean[][] memo = new boolean[1001][1001];
        char[][] path = new char[1001][1001];

        int testCaseCount = nextInt();
        for (int testCase = 1; testCase <= testCaseCount; ++testCase) {
            int intervalCount = nextInt();
            Interval[] intervals = new Interval[intervalCount + 1];
            for (int i = 1; i <= intervalCount; ++i) {
                int startTime = nextInt();
                int endTime = nextInt();
                intervals[i] = new Interval(i - 1, startTime, endTime);
            }
            intervals[0] = new Interval(0, 0, 0);
            Arrays.sort(intervals);

            if (canSchedule(1, 0, 0, intervals, cached, memo, path, testCase, intervalCount)) {
                char[] result = new char[intervalCount];
                for (int n = 1, c = 0, j = 0; n <= intervalCount; ++n) {
                    result[intervals[n].id] = path[c][j];
                    if (path[c][j] == 'C') {
                        c = n;
                    } else {
                        j = n;
                    }
                }
                out.printf("Case #%d: %s\n", testCase, new String(result));
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", testCase);
            }
        }
    }

    private boolean canSchedule(int n, int c, int j, Interval[] intervals, int[][] cached, boolean[][] memo, char[][] path, int testCase, int intervalCount) {
        if (n > intervalCount) {
            return true;
        }
        if (cached[c][j] != testCase) {
            cached[c][j] = testCase;
            if (intervals[n].startTime >= intervals[c].endTime && canSchedule(n + 1, n, j, intervals, cached, memo, path, testCase, intervalCount)) {
                path[c][j] = 'C';
                return memo[c][j] = true;
            }
            if (intervals[n].startTime >= intervals[j].endTime && canSchedule(n + 1, c, n, intervals, cached, memo, path, testCase, intervalCount)) {
                path[c][j] = 'J';
                return memo[c][j] = true;
            }
        }
        return memo[c][j] = false;
    }

    private String next() throws IOException {
        while (!st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}