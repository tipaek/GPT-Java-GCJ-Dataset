
import java.util.*;
import java.io.*;

/**
 *
 * @author usquare
 */

public class Solution {

    static int mod = (int) (1e9+7);
    static InputReader in;
    static PrintWriter out;
    static boolean file = false;

    public static void main(String[] args) {

        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        int t = in.ni();

        for(int ta = 1; ta <= t; ta++){
            int n = in.ni();
            int[][] arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    arr[i][j] = in.ni();
            }
            int k = 0;
            for(int i = 0; i < n; i++)
                k += arr[i][i];
            int r = 0;
            int c = 0;

            boolean[] vis = new boolean[n + 1];

            for(int i = 0; i < n; i++) {
                Arrays.fill(vis, false);
                for(int j = 0; j < n; j++) {
                    if(vis[arr[i][j]]) {
                        r++;
                        break;
                    }
                    vis[arr[i][j]] = true;
                }
            }

            for(int i = 0; i < n; i++) {
                Arrays.fill(vis, false);
                for(int j = 0; j < n; j++) {
                    if(vis[arr[j][i]]) {
                        c++;
                        break;
                    }
                    vis[arr[j][i]] = true;
                }
            }

            out.println("Case #"+ta+": " + k + " " + r + " " + c);
        }

        out.close();
    }

    static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int ni() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nl() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nIArr(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        public long[] nLArr(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }

    }
}
