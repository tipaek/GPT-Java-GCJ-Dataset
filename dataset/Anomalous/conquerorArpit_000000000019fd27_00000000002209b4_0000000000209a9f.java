import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Solution {

    static class FastReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastReader() {
            this(System.in);
        }

        public FastReader(InputStream stream) {
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

        public int[] readIntArray(int n) {
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextInt();
            }
            return array;
        }

        public long[] readLongArray(int n) {
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = nextLong();
            }
            return array;
        }

        public void printArray(int[] array) {
            PrintWriter out = new PrintWriter(System.out);
            for (int i = 0; i < array.length; i++) {
                if (i == array.length - 1) {
                    out.println(array[i]);
                } else {
                    out.print(array[i] + " ");
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
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        int caseNumber = 1;
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            String s = reader.next();
            char[] strArray = s.toCharArray();
            StringBuilder answer = new StringBuilder();
            String temp = "";
            int minDigit = 99;

            for (char c : strArray) {
                if (c != '0') {
                    temp += c;
                    minDigit = Math.min(c - '0', minDigit);
                } else {
                    appendParentheses(answer, temp, minDigit);
                    minDigit = 99;
                    temp = "";
                    answer.append('0');
                }
            }

            if (!temp.isEmpty()) {
                appendParentheses(answer, temp, minDigit);
            }

            result.append("Case #").append(caseNumber++).append(": ").append(answer).append("\n");
        }

        System.out.println(result);
    }

    private static void appendParentheses(StringBuilder answer, String temp, int minDigit) {
        for (int l = 1; l <= minDigit && minDigit != 99; l++) {
            answer.append('(');
        }

        char[] tempArray = temp.toCharArray();
        for (int l = 0; l < tempArray.length; l++) {
            int p = l;
            while (p < tempArray.length && tempArray[p] == tempArray[l]) {
                p++;
            }
            int count = tempArray[l] - '0';
            for (int q = 1; q <= (count - minDigit); q++) {
                answer.append('(');
            }
            answer.append(temp, l, p);
            for (int q = 1; q <= (count - minDigit); q++) {
                answer.append(')');
            }
            l = --p;
        }

        for (int l = 1; l <= minDigit && minDigit != 99; l++) {
            answer.append(')');
        }
    }
}