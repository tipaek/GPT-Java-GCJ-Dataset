import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.FilterInputStream;
import java.io.BufferedInputStream;
import java.util.Comparator;
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
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = in.scanInt();
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            out.print("Case #" + testNumber + ": ");
            int n = in.scanInt();
            int[][] ar = new int[2 * n][];
            for (int i = 0; i < n; i++) {
                ar[i * 2] = new int[]{in.scanInt(), i, 0};
                ar[i * 2 + 1] = new int[]{in.scanInt(), i, 1};
            }
            Arrays.sort(ar, new Comparator<int[]>() {

                public int compare(int[] o1, int[] o2) {
                    if (o1[0] == o2[0]) return -o1[2] + o2[2];
                    else return o1[0] - o2[0];
                }
            });
            int[] which = new int[2];
            Arrays.fill(which, -1);
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            for (int i = 0; i < 2 * n; i++) {
                if (ar[i][2] == 1) {
                    which[ans[ar[i][1]]] = -1;
                } else {
                    if (which[0] == -1) {
                        which[0] = ar[i][1];
                        ans[ar[i][1]] = 0;
                    } else if (which[1] == -1) {
                        which[1] = ar[i][1];
                        ans[ar[i][1]] = 1;
                    } else {
                        out.println("IMPOSSIBLE");
                        return;
                    }
                }
            }
            for (int i = 0; i < n; i++)
                if (ans[i] == 0) out.print("C");
                else out.print("J");
            out.println();
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

