import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        NestingDepthSolver solver = new NestingDepthSolver();
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            solver.solve(i, in);
        }
    }

    static void printOutput(String s) {
        System.out.println(s);
    }

    static class NestingDepthSolver {
        public void solve(int caseNumber, InputReader in) {
            StringBuilder result = new StringBuilder();
            String input = in.next();
            int length = input.length();

            for (int i = 0; i < length; i++) {
                int currentDigit = Character.getNumericValue(input.charAt(i));
                if (i == 0) {
                    appendParentheses(result, currentDigit, true);
                } else {
                    int previousDigit = Character.getNumericValue(input.charAt(i - 1));
                    if (currentDigit > previousDigit) {
                        appendParentheses(result, currentDigit - previousDigit, true);
                    } else if (currentDigit < previousDigit) {
                        appendParentheses(result, previousDigit - currentDigit, false);
                    }
                }
                result.append(currentDigit);
            }
            appendParentheses(result, Character.getNumericValue(input.charAt(length - 1)), false);

            printOutput("Case #" + caseNumber + ": " + result);
        }

        private void appendParentheses(StringBuilder builder, int count, boolean open) {
            char parenthesis = open ? '(' : ')';
            for (int i = 0; i < count; i++) {
                builder.append(parenthesis);
            }
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}