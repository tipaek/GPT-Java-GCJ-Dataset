import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Pranay2516
 */
public class Solution{
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Parenting solver = new Parenting();
        solver.solve(1, in, out);
        out.close();
    }

    static class Parenting {
        public void solve(int testNumber, FastReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int q = 0; q < t; ++q) {
                int n = in.nextInt();
                boolean f = true;
                boolean c[] = new boolean[2000];
                boolean j[] = new boolean[2000];
                String str = "";
                Arrays.fill(c, true);
                Arrays.fill(j, true);
                out.print("Case #" + (q + 1) + ": ");
                while(n-->0){
                    int s = in.nextInt();
                    int e = in.nextInt();
                    if (!contains(j, s, e)) {
                        for (int k = s ; k < e; ++k) {
                            j[k] = false;
                        }
                        str += "J";
                    } else if (!contains(c, s, e)) {
                        for (int k = s ; k < e; ++k) {
                            c[k] = false;
                        }
                        str += "C";
                    } 
                    else {
                        f = false;
                    }
                }
                if (!f) out.print("IMPOSSIBLE");
                else out.print(str);
                if(q!=t-1)out.println();
            }
        }

        static boolean contains(boolean[] a, int s, int e) {
            for (int i = s; i <= e; ++i) {
                if (a[i] == false) return true;
            }
            return false;
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
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

        public boolean isSpaceChar(int c) {

            if (filter != null)
                return filter.isSpaceChar(c);

            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

