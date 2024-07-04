
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

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

        List<String> ansX, ansY;
        void solve(InputReader in, PrintWriter out, Logger logger) {
            int t = in.nextInt();
            for(int test=1; test<=t; test++) {
                int x = in.nextInt(), y = in.nextInt();
                boolean negX = x<0, negY = y<0, impossible = false;

                StringBuilder bx = new StringBuilder(Integer.toBinaryString(Math.abs(x))).reverse();
                StringBuilder by = new StringBuilder(Integer.toBinaryString(Math.abs(y))).reverse();

                logger.logln(bx+" "+by);
                if (bx.charAt(0) == by.charAt(0)) {
                    out.println("CASE #"+test+": IMPOSSIBLE");
                    continue;
                }

                ansX = new ArrayList<>();
                ansY = new ArrayList<>();
                if (noClash(bx, by, negX, negY)) {
                    out.print("CASE #"+test+": ");
                    String ans = "";
                    for (int i=0; i<Math.max(bx.length(), by.length()); i++) {
                        if (ansX.get(i).equals("_")) {
                            ans += ansY.get(i);
                        } else {
                            ans += ansX.get(i);
                        }
                    }
                    out.println(ans);
                    continue;
                }

                int px = clashingSolvable(bx, by);
                logger.logln("PX:"+px);
                ansX = new ArrayList<>();
                ansY = new ArrayList<>();
                if (px > 0) {
                    StringBuilder bx2 = new StringBuilder(bx.toString());
                    for (int i=1; i<px; i++) { bx2.setCharAt(i, '0'); }
                    if (px >= bx2.length()) { bx2.append('1'); } else { bx2.setCharAt(px, '1'); }

                    logger.logln("bx2: "+bx2);

                    if(noClash(bx2, by, negX, negY)){
                        ansX.set(0, rev(ansX.get(0).charAt(0)));
                        out.print("CASE #"+test+": ");
                        String ans = "";
                        for (int i=0; i<Math.max(bx2.length(), by.length()); i++) {
                            if (ansX.get(i).equals("_")) {
                                ans += ansY.get(i);
                            } else {
                                ans += ansX.get(i);
                            }
                        }
                        out.println(ans);
                        continue;
                    }

                }

                int py = clashingSolvable(by, bx);
                logger.logln("PY:"+py);

                ansX = new ArrayList<>();
                ansY = new ArrayList<>();
                if (py > 0) {
                    StringBuilder by2 = new StringBuilder(by.toString());
                    for (int i=1; i<py; i++) { by2.setCharAt(i, '0'); }
                    if (py >= by2.length()) { by2.append('1'); } else { by2.setCharAt(py, '1'); }

                    logger.logln("by2: "+by2);

                    if(noClash(bx, by2, negX, negY)){
                        ansY.set(0, rev(ansY.get(0).charAt(0)));
                        out.print("CASE #"+test+": ");
                        String ans = "";
                        for (int i=0; i<Math.max(by2.length(), bx.length()); i++) {
                            if (ansX.get(i).equals("_")) {
                                ans += ansY.get(i);
                            } else {
                                ans += ansX.get(i);
                            }
                        }
                        out.println(ans);
                        continue;
                    }
                }


                out.println("CASE #"+test+": IMPOSSIBLE");
            }

        }

        boolean noClash(StringBuilder bx, StringBuilder by, boolean negX, boolean negY) {
            for (int i=0; i<Math.max(bx.length(), by.length()); i++) {
                int x = 0, y = 0;
                if (i < bx.length()) {
                    x = bx.charAt(i) - '0';
                }
                if (i < by.length()) {
                    y = by.charAt(i) - '0';
                }
                if (x == y) {
                    return false;
                }
                if (x > 0) {
                    if (negX) {
                        ansX.add("W");
                    } else {
                        ansX.add("E");
                    }
                    ansY.add("_");
                } else {
                    if (negY) {
                        ansY.add("S");
                    } else {
                        ansY.add("N");
                    }
                    ansX.add("_");
                }
            }
            return true;
        }

        String rev(char x) {
            if (x == 'E') {
                return "W";
            }
            if (x == 'W') {
                return "E";
            }
            if (x == 'N') {
                return "S";
            }
            if (x == 'S') {
                return "N";
            }
            return "_";
        }

        int clashingSolvable(StringBuilder b, StringBuilder other) {
            int pointX = -1;
            if (b.charAt(0) == '1' && other.charAt(0)=='0') {
                pointX = 1;
                while (pointX < b.length() && b.charAt(pointX) == '1') {
                    if (other.length()>pointX && other.charAt(pointX)=='1') {
                        pointX++;
                    } else {
                        return -1;
                    }
                }
            }
            return pointX;
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
