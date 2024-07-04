import java.io.*;
import java.util.*;

class Interval implements Comparable<Interval> {
    public int id, startTime, endTime;

    public Interval(int id, int s, int e) {
        this.id = id;
        this.startTime = s;
        this.endTime = e;
    }

    @Override
    public int compareTo(Interval other) {
        return Integer.compare(this.startTime, other.startTime);
    }
}

public class C {
    public static void main(String[] args) throws IOException {
        new C().run();
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

        int TC = nextInt();
        for (int tc = 1; tc <= TC; ++tc) {
            int N = nextInt();
            Interval[] intervals = new Interval[N + 1];
            for (int i = 1; i <= N; ++i) {
                int s = nextInt();
                int t = nextInt();
                intervals[i] = new Interval(i - 1, s, t);
            }
            intervals[0] = new Interval(0, 0, 0);
            Arrays.sort(intervals);

            if (go(1, 0, 0, N, intervals, cached, memo, path, tc)) {
                char[] res = new char[N];
                for (int n = 1, c = 0, j = 0; n <= N; ++n) {
                    res[intervals[n].id] = path[c][j];
                    if (path[c][j] == 'C') {
                        c = n;
                    } else {
                        j = n;
                    }
                }
                out.printf("Case #%d: %s\n", tc, new String(res));
            } else {
                out.printf("Case #%d: IMPOSSIBLE\n", tc);
            }
        }
    }

    private boolean go(int n, int c, int j, int N, Interval[] intervals, int[][] cached, boolean[][] memo, char[][] path, int tc) {
        if (n > N) return true;
        if (cached[c][j] != tc) {
            cached[c][j] = tc;
            if (intervals[n].startTime >= intervals[c].endTime) {
                if (go(n + 1, n, j, N, intervals, cached, memo, path, tc)) {
                    path[c][j] = 'C';
                    return memo[c][j] = true;
                }
            }
            if (intervals[n].startTime >= intervals[j].endTime) {
                if (go(n + 1, c, n, N, intervals, cached, memo, path, tc)) {
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