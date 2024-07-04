import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();
        StringBuilder resultBuilder = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            String input = scanner.next();
            int length = input.length();
            int[] digits = new int[length];

            for (int i = 0; i < length; i++) {
                digits[i] = input.charAt(i) - '0';
            }

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < digits.length; i++) {
                int value = digits[i];

                for (int j = 0; j < value; j++) {
                    if (!stack.isEmpty() && stack.peek() == ')') {
                        stack.pop();
                    } else {
                        stack.push('(');
                    }
                }

                stack.push(input.charAt(i));

                for (int j = 0; j < value; j++) {
                    stack.push(')');
                }
            }

            ArrayList<Character> list = new ArrayList<>(stack.size());
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }

            resultBuilder.append("Case #").append(t + 1).append(": ");
            for (int i = list.size() - 1; i >= 0; i--) {
                resultBuilder.append(list.get(i));
            }
            resultBuilder.append('\n');
        }

        System.out.println(resultBuilder.toString());
    }

    static class FastScanner {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isEndline(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }
}