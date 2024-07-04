import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            String inputString = in.next();
            int[] digitArray = new int[inputString.length()];
            for (int i = 0; i < inputString.length(); i++) {
                digitArray[i] = inputString.charAt(i) - '0';
            }
            StringBuilder result = solve(0, inputString.length() - 1, 0, digitArray);
            pw.println("Case #" + t + ": " + result.toString());
        }
        pw.close();
    }

    static int findMinPosition(int left, int right, int[] array) {
        int minPosition = left;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] < array[minPosition]) {
                minPosition = i;
            }
        }
        return minPosition;
    }

    static StringBuilder solve(int left, int right, int reduced, int[] array) {
        StringBuilder result = new StringBuilder();
        if (left > right) return result;

        int minPosition = findMinPosition(left, right, array);
        int bracketCount = array[minPosition] - reduced;
        for (int i = 0; i < bracketCount; i++) result.append("(");
        result.append(solve(left, minPosition - 1, reduced + bracketCount, array));
        result.append(array[minPosition]);
        result.append(solve(minPosition + 1, right, reduced + bracketCount, array));
        for (int i = 0; i < bracketCount; i++) result.append(")");
        return result;
    }

    static class FastReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int bufferLength = 0, bufferPointer = 0;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
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
            while ((b = read()) != -1 && isSpaceChar(b));
            return b;
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = read();
            }
            return sb.toString();
        }

        public String nextLine() {
            int c = skip();
            StringBuilder sb = new StringBuilder();
            while (!isEndOfLine(c)) {
                sb.appendCodePoint(c);
                c = read();
            }
            return sb.toString();
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = read()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                minus = true;
                b = read();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = read();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = read()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
            if (b == '-') {
                minus = true;
                b = read();
            }
            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = read();
            }
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char[] next(int n) {
            char[] buffer = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buffer[p++] = (char) b;
                b = read();
            }
            return n == p ? buffer : Arrays.copyOf(buffer, p);
        }

        public char readChar() {
            return (char) skip();
        }
    }
}