import java.io.*;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        esab_atad solver = new esab_atad();
        solver.solve(1, in, out);
        out.close();
    }

    static class esab_atad {
        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int t = in.readInt();
            int b = in.readInt();
            while (t-- > 0) {
                int [] arr = new int [b];
                for (int i=0;i<b;i++) {
                    double x = Math.random();
                    if (x >= 0.5) arr[i] = 1;
                    else arr[i] = 0;
                }
                for (int i=0;i<5;i++) {
                    int x = (int)(Math.random()*b + 1);
                    out.printLine(x);
                    out.flush();
                    if (i%10 == 0) {
                        int y = (int)(Math.random()*4 + 1);
                        if (y==1) complement(arr,b);
                        else if (y==2) reverse(arr,b);
                        else if (y==3) {
                            complement(arr,b);
                            reverse(arr,b);
                        }
                    }
                    if (i != 4) {
                        int y = in.readInt();
                        if (arr[x-1] != y) complement(arr,b);
                    }
                }
                for (int i=0;i<b;i++)
                    out.print(arr[i] + " ");
                out.printLine();
                out.flush();
                String c = in.readString();
                if (c.equals("N")) break;
            }
        }
        private void complement (int [] arr , int b) {
            for (int i=0;i<b;i++)
                arr[i] = arr[i]^1;
            return;
        }
        private void reverse (int [] arr , int b) {
            for (int i=0;i<b/2;i++) {
                int temp = arr[i];
                arr[i] = arr[b-1-i];
                arr[b-1-i] = temp;
            }
            return;
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

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

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

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void printLine(char[] array) {
            writer.println(array);
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }
}
