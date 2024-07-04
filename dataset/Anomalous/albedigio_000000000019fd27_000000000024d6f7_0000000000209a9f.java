import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    private static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
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
                double multiplier = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return result * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    multiplier /= 10;
                    result += (c - '0') * multiplier;
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

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static void main(String[] args) {
        InputReader input = new InputReader(System.in);
        StringBuilder output = new StringBuilder();
        int testCases = input.readInt();
        for (int i = 0; i < testCases; i++) {
            String s = input.readString();
            StringBuilder result = new StringBuilder();
            if (s.length() == 1) {
                int digit = Character.getNumericValue(s.charAt(0));
                result.append("(".repeat(digit)).append(digit).append(")".repeat(digit));
            } else {
                int openBrackets = 0;
                for (int j = 0; j < s.length() - 1; j++) {
                    int current = Character.getNumericValue(s.charAt(j));
                    int next = Character.getNumericValue(s.charAt(j + 1));
                    if (j == 0) {
                        result.append("(".repeat(current));
                        openBrackets = current;
                    } else {
                        if (current > openBrackets) {
                            result.append("(".repeat(current - openBrackets));
                            openBrackets = current;
                        }
                    }
                    result.append(current);
                    while (current == next && j + 1 < s.length() - 1) {
                        result.append(next);
                        j++;
                        next = Character.getNumericValue(s.charAt(j + 1));
                    }
                    if (current > next) {
                        result.append(")".repeat(current - next));
                        openBrackets -= (current - next);
                    } else if (current < next) {
                        result.append("(".repeat(next - current));
                        openBrackets += (next - current);
                    }
                }
                result.append(s.charAt(s.length() - 1));
                result.append(")".repeat(openBrackets));
            }
            output.append("Case #").append(i + 1).append(": ").append(result).append('\n');
        }
        System.out.print(output);
    }
}