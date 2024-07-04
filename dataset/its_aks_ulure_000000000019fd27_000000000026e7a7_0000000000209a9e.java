import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Task solver = new Task();
        solver.solve(1, in, out);
        out.close();
    }

    static class Task {
        PrintWriter out;
        InputReader in;

        public void solve(int testNumber, InputReader in, PrintWriter out) {
            this.out = out;
            this.in = in;
            int t = ni();
            while (t-- > 0) {
                int b = ni();
                int q = 150, i = 0;
                int[] bit = new int[b];
                int[] freq = new int[1 << 11];
                for (i = 0; i < 150; i++) {
                    if (i % 10 == 0)
                        bit = new int[b];
                    System.out.println(i % 10 + 1);
                    System.out.flush();
                    bit[i % 10] = ni();
                    if (i % 10 == 9) {
                        int len = 9;
                        int sum = 0;
                        for (int j = 0; j < 10; j++, len--)
                            sum += (1 << len) * bit[j];
                        freq[sum]++;
                    }
                }
                int max = 0, id = 0;
                for (i = 0; i < 1 << 11; i++) {
                    if (freq[i] > max) {
                        id = i;
                        max = freq[i];
                    }
                }
                String s = Integer.toBinaryString(id);
                for (i = 0; i < 10 - s.length(); i++)
                    s = '0' + s;
                System.out.println(s);
                System.out.flush();
                char c = n().charAt(0);
                if (c == 'N')
                    break;
            }

        }

        String n() {
            return in.next();
        }

        int ni() {
            return in.nextInt();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new UnknownError();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new UnknownError();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuffer res = new StringBuffer();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));

            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

