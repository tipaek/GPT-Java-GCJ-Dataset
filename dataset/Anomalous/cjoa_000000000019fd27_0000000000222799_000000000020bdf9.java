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

        for (int tc = 1; tc <= testCaseCount; ++tc) {
            int n = nextInt();
            Interval[] intervals = new Interval[n + 1];

            for (int i = 1; i <= n; ++i) {
                int startTime = nextInt();
                int endTime = nextInt();
                intervals[i] = new Interval(i - 1, startTime, endTime);
            }

            intervals[0] = new Interval(0, 0, 0);
            Arrays.sort(intervals);

            if (canSchedule(1, 0, 0, intervals, cached, memo, path, tc, n)) {
                char[] result = new char[n];
                for (int i = 1, c = 0, j = 0; i <= n; ++i) {
                    result[intervals[i].id] = path[c][j];
                    if (path[c][j] == 'C') {
                        c = i;
                    } else {
                        j = i;
                    }
                }
                out.printf("Case #%d: %s\n", tc, new String(result));
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", tc);
            }
        }
    }

    private boolean canSchedule(int currentIndex, int c, int j, Interval[] intervals, int[][] cached, boolean[][] memo, char[][] path, int testCase, int n) {
        if (currentIndex > n) {
            return true;
        }

        if (cached[c][j] != testCase) {
            cached[c][j] = testCase;

            if (intervals[currentIndex].startTime >= intervals[c].endTime) {
                if (canSchedule(currentIndex + 1, currentIndex, j, intervals, cached, memo, path, testCase, n)) {
                    path[c][j] = 'C';
                    return memo[c][j] = true;
                }
            }

            if (intervals[currentIndex].startTime >= intervals[j].endTime) {
                if (canSchedule(currentIndex + 1, c, currentIndex, intervals, cached, memo, path, testCase, n)) {
                    path[c][j] = 'J';
                    return memo[c][j] = true;
                }
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