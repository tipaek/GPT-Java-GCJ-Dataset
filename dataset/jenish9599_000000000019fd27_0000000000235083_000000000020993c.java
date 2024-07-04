import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
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
        Vestigum solver = new Vestigum();
        solver.solve(1, in, out);
        out.close();
    }

    static class Vestigum {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int t = in.scanInt();
            int cases = 1;
            while (t-- > 0) {
                int n = in.scanInt();
                int mat[][] = new int[n][n];
                long sum = 0;
                int row = 0;
                int col = 0;
                for (int i = 0; i < n; i++) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = in.scanInt();
                        if (i == j) sum += mat[i][j];
                        hashSet.add(mat[i][j]);
                    }
                    if (hashSet.size() != n) row++;
                }


                for (int j = 0; j < n; j++) {
                    HashSet<Integer> hashSet = new HashSet<>();
                    for (int i = 0; i < n; i++) {
                        hashSet.add(mat[i][j]);
                    }
                    if (hashSet.size() != n) col++;
                }

                out.print("Case #" + cases++ + ": ");
                out.println(sum + " " + row + " " + col);
            }
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

