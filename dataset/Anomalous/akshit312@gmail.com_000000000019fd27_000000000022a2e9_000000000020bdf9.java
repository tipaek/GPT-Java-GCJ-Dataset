import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    void pre() throws Exception {}

    void solve(int TC) throws Exception {
        int t = ni();
        for (int ii = 0; ii < t; ii++) {
            int n = ni();
            StringBuilder schedule = new StringBuilder("C");
            int cMaxEnd = ni(), cMinStart = cMaxEnd, jMaxEnd = 0, jMinStart = Integer.MAX_VALUE;
            int flag = 0;
            cMaxEnd = ni();
            for (int i = 1; i < n; i++) {
                int start = ni();
                int end = ni();
                if (start >= cMaxEnd) {
                    cMaxEnd = end;
                    schedule.append('C');
                } else if (start >= jMaxEnd) {
                    jMaxEnd = end;
                    schedule.append('J');
                } else {
                    flag = -1;
                }
            }
            if (flag == -1) {
                schedule = new StringBuilder("IMPOSSIBLE");
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
            new Thread(null, () -> {
                try {
                    new Solution().run();
                } catch (Exception e) {
                    e.printStackTrace();
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