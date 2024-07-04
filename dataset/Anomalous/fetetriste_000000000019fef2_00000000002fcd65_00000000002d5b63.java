import java.io.*;
import java.util.StringTokenizer;
import java.util.SplittableRandom;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BlindfoldedBullseye solver = new BlindfoldedBullseye();
        solver.solve(1, in, out);
        out.close();
    }

    static class BlindfoldedBullseye {
        private FastScanner in;
        private PrintWriter out;
        private final SplittableRandom random = new SplittableRandom(0);
        private static final int R = (int) 1e9;
        private static final int CENTER = 0;
        private static final int HIT = 1;
        private static final int MISS = 2;

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
            int anyX, anyY;
            while (true) {
                anyX = random.nextInt(-R, R + 1);
                anyY = random.nextInt(-R, R + 1);
                int response = ask(anyX, anyY);
                if (response == CENTER) return;
                if (response == HIT) break;
            }

            int leftX = binarySearch(anyX, anyY, true, true);
            int leftY = binarySearch(anyX, anyY, false, true);
            int rightX = binarySearch(anyX, anyY, true, false);
            int rightY = binarySearch(anyX, anyY, false, false);

            int cx = leftX + (rightX - leftX) / 2;
            int cy = leftY + (rightY - leftY) / 2;
            if (ask(cx, cy) != CENTER) {
                throw new AssertionError("Wrong Answer");
            }
        }

        private int binarySearch(int fixedCoord, int variableCoord, boolean isX, boolean isLeft) {
            int l = isLeft ? -R - 1 : fixedCoord;
            int r = isLeft ? fixedCoord : R + 1;
            while (r - l > 1) {
                int m = l + (r - l) / 2;
                int response = isX ? ask(m, variableCoord) : ask(fixedCoord, m);
                if (response == CENTER) return m;
                if (response == HIT) {
                    if (isLeft) r = m;
                    else l = m;
                } else {
                    if (isLeft) l = m;
                    else r = m;
                }
            }
            return isLeft ? r : l;
        }

        private int ask(int x, int y) {
            out.println(x + " " + y);
            out.flush();
            String response = in.next();
            switch (response) {
                case "CENTER":
                    return CENTER;
                case "HIT":
                    return HIT;
                case "MISS":
                    return MISS;
                default:
                    throw new AssertionError();
            }
        }
    }

    static class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}