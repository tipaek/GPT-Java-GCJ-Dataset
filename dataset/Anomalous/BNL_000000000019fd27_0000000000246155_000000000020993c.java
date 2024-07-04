import java.util.*;
import java.io.*;
import java.math.*;

public class Solution {
    private static final int MAXN = 5 * (int) 1e5 + 5;
    private static final long MOD = (int) 1e9 + 7;
    private static int n, t;

    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Reader in = new Reader();
        new Solution().solve(out, in);
        out.flush();
        out.close();
    }

    private void solve(PrintWriter out, Reader in) throws IOException {
        t = in.nextInt();

        for (int itr = 1; itr <= t; itr++) {
            n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = in.nextInt();
                }
            }

            int diagonalSum = calculateDiagonalSum(matrix);
            int duplicateRows = countDuplicateRows(matrix);
            int duplicateCols = countDuplicateColumns(matrix);

            out.printf("Case #%d: %d %d %d%n", itr, diagonalSum, duplicateRows, duplicateCols);
        }
    }

    private int calculateDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private int countDuplicateRows(int[][] matrix) {
        int duplicateRows = 0;
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            for (int j = 0; j < n; j++) {
                if (visited[matrix[i][j]]) {
                    duplicateRows++;
                    break;
                }
                visited[matrix[i][j]] = true;
            }
        }

        return duplicateRows;
    }

    private int countDuplicateColumns(int[][] matrix) {
        int duplicateCols = 0;
        boolean[] visited = new boolean[n + 1];

        for (int j = 0; j < n; j++) {
            Arrays.fill(visited, false);
            for (int i = 0; i < n; i++) {
                if (visited[matrix[i][j]]) {
                    duplicateCols++;
                    break;
                }
                visited[matrix[i][j]] = true;
            }
        }

        return duplicateCols;
    }

    static class Reader {
        private final InputStream inputStream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = inputStream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}