import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Karanjot Singh
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        PatternMatching solver = new PatternMatching();
        solver.solve(1, in, out);
        out.close();
    }

    static class PatternMatching {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int t = in.nextInt();
            for (int test = 1; test <= t; test++) {
                int n = in.nextInt();
                String arr[] = new String[n];
                for (int i = 0; i < n; i++) arr[i] = in.nextString();
                String maxString = "";
                int index = -1;
                for (int i = 0; i < n; i++) {
                    if (maxString.length() < arr[i].length()) {
                        maxString = arr[i];
                        index = i;
                    }
                }
                maxString = maxString.replace("*", "");
                boolean isPossible = true;
                for (int i = 0; i < n; i++) {
                    int tempIndex = 0;
                    int tempIndex2 = 0;

                    for (int j = 0; j < arr[i].length(); j++) {
                        if (arr[i].charAt(j) == '*') {
                            String te = arr[i].substring(tempIndex2, j + 1);
                            te = te.replace("*", "");
                            if (te.length() > 0) {
                                if (maxString.indexOf(te, tempIndex) != -1) {
                                    tempIndex = maxString.indexOf(te, tempIndex) + te.length();
                                    tempIndex2 = j + 1;
                                } else {
                                    isPossible = false;
                                    break;
                                }
                            } else {
                                tempIndex2 = tempIndex2 + 1;
                            }
                        } else if (arr[i].length() - 1 == j) {
                            String te = arr[i].substring(tempIndex2, j + 1);
                            te = te.replace("*", "");
                            if (te.length() > 0) {
                                if (maxString.indexOf(te, tempIndex) != -1) {
                                    tempIndex = maxString.indexOf(te, tempIndex) + te.length();
                                    tempIndex2 = j + 1;
                                } else {
                                    isPossible = false;
                                    break;
                                }
                            } else {
                                tempIndex2 = tempIndex2 + 1;
                            }
                        }
                    }
                    if (!isPossible) break;

                }
                out.println("Case #" + test + ": " + (isPossible ? maxString : "*"));
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

        public int read() {
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

        public int nextInt() {
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

        public String nextString() {
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

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

