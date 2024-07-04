import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = reader.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            int[][] matrix = new int[n][n];
            long trace = 0, invalidRows = 0, invalidCols = 0;
            int[] visited = new int[n + 1];

            for (int i = 0; i < n; i++) {
                Arrays.fill(visited, 0);
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = reader.nextInt();
                    if (i == j) {
                        trace += matrix[i][j];
                    }
                    visited[matrix[i][j]]++;
                }
                if (hasDuplicates(visited, n)) {
                    invalidRows++;
                }
            }

            for (int j = 0; j < n; j++) {
                Arrays.fill(visited, 0);
                for (int i = 0; i < n; i++) {
                    visited[matrix[i][j]]++;
                }
                if (hasDuplicates(visited, n)) {
                    invalidCols++;
                }
            }

            writer.println("Case #" + t + ": " + trace + " " + invalidRows + " " + invalidCols);
        }

        writer.close();
    }

    private static boolean hasDuplicates(int[] visited, int n) {
        for (int k = 1; k <= n; k++) {
            if (visited[k] > 1) {
                return true;
            }
        }
        return false;
    }

    static class FastReader {
        InputStream input;
        byte[] buffer = new byte[1024];
        int bufferLength = 0, bufferPointer = 0;

        public FastReader(InputStream input) {
            this.input = input;
        }

        private int readByte() {
            if (bufferLength == -1) throw new InputMismatchException();
            if (bufferPointer >= bufferLength) {
                bufferPointer = 0;
                try {
                    bufferLength = input.read(buffer);
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
            while ((b = readByte()) != -1 && isSpaceChar(b)) ;
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
            while (p < n && !isSpaceChar(b)) {
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