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
        NESTING_DEPTH solver = new NESTING_DEPTH();
        solver.solve(1, in, out);
        out.close();
    }

    static class NESTING_DEPTH {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            int t = in.scanInt();
            int cases = 1;
            while (t-- > 0) {
                char arr[] = in.scanString().toCharArray();
                StringBuffer ans = new StringBuffer();
                int sum = 0;

                for (int i = 0; i < arr.length; i++) {
                    int x = arr[i] - '0';
                    if (x == sum) {
                        ans.append(x);
                    } else if (x < sum) {
                        while (sum != x) {
                            ans.append(')');
                            sum--;
                        }
                        ans.append(x);
                    } else {
                        while (sum != x) {
                            ans.append('(');
                            sum++;
                        }
                        ans.append(x);
                    }
                }

                while (sum > 0) {
                    ans.append(')');
                    sum--;
                }

                out.print("Case #" + cases++ + ": ");
                out.println(ans.toString());

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

        public String scanString() {
            int c = scan();
            while (isWhiteSpace(c)) c = scan();
            StringBuilder RESULT = new StringBuilder();
            do {
                RESULT.appendCodePoint(c);
                c = scan();
            } while (!isWhiteSpace(c));
            return RESULT.toString();
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

