import java.io.*;
import java.util.*;
import static java.lang.Math.*;

public class Solution implements Runnable {
    private boolean multiple = true;
    private long MOD;
    private boolean set = false;
    private long[][] nck = new long[600][600];
    private int caseNum = 0;
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
            if (multiple) {
                int q = sc.nextInt();
                for (int i = 0; i < q; i++) solve();
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

    private long nck(int n, int k) {
        if (n == k || k == 0) return 1;
        if (nck[n][k] != -1) return nck[n][k];
        return nck[n][k] = (n * nck(n - 1, k - 1)) / k;
    }

    private void solve() throws Exception {
        caseNum++;
        printLine("Case #" + caseNum + ": ");
        if (!set) {
            for (int i = 0; i < nck.length; i++) {
                Arrays.fill(nck[i], -1);
            }
            set = true;
        }
        long n = sc.nextLong();
        long curr = 1;
        int i = 1, j = 1;
        printLine(i + " " + j);
        while (curr < n) {
            if (i <= 2 || n - curr < i - 1) {
                i++;
                curr++;
                printLine(i + " " + j);
            } else {
                long returnCost = 2;
                for (int furthest = 2; furthest <= i + 1; furthest++) {
                    returnCost += nck(i - 1, furthest - 1) + nck(i, furthest - 1);
                    if (furthest == i + 1 || returnCost + curr > n) {
                        furthest--;
                        for (int k = 2; k <= furthest; k++) {
                            curr += nck(i - 1, k - 1);
                            printLine(i + " " + k);
                        }
                        i++;
                        for (int k = furthest; k >= 1; k--) {
                            curr += nck(i - 1, k - 1);
                            printLine(i + " " + k);
                        }
                        i++;
                        j = 1;
                        printLine(i + " " + j);
                        curr++;
                        break;
                    }
                }
            }
        }
    }

    private void print(Object s) {
        ANS.append(s);
    }

    private void printLine(Object s) {
        ANS.append(s).append('\n');
    }

    private static class FastScanner {
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