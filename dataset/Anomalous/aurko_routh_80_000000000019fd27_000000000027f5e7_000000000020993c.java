import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt() - 1;
                    if (i == j) {
                        trace += matrix[i][j] + 1;
                    }
                }
            }

            int repeatedRows = 0;
            int repeatedColumns = 0;

            for (int i = 0; i < n; i++) {
                boolean[] rowVisited = new boolean[n];
                boolean[] colVisited = new boolean[n];
                boolean rowHasDuplicate = false;
                boolean colHasDuplicate = false;

                for (int j = 0; j < n; j++) {
                    if (rowVisited[matrix[i][j]]) {
                        rowHasDuplicate = true;
                    }
                    if (colVisited[matrix[j][i]]) {
                        colHasDuplicate = true;
                    }
                    rowVisited[matrix[i][j]] = true;
                    colVisited[matrix[j][i]] = true;
                }

                if (rowHasDuplicate) {
                    repeatedRows++;
                }
                if (colHasDuplicate) {
                    repeatedColumns++;
                }
            }

            System.out.printf("Case #%d: %d %d %d%n", caseNumber, trace, repeatedColumns, repeatedRows);
        }
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
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

        String nextLine() {
            int c = read();
            while (isEndline(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return result.toString();
        }
    }
}