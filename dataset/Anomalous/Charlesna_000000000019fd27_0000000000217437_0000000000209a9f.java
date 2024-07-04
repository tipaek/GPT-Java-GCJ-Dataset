import java.io.*;
import java.util.InputMismatchException;
import java.util.Stack;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            String s = in.nextLine();
            processString(s, w, i);
        }
        w.flush();
        w.close();
    }

    private static void processString(String s, PrintWriter w, int caseNumber) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty() || chars[i] >= chars[stack.peek()]) {
                int diff = stack.isEmpty() ? chars[i] - '0' : chars[i] - chars[stack.peek()];
                for (int j = 0; j < diff; j++) {
                    result.append('(');
                }
                result.append(chars[i]);
                stack.push(i);
            } else {
                int diff = chars[stack.peek()] - chars[i];
                while (!stack.isEmpty() && chars[i] < chars[stack.peek()]) {
                    stack.pop();
                }
                for (int j = 0; j < diff; j++) {
                    result.append(')');
                }
                result.append(chars[i]);
                stack.push(i);
            }
        }

        if (!stack.isEmpty()) {
            for (int i = 0; i < chars[stack.peek()] - '0'; i++) {
                result.append(')');
            }
        }

        w.println("Case #" + caseNumber + ": " + result);
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
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
                result = result * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
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
                result = result * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public double nextDouble() {
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
                    return result * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return result * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    result += (c - '0') * m;
                    c = read();
                }
            }
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

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}