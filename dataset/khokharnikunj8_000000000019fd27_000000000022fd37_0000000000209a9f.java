import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
                new Main().solve();
            }
        }, "1", 1 << 26).start();
    }

    void solve() {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        ScanReader in = new ScanReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        NestingDepth solver = new NestingDepth();
        int testCount = in.scanInt();
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class NestingDepth {
        public void solve(int testNumber, ScanReader in, PrintWriter out) {
            out.print("Case #" + testNumber + ": ");
            String s = in.scanString();
            StringBuilder sb = new StringBuilder();
            int depth = 0;
            for (char c : s.toCharArray()) {
                while (depth > c - '0') {
                    sb.append(')');
                    depth--;
                }
                while (depth < c - '0') {
                    sb.append('(');
                    depth++;

                }
                sb.append(c);
            }
            while (depth > 0) {
                sb.append(')');
                depth--;
            }
            out.println(sb.toString());
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

        public String scanString() {
            int c = scan();
            if (c == -1) return null;
            while (isWhiteSpace(c)) c = scan();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = scan();
            } while (!isWhiteSpace(c));
            return res.toString();
        }

        private boolean isWhiteSpace(int n) {
            if (n == ' ' || n == '\n' || n == '\r' || n == '\t' || n == -1) return true;
            else return false;
        }

    }
}

