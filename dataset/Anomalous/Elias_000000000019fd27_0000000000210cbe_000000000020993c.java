import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution();
    }

    public Solution() throws FileNotFoundException {
        FastScanner scanner = new FastScanner(System.in);

        int numberOfTasks = scanner.nextInt();
        for (int task = 1; task <= numberOfTasks; task++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int trace = 0, rowRepeats = 0, colRepeats = 0;

            // Calculate trace
            for (int i = 0; i < n; i++) {
                trace += matrix[i][i];
            }

            // Calculate row repeats
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                boolean hasRepeat = false;
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[i][j]]) {
                        hasRepeat = true;
                        break;
                    }
                    seen[matrix[i][j]] = true;
                }
                if (hasRepeat) rowRepeats++;
            }

            // Calculate column repeats
            for (int i = 0; i < n; i++) {
                boolean[] seen = new boolean[n + 1];
                boolean hasRepeat = false;
                for (int j = 0; j < n; j++) {
                    if (seen[matrix[j][i]]) {
                        hasRepeat = true;
                        break;
                    }
                    seen[matrix[j][i]] = true;
                }
                if (hasRepeat) colRepeats++;
            }

            System.out.printf("Case #%d: %d %d %d%n", task, trace, rowRepeats, colRepeats);
        }

        scanner.close();
    }

    private static class FastScanner {
        private final InputStream inputStream;
        private final byte[] buffer = new byte[1024];
        private int currentChar, numChars;

        public FastScanner(InputStream inputStream) {
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

        public String nextString() {
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

        public void close() {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}