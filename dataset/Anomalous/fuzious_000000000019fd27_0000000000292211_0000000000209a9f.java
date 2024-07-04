import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        int testCases = sc.nextInt();
        for (int tc = 1; tc <= testCases; tc++) {
            String input = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int balance = 0;

            for (int i = 0; i < input.length(); i++) {
                int currentDigit = input.charAt(i) - '0';
                while (balance < currentDigit) {
                    result.append('(');
                    balance++;
                }
                while (balance > currentDigit) {
                    result.append(')');
                    balance--;
                }
                result.append(input.charAt(i));
            }
            while (balance > 0) {
                result.append(')');
                balance--;
            }
            System.out.println("Case #" + tc + ": " + result.toString());
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int curChar, numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[curChar++];
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}