import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.SplittableRandom;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        B_BlindfoldedBullseye solver = new B_BlindfoldedBullseye();
        solver.solve(1, in, out);
        out.close();
    }

    static class B_BlindfoldedBullseye {
        FastScanner in;
        PrintWriter out;
        SplittableRandom random = new SplittableRandom(0);
        final int R = (int) 1e9;
        final int CENTER = 0;
        final int HIT = 1;
        final int MISS = 2;

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            this.in = in;
            this.out = out;
            int numTests = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                solveOne();
            }
        }

        private void solveOne() {
            int anyX;
            int anyY;
            while (true) {
                anyX = random.nextInt(-R, R + 1);
                anyY = random.nextInt(-R, R + 1);
                int r = ask(anyX, anyY);
                if (r == CENTER) {
                    return;
                }
                if (r == HIT) {
                    break;
                }
            }

            int leftX;
            int leftY;
            int rightX;
            int rightY;
            {
                int l = -R - 1;
                int r = anyX;
                while (r - l > 1) {
                    int m = l + (r - l) / 2;
                    int u = ask(m, anyY);
                    if (u == CENTER) {
                        return;
                    }
                    if (u == HIT) {
                        r = m;
                    } else {
                        l = m;
                    }
                }
                leftX = r;
            }
            {
                int l = -R - 1;
                int r = anyY;
                while (r - l > 1) {
                    int m = l + (r - l) / 2;
                    int u = ask(anyX, m);
                    if (u == CENTER) {
                        return;
                    }
                    if (u == HIT) {
                        r = m;
                    } else {
                        l = m;
                    }
                }
                leftY = r;
            }
            {
                int l = anyX;
                int r = R + 1;
                while (r - l > 1) {
                    int m = l + (r - l) / 2;
                    int u = ask(m, anyY);
                    if (u == CENTER) {
                        return;
                    }
                    if (u == HIT) {
                        l = m;
                    } else {
                        r = m;
                    }
                }
                rightX = l;
            }
            {
                int l = anyY;
                int r = R + 1;
                while (r - l > 1) {
                    int m = l + (r - l) / 2;
                    int u = ask(anyX, m);
                    if (u == CENTER) {
                        return;
                    }
                    if (u == HIT) {
                        l = m;
                    } else {
                        r = m;
                    }
                }
                rightY = l;
            }

            int cx = leftX + (rightX - leftX) / 2;
            int cy = leftY + (rightY - leftY) / 2;
            if (ask(cx, cy) != CENTER) {
                throw new AssertionError("WA");
            }
        }

        private int ask(int x, int y) {
            out.println(x + " " + y);
            out.flush();
            String ret = in.next();
            if (ret.equals("CENTER")) {
                return CENTER;
            }
            if (ret.equals("HIT")) {
                return HIT;
            }
            if (ret.equals("MISS")) {
                return MISS;
            }
            throw new AssertionError();
        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

