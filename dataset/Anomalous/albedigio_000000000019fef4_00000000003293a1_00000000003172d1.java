import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class Solution {

    private static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
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

        public int readInt() {
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

        public String readString() {
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

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return result * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double fraction = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return result * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    fraction /= 10;
                    result += (c - '0') * fraction;
                    c = read();
                }
            }
            return result * sign;
        }

        public long readLong() {
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

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = in.readInt();
        for (int t = 0; t < testCases; t++) {
            StringBuilder result = new StringBuilder();
            int n = in.readInt();
            int d = in.readInt();
            double[] angles = new double[n];
            Map<Double, Integer> angleCount = new HashMap<>();
            for (int i = 0; i < n; i++) {
                angles[i] = in.readDouble();
                angleCount.put(angles[i], angleCount.getOrDefault(angles[i], 0) + 1);
            }

            if (d == 2) {
                for (int count : angleCount.values()) {
                    if (count == 2) {
                        result.append(0);
                        break;
                    }
                }
                if (result.length() == 0) {
                    result.append(1);
                }
            } else if (d == 3) {
                for (int count : angleCount.values()) {
                    if (count == 3) {
                        result.append(0);
                        break;
                    }
                }
                if (result.length() == 0) {
                    boolean found = false;
                    for (double key1 : angleCount.keySet()) {
                        for (double key2 : angleCount.keySet()) {
                            if (key1 / 2 == key2) {
                                result.append(1);
                                found = true;
                                break;
                            }
                        }
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        result.append(2);
                    }
                }
            }

            output.append("Case #").append(t + 1).append(": ").append(result).append('\n');
        }
        System.out.print(output);
    }
}