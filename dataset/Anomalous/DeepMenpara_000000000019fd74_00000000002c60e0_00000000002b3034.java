import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    static void processTestCase(InputReader sc, PrintWriter out, int testcase) {
        int n = sc.nextInt();
        String[] patterns = new String[n];
        Pattern[] patternObjects = new Pattern[n];

        String start = "";
        String end = "";
        boolean invalid = false;

        for (int i = 0; i < n; i++) {
            patterns[i] = sc.next();
            if (invalid) continue;

            int asteriskIndex = patterns[i].indexOf("*");
            patternObjects[i] = new Pattern(patterns[i].substring(0, asteriskIndex), patterns[i].substring(asteriskIndex + 1));

            if (!invalid) {
                if (patternObjects[i].prefixLength != 0 && start.isEmpty()) {
                    start = patternObjects[i].prefix;
                } else if (patternObjects[i].prefixLength != 0) {
                    if (start.length() < patternObjects[i].prefixLength) {
                        String temp = start;
                        start = patternObjects[i].prefix;
                        patternObjects[i].prefix = temp;
                        patternObjects[i].prefixLength = patternObjects[i].prefix.length();
                    }

                    if (!start.startsWith(patternObjects[i].prefix)) {
                        out.println("*");
                        invalid = true;
                    }
                }

                if (!invalid) {
                    if (patternObjects[i].suffixLength != 0 && end.isEmpty()) {
                        end = patternObjects[i].suffix;
                    } else if (patternObjects[i].suffixLength != 0) {
                        if (end.length() < patternObjects[i].suffixLength) {
                            String temp = end;
                            end = patternObjects[i].suffix;
                            patternObjects[i].suffix = temp;
                            patternObjects[i].suffixLength = patternObjects[i].suffix.length();
                        }

                        if (!end.endsWith(patternObjects[i].suffix)) {
                            out.println("*");
                            invalid = true;
                        }
                    }
                }
            }
        }

        if (!invalid) {
            out.println(start + end);
        }
    }

    public void run() {
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            out.print("Case #" + i + ": ");
            processTestCase(sc, out, i);
        }

        out.close();
    }

    static class Pattern {
        String prefix, suffix;
        int prefixLength, suffixLength;

        Pattern(String prefix, String suffix) {
            this.prefix = prefix;
            this.suffix = suffix;
            this.prefixLength = prefix.length();
            this.suffixLength = suffix.length();
        }

        @Override
        public String toString() {
            return "[" + prefix + "," + suffix + "]";
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private final BufferedReader br;

        public InputReader(InputStream stream) {
            this.stream = stream;
            this.br = new BufferedReader(new InputStreamReader(stream));
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
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
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
                result = result * 10 + (c - '0');
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