import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int size = scanner.nextInt();
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, size);
            int rowsWithDuplicates = countRowsWithDuplicates(matrix, size);
            int columnsWithDuplicates = countColumnsWithDuplicates(matrix, size);

            result.append("Test #").append(t).append(": ")
                  .append(trace).append(" ")
                  .append(rowsWithDuplicates).append(" ")
                  .append(columnsWithDuplicates).append("\n");
        }

        System.out.print(result);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowsWithDuplicates(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private static int countColumnsWithDuplicates(int[][] matrix, int size) {
        int duplicateColumns = 0;
        for (int j = 0; j < size; j++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                duplicateColumns++;
            }
        }
        return duplicateColumns;
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int charsRead;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (charsRead == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= charsRead) {
                currentChar = 0;
                try {
                    charsRead = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (charsRead <= 0) {
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
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

        public String nextLine() {
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