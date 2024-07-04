import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Solution {

    private static final int L = 60;
    private static long[][] combo;

    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int T = in.nextInt();
        StringBuilder sb = new StringBuilder();

        initializeCombo();

        for (int t = 0; t < T; t++) {
            int N = in.nextInt();
            ArrayList<Pair> path = findPath(N);
            sb.append("Case #").append(t + 1).append(":\n");
            long sum = 0;

            for (Pair p : path) {
                if (sum < N) {
                    sb.append(p.a + 1).append(" ").append(p.b + 1).append("\n");
                    sum += combo[p.a][p.b];
                }
            }
        }

        System.out.println(sb);
    }

    private static void initializeCombo() {
        combo = new long[L][L];
        for (int i = 0; i < L; i++) {
            combo[i][0] = 1;
        }
        for (int i = 1; i < L; i++) {
            for (int j = 1; j <= i; j++) {
                combo[i][j] = combo[i - 1][j - 1] + combo[i - 1][j];
            }
        }
    }

    private static ArrayList<Pair> findPath(int N) {
        int M = N;
        int highestBitIndex = findHighestBitIndex(M);
        M = N - highestBitIndex;

        boolean[][] marked = markPositions(M);
        ArrayList<Pair> path = new ArrayList<>();
        Pair current = new Pair(0, 0);
        boolean onLeft = true;

        while (current.a < L) {
            path.add(new Pair(current));
            if (onLeft) {
                if (current.a < L - 1 && marked[current.a + 1][current.b]) {
                    onLeft = false;
                    for (int j = 0; j <= current.a; j++) {
                        path.add(new Pair(current.a + 1, j));
                    }
                    current = new Pair(current.a + 1, current.a + 1);
                } else {
                    current.a++;
                }
            } else {
                if (current.a < L - 1 && marked[current.a + 1][current.b]) {
                    onLeft = true;
                    for (int j = current.a + 1; j >= 1; j--) {
                        path.add(new Pair(current.a + 1, j));
                    }
                    current = new Pair(current.a + 1, 0);
                } else {
                    current.a++;
                    current.b++;
                }
            }
        }

        path.add(current);
        return path;
    }

    private static int findHighestBitIndex(int M) {
        int index = -1;
        for (int i = 0; i < 32; i++) {
            if (((M >> i) & 1) == 1) {
                index = i;
            }
        }
        return index;
    }

    private static boolean[][] markPositions(int M) {
        boolean[][] marked = new boolean[L][L];
        marked[0][0] = true;
        for (int i = 0; i < 32; i++) {
            if (((M >> i) & 1) == 1) {
                for (int j = 0; j < i; j++) {
                    marked[i][j] = true;
                }
            }
        }
        return marked;
    }

    static class Pair implements Comparable<Pair> {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public Pair(Pair p) {
            this.a = p.a;
            this.b = p.b;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.a != other.a) {
                return Integer.compare(this.a, other.a);
            }
            return Integer.compare(this.b, other.b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return 31 * a + b;
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ")";
        }
    }

    static class FastScanner {
        private final InputStream stream;
        private final byte[] buf = new byte[1024];
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

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                result = result * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                result = result * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return result.toString();
        }
    }
}