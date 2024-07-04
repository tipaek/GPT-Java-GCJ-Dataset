import java.util.*;
import java.io.*;

public class Solution {
    static InputReader in = new InputReader(System.in);
    static OutputWriter out = new OutputWriter(System.out);
    static StringBuilder sb = new StringBuilder();
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws IOException {
        int t = in.readInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int r = in.readInt();
            int s = in.readInt();
            int count = (s - 1) * (r - 1);
            StringBuilder str = new StringBuilder();
            int fir = (s - 1) * r;

            while (r > 0) {
                for (int i = 1; i < s; i++) {
                    if (r - 1 == 0) break;
                    str.append(fir).append(" ").append(r - 1).append("\n");
                    fir--;
                }
                r--;
            }

            sb.append("Case #").append(caseNumber).append(": ").append(count).append("\n");
            sb.append(str);
            caseNumber++;
        }

        out.printLine(sb.toString());
        out.close();
    }

    public static long reverse(long n) {
        long rev = 0L;
        while (n != 0L) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public static long power(long a, long b) {
        if (b == 0) return 1L;
        if (b == 1) return a % MOD;

        long half = power((a * a) % MOD, b / 2);
        return (b % 2 == 0) ? half : (half * a) % MOD;
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static int[] readArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.readInt();
        }
        return array;
    }

    public static HashMap<Integer, Integer> createFrequencyMap(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : array) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        return map;
    }

    public static long calculateManhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static class Point {
        int x, y;
        String direction;

        public Point(int x, int y, String direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar, numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[currentChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public boolean isSpaceChar(int c) {
            return filter != null ? filter.isSpaceChar(c) : c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }
    }
}