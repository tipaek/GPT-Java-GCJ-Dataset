import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        CJB1 solver = new CJB1();
        solver.solve(1, in, out);
        out.close();
    }

    static class CJB1 {
        int zero = 101;
        boolean[][][][] dp = new boolean[64][4][300][300];

        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int t = in.scanInt();


            dp[0][0][zero + 1][zero] = true;
            dp[0][1][zero - 1][zero] = true;
            dp[0][2][zero][zero + 1] = true;
            dp[0][3][zero][zero - 1] = true;


            for (int i = 1; i < 60; i++) {
                for (int p = 0; p < 300; p++) {
                    for (int q = 0; q < 300; q++) {
                        for (int j = 0; j < 4; j++) {
                            if (dp[i - 1][j][p][q]) {
                                if (p + (1l << i) < 300) dp[i][0][p + (1 << i)][q] = true;
                                if (p - (1l << i) >= 0) dp[i][1][p - (1 << i)][q] = true;
                                if (q + (1l << i) < 300) dp[i][2][p][q + (1 << i)] = true;
                                if (q - (1l << i) >= 0) dp[i][3][p][q - (1 << i)] = true;
                            }
                        }
                    }
                }
            }
            for (int i = 1; i <= t; i++) {
                out.print("Case #" + i + ": ");
                solveIt(in, out, t);
            }
        }

        void solveIt(ScanReader in, PrintWriter out, int testNumber) {

            int x = in.scanInt();
            int y = in.scanInt();
            if (x == 0 && y == 0) {
                out.println();
            }
            int len = 0;

            boolean flag = false;


            for (int j = 0; j <= 60; j++) {
                if (dp[j][0][zero + x][zero + y]) {
                    flag = true;
                    len = j;
                    break;
                }
                if (dp[j][1][zero + x][zero + y]) {
                    flag = true;
                    len = j;
                    break;
                }
                if (dp[j][2][zero + x][zero + y]) {
                    flag = true;
                    len = j;
                    break;
                }
                if (dp[j][3][zero + x][zero + y]) {
                    flag = true;
                    len = j;
                    break;
                }
            }
            if (!flag) {
                out.println("IMPOSSIBLE");
                return;
            }


            char ans[] = new char[len + 1];
            int ptr = len;
            while (ptr >= 0) {
                int index = -1;
                for (int i = 0; i < 4; i++) if (dp[len][i][zero + x][zero + y]) index = i;
                if (index == -1) throw new RuntimeException();
                if (index == 0) {
                    ans[ptr] = 'E';
                    x -= (1 << ptr);
                } else if (index == 1) {
                    ans[ptr] = 'W';
                    x += (1 << ptr);
                } else if (index == 2) {
                    ans[ptr] = 'N';
                    y -= (1 << ptr);
                } else {
                    ans[ptr] = 'S';
                    y += (1 << ptr);
                }
                ptr--;
            }

            out.println(String.valueOf(ans));
        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int INDEX;
        private BufferedInputStream in;
        private int TOTAL;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (INDEX >= TOTAL) {
                INDEX = 0;
                try {
                    TOTAL = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (TOTAL <= 0) return -1;
            }
            return buf[INDEX++];
        }

        public int scanInt() {
            int I = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    I *= 10;
                    I += n - '0';
                    n = scan();
                }
            }
            return neg * I;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

