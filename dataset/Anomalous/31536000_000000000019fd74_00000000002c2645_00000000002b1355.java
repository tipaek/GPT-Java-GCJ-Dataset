import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.NoSuchElementException;

public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    class DancingLink {
        DancingLink top, bottom, left, right;
        final int S, X, Y;

        DancingLink(int s, int x, int y) {
            S = s;
            X = x;
            Y = y;
        }

        boolean willEliminate() {
            int sum = 0;
            sum += top == null ? S : top.S;
            sum += bottom == null ? S : bottom.S;
            sum += left == null ? S : left.S;
            sum += right == null ? S : right.S;
            return sum > 4 * S;
        }
    }

    void run() {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int T = fs.nextInt();
        for (int t = 1; t <= T; ++t) {
            int R = fs.nextInt(), C = fs.nextInt();
            DancingLink[][] S = new DancingLink[R + 2][C + 2];
            for (int y = 1; y <= R; ++y) {
                for (int x = 1; x <= C; ++x) {
                    S[y][x] = new DancingLink(fs.nextInt(), x, y);
                }
            }
            long sum = 0, score = 0;
            ArrayDeque<DancingLink> eliminate = new ArrayDeque<>();
            for (int y = 1; y <= R; ++y) {
                for (int x = 1; x <= C; ++x) {
                    DancingLink link = S[y][x];
                    sum += link.S;
                    link.top = S[y - 1][x];
                    link.bottom = S[y + 1][x];
                    link.left = S[y][x - 1];
                    link.right = S[y][x + 1];
                    eliminate.add(link);
                }
            }
            ArrayDeque<DancingLink> eliminate2 = new ArrayDeque<>();
            while (!eliminate.isEmpty()) {
                score += sum;
                while (!eliminate.isEmpty()) {
                    DancingLink link = eliminate.poll();
                    if (link.willEliminate()) eliminate2.add(link);
                }
                while (!eliminate2.isEmpty()) {
                    DancingLink link = eliminate2.poll();
                    if (S[link.Y][link.X] == null) continue;
                    S[link.Y][link.X] = null;
                    sum -= link.S;
                    if (link.top != null) {
                        link.top.bottom = link.bottom;
                        eliminate.add(link.top);
                    }
                    if (link.bottom != null) {
                        link.bottom.top = link.top;
                        eliminate.add(link.bottom);
                    }
                    if (link.left != null) {
                        link.left.right = link.right;
                        eliminate.add(link.left);
                    }
                    if (link.right != null) {
                        link.right.left = link.left;
                        eliminate.add(link.right);
                    }
                }
            }
            out.printf("Case #%d: %d%n", t, score);
        }
        out.flush();
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) return true;
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return buflen > 0;
        }

        private byte readByte() {
            return hasNextByte() ? buffer[ptr++] : -1;
        }

        private static boolean isPrintableChar(byte c) {
            return 32 < c || c < 0;
        }

        private static boolean isNumber(int c) {
            return '0' <= c && c <= '9';
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
                ptr++;
            }
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            byte b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            if (!hasNext()) throw new NoSuchElementException();
            int n = 0;
            boolean negative = false;
            try {
                byte b = readByte();
                if (b == '-') {
                    negative = true;
                    b = readByte();
                }
                if (!isNumber(b)) throw new NumberFormatException();
                do {
                    n = n * 10 + b - '0';
                } while (isNumber(b = readByte()));
                return negative ? -n : n;
            } catch (NoSuchElementException e) {
                return n;
            }
        }

        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean negative = false;
            try {
                byte b = readByte();
                if (b == '-') {
                    negative = true;
                    b = readByte();
                }
                if (!isNumber(b)) throw new NumberFormatException();
                do {
                    n = n * 10 + b - '0';
                } while (isNumber(b = readByte()));
                return negative ? -n : n;
            } catch (NoSuchElementException e) {
                return n;
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}