import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        new Solution();
    }

    public Solution() throws FileNotFoundException {
        FasterScanner scanner = new FasterScanner(System.in);

        int taskCount = scanner.nextInt();

        for (int task = 1; task <= taskCount; task++) {
            int n = scanner.nextInt();
            int power = 30;
            ArrayList<String> path = new ArrayList<>();
            boolean segmentFound = false;
            int maxPower = -1;
            boolean isLeftBound = true;

            while (power >= 0) {
                int rowSum = 1 << power; // Equivalent to Math.pow(2, power)
                if (!segmentFound) {
                    if ((rowSum + power) <= n) {
                        maxPower = power;
                        n -= (rowSum + power);
                        if (isLeftBound) {
                            for (int i = 1; i <= power + 1; i++) {
                                path.add((power + 1) + " " + i);
                            }
                        } else {
                            for (int i = power + 1; i >= 1; i--) {
                                path.add((power + 1) + " " + i);
                            }
                        }
                        isLeftBound = !isLeftBound;
                        segmentFound = true;
                    }
                } else {
                    if ((rowSum - 1) <= n) {
                        n -= (rowSum - 1);
                        if (isLeftBound) {
                            for (int i = 1; i <= power + 1; i++) {
                                path.add((power + 1) + " " + i);
                            }
                        } else {
                            for (int i = power + 1; i >= 1; i--) {
                                path.add((power + 1) + " " + i);
                            }
                        }
                        isLeftBound = !isLeftBound;
                    } else {
                        if (isLeftBound) {
                            path.add((power + 1) + " " + 1);
                        } else {
                            path.add((power + 1) + " " + (power + 1));
                        }
                    }
                }
                power--;
            }

            StringBuilder result = new StringBuilder();
            for (int i = path.size() - 1; i >= 0; i--) {
                result.append(path.get(i)).append("\n");
            }
            maxPower++;
            while (n > 0) {
                maxPower++;
                result.append(maxPower).append(" 1\n");
                n--;
            }

            System.out.println("Case #" + task + ": ");
            System.out.print(result);
        }

        scanner.close();
    }

    public static class FasterScanner {
        private InputStream inputStream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numberOfChars;

        public FasterScanner(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        public int read() {
            if (numberOfChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numberOfChars) {
                currentChar = 0;
                try {
                    numberOfChars = inputStream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numberOfChars <= 0) {
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

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
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