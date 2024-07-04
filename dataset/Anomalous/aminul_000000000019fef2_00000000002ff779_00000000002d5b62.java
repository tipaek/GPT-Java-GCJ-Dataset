import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = reader.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            long targetX = reader.nextInt();
            long targetY = reader.nextInt();
            String result = findPath(targetX, targetY);
            writer.println("Case #" + t + ": " + result);
        }
        
        writer.close();
    }

    private static boolean isInvalidMove(long x1, long y1, long x2, long y2, long x, long y) {
        if (x == x2 && y == y2) return false;
        long minX = Math.min(x1, x2), maxX = Math.max(x1, x2);
        long minY = Math.min(y1, y2), maxY = Math.max(y1, y2);
        return minX <= x && x <= maxX && minY <= y && y <= maxY;
    }

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};
    private static final char[] directions = {'N', 'E', 'S', 'W'};
    private static final Map<Pair, String> memo = new HashMap<>();

    private static String findPath(long targetX, long targetY) {
        Pair target = new Pair(targetX, targetY, "");
        if (memo.containsKey(target)) return memo.get(target);
        
        Queue<Pair> queue = new ArrayDeque<>();
        Set<Pair> visited = new TreeSet<>();
        queue.add(new Pair(0, 0, ""));
        visited.add(new Pair(0, 0, ""));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.x == targetX && current.y == targetY) {
                memo.put(target, current.path);
                return current.path;
            }
            if (current.path.length() > 10) continue;
            
            long moveDistance = 1L << current.path.length();
            for (int i = 0; i < 4; i++) {
                long newX = current.x + dx[i] * moveDistance;
                long newY = current.y + dy[i] * moveDistance;
                Pair next = new Pair(newX, newY, current.path + directions[i]);
                if (isInvalidMove(0, 0, newX, newY, targetX, targetY)) continue;
                if (visited.add(next)) {
                    queue.add(next);
                }
            }
        }

        memo.put(target, "IMPOSSIBLE");
        return "IMPOSSIBLE";
    }

    private static class Pair implements Comparable<Pair> {
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
    }

    private static class FastReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int bufferLength = 0, bufferPointer = 0;

        FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int readByte() {
            if (bufferLength == -1) throw new InputMismatchException();
            if (bufferPointer >= bufferLength) {
                bufferPointer = 0;
                try {
                    bufferLength = stream.read(buffer);
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
                    num = num * 10 + (b - '0');
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
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}