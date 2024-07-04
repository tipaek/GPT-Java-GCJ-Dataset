import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        int testCaseCount = sc.nextInt();
        for (int tc = 0; tc < testCaseCount; tc++) {
            String inputString = sc.nextLine();
            StringBuilder finalString = new StringBuilder();
            int openBrackets = 0;

            for (int i = 0; i < inputString.length(); i++) {
                int currentDigit = inputString.charAt(i) - '0';

                if (openBrackets > currentDigit) {
                    int closeBrackets = openBrackets - currentDigit;
                    openBrackets -= closeBrackets;
                    finalString.append(")".repeat(closeBrackets));
                } else if (openBrackets < currentDigit) {
                    int newOpenBrackets = currentDigit - openBrackets;
                    openBrackets += newOpenBrackets;
                    finalString.append("(".repeat(newOpenBrackets));
                }

                finalString.append(inputString.charAt(i));
            }

            while (openBrackets-- > 0) {
                finalString.append(')');
            }

            out.println("Case #" + (tc + 1) + ": " + finalString);
        }
        out.close();
    }

    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static final int MOD = 1000000007;

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int currentChar, numberOfChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int nextByte() {
            if (numberOfChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numberOfChars) {
                currentChar = 0;
                try {
                    numberOfChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numberOfChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public int nextInt() {
            int c = nextByte();
            while (isSpaceChar(c)) {
                c = nextByte();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = nextByte();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = nextByte();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long nextLong() {
            int c = nextByte();
            while (isSpaceChar(c)) {
                c = nextByte();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = nextByte();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = nextByte();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public int[] nextIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public String readString() {
            int c = nextByte();
            while (isSpaceChar(c)) {
                c = nextByte();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = nextByte();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public String nextLine() {
            int c = nextByte();
            while (isSpaceChar(c)) {
                c = nextByte();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = nextByte();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public double nextDouble() {
            return Double.parseDouble(readString());
        }

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}