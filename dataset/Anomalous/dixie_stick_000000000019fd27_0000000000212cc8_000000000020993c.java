import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Vestigium {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int columnDuplicates = countColumnDuplicates(matrix, n);

            resultBuilder.append(String.format("Case #%d: %d %d %d%n", t, trace, rowDuplicates, columnDuplicates));
        }

        System.out.print(resultBuilder);
    }

    private static int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private static int countRowDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int i = 0; i < size; i++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int j = 0; j < size; j++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                duplicates++;
            }
        }
        return duplicates;
    }

    private static int countColumnDuplicates(int[][] matrix, int size) {
        int duplicates = 0;
        for (int j = 0; j < size; j++) {
            HashSet<Integer> uniqueElements = new HashSet<>();
            for (int i = 0; i < size; i++) {
                uniqueElements.add(matrix[i][j]);
            }
            if (uniqueElements.size() != size) {
                duplicates++;
            }
        }
        return duplicates;
    }

    static class FastScanner {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
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