import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collections;
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

        public int[] intArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] longArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        public void printArray(int[] arr) {
            PrintWriter out = new PrintWriter(System.out);
            for (int i = 0; i < arr.length; i++) {
                if (i == arr.length - 1) {
                    out.println(arr[i]);
                } else {
                    out.print(arr[i] + " ");
                }
            }
            out.close();
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
        int testCases = reader.nextInt();
        int caseNumber = 1;
        StringBuilder result = new StringBuilder();

        while (testCases-- > 0) {
            String input = reader.next();
            int[] digits = new int[input.length()];
            for (int i = 0; i < input.length(); i++) {
                digits[i] = input.charAt(i) - '0';
            }

            StringBuilder output = new StringBuilder();
            int previousDigit = 0;

            for (int digit : digits) {
                int difference = digit - previousDigit;

                if (difference > 0) {
                    output.append("(".repeat(difference)).append(digit);
                } else if (difference < 0) {
                    output.append(")".repeat(-difference)).append(digit);
                } else {
                    output.append(digit);
                }

                previousDigit = digit;
            }

            if (previousDigit > 0) {
                output.append(")".repeat(previousDigit));
            }

            result.append("Case #").append(caseNumber++).append(": ").append(output).append("\n");
        }

        System.out.print(result);
    }
}