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
            int[][] original = new int[n][2];

            for (int i = 0; i < n; i++) {
                intervals[i][0] = ni();
                intervals[i][1] = ni();
                original[i][0] = intervals[i][0];
                original[i][1] = intervals[i][1];
            }

            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            int curMaxC = 0;
            int curMaxJ = 0;
            boolean possible = true;
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= curMaxC) {
                    intervals[i][2] = 1; // Assign to C
                    curMaxC = intervals[i][1];
                } else if (intervals[i][0] >= curMaxJ) {
                    intervals[i][2] = -1; // Assign to J
                    curMaxJ = intervals[i][1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (original[i][0] == intervals[j][0] && original[i][1] == intervals[j][1]) {
                            if (intervals[j][2] == 1) schedule.append('C');
                            else schedule.append('J');
                            break;
                        }
                    }
                }
            } else {
                schedule.append("IMPOSSIBLE");
            }

            pn("Case #" + (ii + 1) + ": " + schedule.toString());
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

    void p(Object o) {
        out.print(o);
    }

    void pn(Object o) {
        out.println(o);
    }

    String n() throws Exception {
        return in.next();
    }

    int ni() throws Exception {
        return Integer.parseInt(in.next());
    }

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
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
    }
}