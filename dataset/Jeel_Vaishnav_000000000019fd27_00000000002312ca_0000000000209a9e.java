import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jeel Vaishnav
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ESAbATAd solver = new ESAbATAd();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ESAbATAd {
        int query = 0;

        int query(int ind, InputReader sc) {
            query++;
            System.out.println((ind + 1));
            System.out.flush();
            return sc.nextInt();
        }

        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int n = sc.nextInt();

            int bits[] = new int[n];
            Arrays.fill(bits, -1);

            int dist = 0;
            query = 0;
            int reqDist = (n - 1) / 2 + 1;
            while (dist < reqDist) {
                if (query % 10 == 0 && dist > 0) {
                    int comp = 0;
                    for (int i = 0; i < dist; ++i) {
                        if (bits[i] == bits[n - 1 - i]) {
                            int val = query(i, sc);
                            if (val == (bits[i] ^ 1)) {
                                comp = 1;
                            }
                            break;
                        }
                    }

                    if (comp == 1) {
                        for (int i = 0; i < dist; ++i) {
                            bits[i] ^= 1;
                            bits[n - 1 - i] ^= 1;
                        }
                    }

                    int rev = 0;
                    for (int i = 0; i < dist; ++i) {
                        if (bits[i] != bits[n - 1 - i]) {
                            int val = query(i, sc);
                            if (val == bits[n - 1 - i]) {
                                rev = 1;
                            }
                            break;
                        }
                    }

                    if (rev == 1) {
                        for (int i = 0; i < dist; ++i) {
                            bits[i] ^= bits[n - 1 - i];
                            bits[n - 1 - i] ^= bits[i];
                            bits[i] ^= bits[n - 1 - i];
                        }
                    }

                    if (query % 10 == 0)
                        query(0, sc);
                    if (query % 10 == 1)
                        query(0, sc);
                } else {
                    if (dist == n - 1 - dist) {
                        bits[dist] = query(dist, sc);
                        dist++;
                        break;
                    } else {
                        bits[dist] = query(dist, sc);
                        bits[n - 1 - dist] = query(n - 1 - dist, sc);
                        dist++;
                    }
                }
            }

            for (int i = 0; i < n; ++i)
                System.out.print(bits[i]);
            System.out.println();
            System.out.flush();
            
            sc.next();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

