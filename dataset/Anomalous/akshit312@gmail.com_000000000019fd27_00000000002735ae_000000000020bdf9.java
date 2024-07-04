import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    void pre() throws Exception {}

    void solve(int TC) throws Exception {
        int t = ni();
        for (int ii = 0; ii < t; ii++) {
            int n = ni();
            int[][] intervals = new int[n][3];
            int[][] originalIntervals = new int[n][2];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = ni();
                intervals[i][1] = ni();
                originalIntervals[i][0] = intervals[i][0];
                originalIntervals[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            int curMaxC = 0, curMaxJ = 0, flag = 0;
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= curMaxC) {
                    intervals[i][2] = 1;
                    curMaxC = intervals[i][1];
                }
            }
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= curMaxJ && intervals[i][2] != 1) {
                    intervals[i][2] = -1;
                    curMaxJ = intervals[i][1];
                }
            }

            for (int i = 0; i < n; i++) {
                if (intervals[i][2] == 0) {
                    flag = -1;
                    break;
                }
            }

            StringBuilder result = new StringBuilder();
            if (flag == -1) {
                result.append("IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (originalIntervals[i][0] == intervals[j][0] && originalIntervals[i][1] == intervals[j][1]) {
                            result.append(intervals[j][2] == 1 ? 'C' : 'J');
                        }
                    }
                }
            }

            pn("Case #" + (ii + 1) + ": " + result.toString());
        }
    }

    static boolean multipleTC = false, memory = false;
    FastReader in;
    PrintWriter out;

    void run() throws Exception {
        in = new FastReader();
        out = new PrintWriter(System.out);
        int T = (multipleTC) ? ni() : 1;
        pre();
        for (int t = 1; t <= T; t++) solve(t);
        out.flush();
        out.close();
    }

    public static void main(String[] args) throws Exception {
        if (memory) {
            new Thread(null, new Runnable() {
                public void run() {
                    try {
                        new Solution().run();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, "1", 1 << 28).start();
        } else {
            new Solution().run();
        }
    }

    void p(Object o) { out.print(o); }
    void pn(Object o) { out.println(o); }
    String n() throws Exception { return in.next(); }
    int ni() throws Exception { return Integer.parseInt(in.next()); }

    class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws Exception {
            br = new BufferedReader(new FileReader(s));
        }

        String next() throws Exception {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new Exception(e.toString());
                }
            }
            return st.nextToken();
        }
    }
}