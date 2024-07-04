/**
 * Created by Aminul on 4/19/2020.
 */

import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int test = in.nextInt();
        for (int t = 1; t <= test; t++) {
            long tx = in.nextInt(), ty = in.nextInt();
            String res = bfs(tx, ty);
            pw.println("Case #" + t + ": " + res);
        }

        pw.close();
    }

    static boolean invalid(long x1, long y1, long x2, long y2, long x, long y) {
        if (x == x2 && y == y2) return false;
        long minX = min(x1, x2), maxX = max(x1, x2);
        long minY = min(y1, y2), maxY = max(y1, y2);
        return minX <= x && x <= maxX && minY <= y && y <= maxY;
    }

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static char[] dir = {'N', 'E', 'S', 'W'};
    //static int LEFT = 2, RIGHT = 0, UP = 3, DOWN = 1;

    static String bfs(long tx, long ty) {
        //if((abs(tx) + abs(ty)) % 2 == 0) return "IMPOSSIBLE";
        long maxMoves = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        TreeSet<Pair> set = new TreeSet<>();
        queue.add(new Pair(0, 0, ""));
        set.add(new Pair(0, 0, ""));
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            if (poll.x == tx && poll.y == ty) return poll.str;
            if (poll.str.length() > 10) continue;
            long pow = poll.str.length();
            for (int i = 0; i < 4; i++) {
                long x = poll.x + dx[i] * (1l << pow);
                long y = poll.y + dy[i] * (1l << pow);
                Pair pair = new Pair(x, y, poll.str + dir[i]);
                if (invalid(poll.x, poll.y, x, y, tx, ty)) continue;
                //if (!set.add(pair)) continue;
                queue.add(pair);
            }
        }

        return "IMPOSSIBLE";
    }

    static class Pair implements Comparable<Pair> {
        long x, y;
        String str;

        Pair(long F, long S, String str) {
            x = F;
            y = S;
            this.str = str;
        }

        public int compareTo(Pair p) {
            if (x == p.x) return Long.compare(y, p.y);
            return Long.compare(x, p.x);
        }

        public String toString() {
            return x + " " + y + " " + str;
        }
    }

    static void debug(Object... obj) {
        System.err.println(Arrays.deepToString(obj));
    }

    static class FastReader {
        InputStream is;
        private byte[] inbuf = new byte[1024];
        private int lenbuf = 0, ptrbuf = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        public int readByte() {
            if (lenbuf == -1) throw new InputMismatchException();
            if (ptrbuf >= lenbuf) {
                ptrbuf = 0;
                try {
                    lenbuf = is.read(inbuf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (lenbuf <= 0) return -1;
            }
            return inbuf[ptrbuf++];
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }


        public String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (!isEndOfLine(c)) {
                sb.appendCodePoint(c);
                c = readByte();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = (num << 3) + (num << 1) + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}