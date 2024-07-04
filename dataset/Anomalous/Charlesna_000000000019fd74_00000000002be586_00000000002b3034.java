import java.io.*;
import java.util.InputMismatchException;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= testCases; i++) {
            int N = Integer.parseInt(in.nextLine());
            String[] patterns = new String[N];
            for (int j = 0; j < N; j++) {
                patterns[j] = in.nextLine().trim();
            }
            processPatterns(patterns, i, out);
        }
        out.flush();
        out.close();
    }

    private static void processPatterns(String[] patterns, int testCaseNumber, PrintWriter out) {
        int length = patterns.length;
        int[][] indices = new int[length][2];
        String prefix = "", suffix = "";

        for (int i = 0; i < length; i++) {
            String pattern = patterns[i];
            int patternLength = pattern.length();
            int left = 0, right = patternLength - 1;

            while (left <= right && pattern.charAt(left) != '*') {
                if (left < prefix.length() && pattern.charAt(left) != prefix.charAt(left)) {
                    out.println("Case #" + testCaseNumber + ": " + "*");
                    return;
                }
                left++;
            }

            while (left <= right && pattern.charAt(right) != '*') {
                if (patternLength - right - 1 < suffix.length() && pattern.charAt(right) != suffix.charAt(suffix.length() - (patternLength - right))) {
                    out.println("Case #" + testCaseNumber + ": " + "*");
                    return;
                }
                right--;
            }

            if (left > prefix.length()) prefix = pattern.substring(0, left);
            if (patternLength - right - 1 > suffix.length()) suffix = pattern.substring(right + 1);

            indices[i][0] = left + 1;
            indices[i][1] = right - 1;
        }

        StringBuilder result = new StringBuilder();
        result.append(prefix);
        for (int i = 0; i < length; i++) {
            for (int j = indices[i][0]; j <= indices[i][1]; j++) {
                if (patterns[i].charAt(j) != '*') {
                    result.append(patterns[i].charAt(j));
                }
            }
        }
        result.append(suffix);
        out.println("Case #" + testCaseNumber + ": " + result.toString());
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
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
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c < '0' || c > '9') throw new InputMismatchException();
                    m /= 10;
                    result += (c - '0') * m;
                    c = read();
                }
            }
            return result * sign;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
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

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}