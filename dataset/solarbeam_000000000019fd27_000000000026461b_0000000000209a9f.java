

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        InputStream stream = System.in;
        Logger logger = new Logger();
        if (args.length>1 && args[0].equals("LOCAL") && args[1].equals("YES")) {
            File inputFile = new File("resources/input.in");
            stream = new DataInputStream(new FileInputStream(inputFile));
            logger.enableLogging(true, "resources/logs.txt");
        }
        InputReader in = new InputReader(stream);
        PrintWriter out = new PrintWriter(System.out);
        Thread th = new Thread(null, () -> new Task1().solve(in, out, logger), "Task1", 1 << 24);
        th.start();
        th.join();
        out.close();
        logger.close();
    }

    static class Task1 {
        final String openingBrackets = "(((((((((";
        final String closingBrackets = ")))))))))";

        void solve(InputReader in, PrintWriter out, Logger logger) {
            int t = in.nextInt();
            for(int test=1; test<=t; test++) {
                String s = in.next(), ans = "";
                int open = 0;
                for (int i=0; i<s.length(); i++) {
                    int curr = s.charAt(i)-'0';
                    if (curr > open){
                        ans += openingBrackets.substring(0, curr-open);
                    } else {
                        ans += closingBrackets.substring(0, open-curr);
                    }
                    ans += curr;
                    open = curr;
                }
                ans += closingBrackets.substring(0, open);
                out.println("CASE #"+test+": "+ans);
            }
        }
    }

    static class Logger {
        private PrintWriter logger;
        private boolean loggingEnabled;

        void enableLogging(boolean enable, String filename) {
            this.loggingEnabled = enable;
            try {
                if (loggingEnabled) this.logger = new PrintWriter(filename);
            } catch (FileNotFoundException ignored) {
            }
        }

        void log(Object s) {
            if (loggingEnabled) {
                logger.print(s.toString());
            }
        }

        void logln(Object s) {
            if (loggingEnabled) {
                logger.println(s.toString());
            }
        }

        void close() {
            if (loggingEnabled) logger.close();
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, numChars;
        private SpaceCharFilter filter;

        InputReader(InputStream stream) {
            this.stream = stream;
        }

        int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}
