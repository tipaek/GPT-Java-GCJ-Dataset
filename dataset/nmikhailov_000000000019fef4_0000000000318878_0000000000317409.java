import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Nikita Mikhailov
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        OverexcitedFan solver = new OverexcitedFan();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OverexcitedFan {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int x = in.readInt();
            int y = in.readInt();
            String str = in.readString();

            int curPosX = x;
            int curPosY = y;

            MinMaxCounter<Integer> mmc = new MinMaxCounter<>();

            for (int i = 0; i < str.length() + 1; i++) {
                int timeToReach = Math.abs(curPosX) + Math.abs(curPosY);
                int targetTime = i;

                if (targetTime >= timeToReach) {
                    mmc.min(targetTime);
                }

                if (i < str.length()) {
                    switch (str.charAt(i)) {
                        case 'N':
                            curPosY++;
                            break;
                        case 'S':
                            curPosY--;
                            break;
                        case 'E':
                            curPosX++;
                            break;
                        case 'W':
                            curPosX--;
                            break;
                    }
                }
            }


            if (mmc.has()) {
                out.println("Case #" + testNumber + ": " + mmc.get());
            } else {
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            }

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

    }

    static class MinMaxCounter<T extends Comparable<T>> {
        private T value;
        private boolean init;

        public MinMaxCounter(T startValue) {
            init = true;
            value = startValue;
        }

        public MinMaxCounter() {
            init = false;
        }

        public MinMaxCounter<T> min(T a) {
            if (init) {
                value = value.compareTo(a) < 0 ? value : a;
            } else {
                value = a;
                init = true;
            }
            return this;
        }

        public T get() {
            if (init) {
                return value;
            } else {
                return null;
            }
        }

        public boolean has() {
            return init;
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private int read() {
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
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
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

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

