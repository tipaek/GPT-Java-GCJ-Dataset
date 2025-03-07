import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Arrays;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * @author khokharnikunj8
 */

public class Solution {
    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            public void run() {
                new Solution().solve();
            }
        }, "1", 1 << 26).start();
    }

    void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Indicium solver = new Indicium();
        int testCount = in.scanInt();
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class Indicium {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            out.print("Case #" + testNumber + ": ");
            int n = in.scanInt();
            int k = in.scanInt() - n;
            HashSet<Integer> st = new HashSet<>();
            int[][] ar = new int[n][n];
            for (int i = 0; i < n; i++) Arrays.fill(ar[i], 1);
            for (int i = 0; i < n; i++) {
                boolean flag = false;
                for (int j = Math.min(k, n - 1); j >= 0; j--) {
                    int temp = (j - i);
                    if (temp < 0) temp += n;
                    if (st.contains(temp + 1)) continue;
                    k -= j;
                    for (int l = 0; l < n; l++) {
                        ar[i][l] += (temp + l);
                        if (ar[i][l] > n) ar[i][l] -= n;
                    }
                    st.add(ar[i][0]);
                    flag = true;
                    break;
                }
                if (!flag) {
                    out.println("IMPOSSIBLE");
                    return;
                }
            }
            if (k > 0) {
                out.println("IMPOSSIBLE");
                return;
            }
            out.println("POSSIBLE");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    out.print(ar[i][j] + " ");
                }
                out.println();
            }

        }

    }

    static class ScanReader {
        private byte[] buf = new byte[4 * 1024];
        private int index;
        private BufferedInputStream in;
        private int total;

        public ScanReader(InputStream inputStream) {
            in = new BufferedInputStream(inputStream);
        }

        private int scan() {
            if (index >= total) {
                index = 0;
                try {
                    total = in.read(buf);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (total <= 0) return -1;
            }
            return buf[index++];
        }

        public int scanInt() {
            int integer = 0;
            int n = scan();
            while (isWhiteSpace(n)) n = scan();
            int neg = 1;
            if (n == '-') {
                neg = -1;
                n = scan();
            }
            while (!isWhiteSpace(n)) {
                if (n >= '0' && n <= '9') {
                    integer *= 10;
                    integer += n - '0';
                    n = scan();
                }
            }
            return neg * integer;
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

