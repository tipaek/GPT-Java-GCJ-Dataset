import java.io.*;
import java.util.*;

import static java.lang.Math.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            long targetX = in.nextInt();
            long targetY = in.nextInt();
            String result = findPath(targetX, targetY);
            pw.println("Case #" + t + ": " + result);
        }
        pw.close();
    }

    static boolean isInvalidMove(long x1, long y1, long x2, long y2, long targetX, long targetY) {
        if (targetX == x2 && targetY == y2) return false;
        long minX = min(x1, x2), maxX = max(x1, x2);
        long minY = min(y1, y2), maxY = max(y1, y2);
        return minX <= targetX && targetX <= maxX && minY <= targetY && targetY <= maxY;
    }

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[] directions = {'N', 'E', 'S', 'W'};

    static String findPath(long targetX, long targetY) {
        Queue<Pair> queue = new ArrayDeque<>();
        Set<Pair> visited = new HashSet<>();
        queue.add(new Pair(0, 0, ""));
        visited.add(new Pair(0, 0, ""));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.x == targetX && current.y == targetY) return current.path;
            if (current.path.length() > 10) continue;
            long movePower = current.path.length();
            for (int i = 0; i < 4; i++) {
                long newX = current.x + dx[i] * (1L << movePower);
                long newY = current.y + dy[i] * (1L << movePower);
                Pair newPair = new Pair(newX, newY, current.path + directions[i]);
                if (isInvalidMove(current.x, current.y, newX, newY, targetX, targetY)) continue;
                if (visited.add(newPair)) {
                    queue.add(newPair);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    static class Pair implements Comparable<Pair> {
        long x, y;
        String path;

        Pair(long x, long y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.x == other.x) return Long.compare(this.y, other.y);
            return Long.compare(this.x, other.x);
        }

        @Override
        public String toString() {
            return x + " " + y + " " + path;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return x == pair.x && y == pair.y && Objects.equals(path, pair.path);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, path);
        }
    }

    static class FastReader {
        InputStream is;
        private byte[] buffer = new byte[1024];
        private int bufferLength = 0, bufferPointer = 0;

        public FastReader(InputStream is) {
            this.is = is;
        }

        private int readByte() {
            if (bufferLength == -1) throw new InputMismatchException();
            if (bufferPointer >= bufferLength) {
                bufferPointer = 0;
                try {
                    bufferLength = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (bufferLength <= 0) return -1;
            }
            return buffer[bufferPointer++];
        }

        private boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        private int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) {
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
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
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
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
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
            char[] buffer = new char[n];
            int b = skip(), p = 0;
            while (p < n && !isSpaceChar(b)) {
                buffer[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buffer : Arrays.copyOf(buffer, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}