import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashSet;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Spandan Mishra
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Vestigium solver = new Vestigium();
        solver.solve(1, in, out);
        out.close();
    }

    static class Vestigium {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.readInt();
            testNumber = 1;
            StringBuilder sb = new StringBuilder();
            while (T-- > 0) {
                int n = in.readInt();
                int[][] a = new int[n][n];

                for (int i = 0; i < n; i++)
                    for (int j = 0; j < n; j++)
                        a[i][j] = in.readInt();

                int[] res = getInfo(a, n);
                sb.append("Case #" + testNumber++ + ": " + res[0] + " " + res[1] + " " + res[2] + "\n");

            }
            System.out.println(sb);
        }

        int[] getInfo(int[][] a, int n) {
            int[] res = new int[3];
            res[0] = diagonalSum(a, n);

            // duplicate row check
            res[1] = dup(a, n, 0);

            //duplicate col check
            res[2] = dup(a, n, 1);

            return res;

        }

        int diagonalSum(int[][] a, int n) {
            int sum = 0;
            for (int i = 0; i < n; i++)
                sum += a[i][i];

            return sum;
        }

        int dup(int[][] a, int n, int ch) {
            int res = 0;
            if (ch == 0) { //row
                for (int i = 0; i < n; i++) {
                    HashSet<Integer> set = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (!set.contains(a[i][j]))
                            set.add(a[i][j]);
                        else {
                            res++;
                            break;
                        }
                    }
                }

            } else { //col
                for (int i = 0; i < n; i++) {
                    HashSet<Integer> set = new HashSet<>();
                    for (int j = 0; j < n; j++) {
                        if (!set.contains(a[j][i]))
                            set.add(a[j][i]);
                        else {
                            res++;
                            break;
                        }
                    }
                }

            }

            return res;
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
                throw new RuntimeException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

