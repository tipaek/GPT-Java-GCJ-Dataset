import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int T = in.nextInt();

        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            int K = in.nextInt();

            System.out.print("Case #" + (t + 1) + ": ");
            if (isPossible(N, K)) {
                System.out.println("POSSIBLE");
                printMatrix(N, K);
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    private static boolean isPossible(int N, int K) {
        if (N == 2) {
            return K != 3;
        } else if (N == 3) {
            return K == 3 || K == 6 || K > 8;
        } else if (N == 4) {
            return K % 4 == 0 && K <= 16;
        } else if (N == 5) {
            return K % 5 == 0 && K <= 25;
        }
        return false;
    }

    private static void printMatrix(int N, int K) {
        int[][] matrices = {
            {1, 2, 3, 4, 5},
            {5, 1, 4, 3, 2},
            {4, 5, 1, 2, 3},
            {2, 3, 5, 1, 4},
            {3, 4, 2, 5, 1}
        };

        int index = (K / N) % N;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(matrices[(index + i) % N][j] + " ");
            }
            System.out.println();
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int chars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (chars == -1) throw new InputMismatchException();
            if (curChar >= chars) {
                curChar = 0;
                try {
                    chars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (chars <= 0) return -1;
            }
            return buf[curChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
    }
}