import java.io.*;
import java.util.*;

public class Solution implements Runnable {
    private static final boolean MULTIPLE = true;
    private static final long MOD = 0; // Assuming MOD is set somewhere else
    private int caseNum = 1;
    private StringBuilder ANS = new StringBuilder();
    private BufferedReader in;
    private FastScanner sc;
    private PrintWriter out;
    private static Throwable uncaught;

    public static void main(String[] args) throws Throwable {
        Thread thread = new Thread(null, new Solution(), "", (1 << 26));
        thread.start();
        thread.join();
        if (uncaught != null) {
            throw uncaught;
        }
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            sc = new FastScanner(in);
            if (MULTIPLE) {
                int q = sc.nextInt();
                for (int i = 0; i < q; i++) {
                    solve();
                }
            } else {
                solve();
            }
            System.out.print(ANS);
        } catch (Throwable uncaught) {
            Solution.uncaught = uncaught;
        } finally {
            out.close();
        }
    }

    private void solve() throws Exception {
        String s = sc.nextToken();
        StringBuilder ans = new StringBuilder();
        int n = s.length(), prev = 0;

        for (int i = 0; i < n; i++) {
            int current = s.charAt(i) - '0';
            if (current < prev) {
                for (int j = 0; j < prev - current; j++) {
                    ans.append(')');
                }
            }
            if (current > prev) {
                for (int j = 0; j < current - prev; j++) {
                    ans.append('(');
                }
            }
            ans.append(s.charAt(i));
            prev = current;
        }

        for (int i = 0; i < prev; i++) {
            ans.append(')');
        }

        ANS.append("Case #").append(caseNum).append(": ").append(ans).append('\n');
        caseNum++;
    }

    private void p(Object s) {
        ANS.append(s);
    }

    private void p(double s) {
        ANS.append(s);
    }

    private void p(long s) {
        ANS.append(s);
    }

    private void p(char s) {
        ANS.append(s);
    }

    private void pl(Object s) {
        ANS.append(s).append('\n');
    }

    private void pl(double s) {
        ANS.append(s).append('\n');
    }

    private void pl(long s) {
        ANS.append(s).append('\n');
    }

    private void pl(char s) {
        ANS.append(s).append('\n');
    }

    private void pl() {
        ANS.append('\n');
    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(BufferedReader in) {
            this.in = in;
        }

        public String nextToken() throws Exception {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            return st.nextToken();
        }

        public int nextInt() throws Exception {
            return Integer.parseInt(nextToken());
        }

        public long nextLong() throws Exception {
            return Long.parseLong(nextToken());
        }

        public double nextDouble() throws Exception {
            return Double.parseDouble(nextToken());
        }
    }
}