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

    static boolean isInvalid(long x1, long y1, long x2, long y2, long targetX, long targetY) {
        long minX = Math.min(x1, x2);
        long maxX = Math.max(x1, x2);
        long minY = Math.min(y1, y2);
        long maxY = Math.max(y1, y2);
        return minX < targetX && targetX < maxX && minY < targetY && targetY < maxY;
    }

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static final char[] directions = {'N', 'E', 'S', 'W'};

    static String findPath(long targetX, long targetY) {
        Queue<Pair> queue = new ArrayDeque<>();
        Set<Pair> visited = new HashSet<>();
        queue.add(new Pair(0, 0, ""));
        visited.add(new Pair(0, 0, ""));
        
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.x == targetX && current.y == targetY) {
                return current.path;
            }
            if (current.path.length() > 10) {
                continue;
            }
            long stepSize = 1L << current.path.length();
            for (int i = 0; i < 4; i++) {
                long newX = current.x + dx[i] * stepSize;
                long newY = current.y + dy[i] * stepSize;
                Pair newPair = new Pair(newX, newY, current.path + directions[i]);
                if (isInvalid(current.x, current.y, newX, newY, targetX, targetY)) {
                    continue;
                }
                if (visited.add(newPair)) {
                    queue.add(newPair);
                }
            }
        }
        return "IMPOSSIBLE";
    }

    static class Pair {
        long x, y;
        String path;

        Pair(long x, long y, String path) {
            this.x = x;
            this.y = y;
            this.path = path;
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

        @Override
        public String toString() {
            return x + " " + y + " " + path;
        }
    }

    static class FastReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int bufferPointer, bytesRead;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (bufferPointer == bytesRead) {
                bufferPointer = 0;
                try {
                    bytesRead = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (bytesRead == -1) return -1;
            }
            return buffer[bufferPointer++];
        }

        public int nextInt() {
            int num = 0;
            int b;
            boolean negative = false;
            while ((b = read()) != -1 && !Character.isDigit(b) && b != '-') ;
            if (b == '-') {
                negative = true;
                b = read();
            }
            while (true) {
                if (Character.isDigit(b)) {
                    num = num * 10 + (b - '0');
                } else {
                    return negative ? -num : num;
                }
                b = read();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean negative = false;
            while ((b = read()) != -1 && !Character.isDigit(b) && b != '-') ;
            if (b == '-') {
                negative = true;
                b = read();
            }
            while (true) {
                if (Character.isDigit(b)) {
                    num = num * 10 + (b - '0');
                } else {
                    return negative ? -num : num;
                }
                b = read();
            }
        }

        public String next() {
            int b = read();
            while (Character.isWhitespace(b)) {
                b = read();
            }
            StringBuilder sb = new StringBuilder();
            while (!Character.isWhitespace(b)) {
                sb.appendCodePoint(b);
                b = read();
            }
            return sb.toString();
        }
    }
}