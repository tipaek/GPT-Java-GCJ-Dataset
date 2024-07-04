import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().solve();
    }

    private void solve() throws IOException {
        FasterScanner sc = new FasterScanner(System.in);
        int numTasks = sc.nextInt();

        for (int task = 1; task <= numTasks; task++) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            long[][] dancers = new long[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    dancers[i][j] = sc.nextInt();
                }
            }

            long totalSum = 0;
            boolean hasChanged;

            do {
                hasChanged = false;
                long[][] newDancers = new long[rows][cols];

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (dancers[i][j] == -1) {
                            newDancers[i][j] = -1;
                            continue;
                        }

                        totalSum += dancers[i][j];
                        long neighborSum = 0;
                        int neighborCount = 0;

                        // Check top neighbor
                        for (int k = i - 1; k >= 0; k--) {
                            if (dancers[k][j] != -1) {
                                neighborSum += dancers[k][j];
                                neighborCount++;
                                break;
                            }
                        }

                        // Check bottom neighbor
                        for (int k = i + 1; k < rows; k++) {
                            if (dancers[k][j] != -1) {
                                neighborSum += dancers[k][j];
                                neighborCount++;
                                break;
                            }
                        }

                        // Check left neighbor
                        for (int k = j - 1; k >= 0; k--) {
                            if (dancers[i][k] != -1) {
                                neighborSum += dancers[i][k];
                                neighborCount++;
                                break;
                            }
                        }

                        // Check right neighbor
                        for (int k = j + 1; k < cols; k++) {
                            if (dancers[i][k] != -1) {
                                neighborSum += dancers[i][k];
                                neighborCount++;
                                break;
                            }
                        }

                        if (neighborCount > 0 && dancers[i][j] * neighborCount < neighborSum) {
                            newDancers[i][j] = -1;
                            hasChanged = true;
                        } else {
                            newDancers[i][j] = dancers[i][j];
                        }
                    }
                }

                dancers = newDancers;

            } while (hasChanged);

            System.out.println("Case #" + task + ": " + totalSum);
        }

        sc.close();
    }

    private static class FasterScanner {
        private InputStream is;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FasterScanner(InputStream is) {
            this.is = is;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = is.read(buffer);
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
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}