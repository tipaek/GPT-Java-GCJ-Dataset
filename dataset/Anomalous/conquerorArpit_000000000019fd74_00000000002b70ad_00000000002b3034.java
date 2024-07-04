import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {

    static class Reader {
        private InputStream inputStream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream inputStream) {
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

        public double nextDouble() {
            return Double.parseDouble(next());
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
    }

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int t = reader.nextInt();
        int caseNumber = 1;
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int n = reader.nextInt();
            String[] strings = new String[n];
            int maxLength = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {
                strings[i] = reader.next();
                maxLength = Math.max(maxLength, strings[i].length());
            }

            char[][] paddedStrings = new char[n][maxLength];
            for (int i = 0; i < n; i++) {
                int paddingLength = maxLength - strings[i].length();
                for (int j = 0; j < paddingLength; j++) {
                    paddedStrings[i][j] = '*';
                }
                for (int j = 0; j < strings[i].length(); j++) {
                    paddedStrings[i][paddingLength + j] = strings[i].charAt(j);
                }
            }

            StringBuilder caseResult = new StringBuilder();
            for (int i = 0; i < maxLength; i++) {
                HashSet<Character> uniqueChars = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    uniqueChars.add(paddedStrings[j][i]);
                }

                if (uniqueChars.size() > 2) {
                    caseResult = new StringBuilder("*");
                    break;
                } else {
                    uniqueChars.remove('*');
                    if (uniqueChars.size() > 1) {
                        caseResult = new StringBuilder("*");
                        break;
                    } else if (uniqueChars.size() == 1) {
                        caseResult.append(uniqueChars.iterator().next());
                    } else {
                        caseResult.append('A');
                    }
                }
            }

            result.append("Case #").append(caseNumber++).append(": ").append(caseResult).append("\n");
        }

        System.out.print(result);
    }
}