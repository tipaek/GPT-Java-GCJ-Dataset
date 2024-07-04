import java.io.*;
import java.util.InputMismatchException;

public class Solution {

    public static FastReader reader = new FastReader();
    public static OutputWriter writer = new OutputWriter();

    public static void main(String[] args) throws IOException {
        int T = reader.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int X = reader.nextInt();
            int Y = reader.nextInt();
            String M = reader.next();
            int time = 0;
            boolean found = false;
            int result = -1;

            for (int i = 0; i < M.length(); i++) {
                if (Math.abs(X) + Math.abs(Y) <= i) {
                    found = true;
                    result = i;
                    break;
                }
                char direction = M.charAt(i);
                switch (direction) {
                    case 'N': Y++; break;
                    case 'E': X++; break;
                    case 'W': X--; break;
                    case 'S': Y--; break;
                }
            }

            if (Math.abs(X) + Math.abs(Y) <= M.length()) {
                found = true;
                result = M.length();
            }

            writer.print("Case #" + cs + ": ");
            if (found) {
                writer.println(result);
            } else {
                writer.println("IMPOSSIBLE");
            }
        }
        writer.flush();
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter() {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        }

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void println(Object... objects) {
            print(objects);
            writer.println();
        }

        public void flush() {
            writer.flush();
        }

        public void close() {
            writer.close();
        }
    }

    static class FastReader {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int bufferPointer, bytesRead;

        public int next() throws IOException {
            if (bufferPointer == bytesRead) {
                bufferPointer = 0;
                bytesRead = in.read(buffer);
                if (bytesRead == -1) throw new InputMismatchException();
            }
            return buffer[bufferPointer++];
        }

        public int nextInt() throws IOException {
            int c = next(), sign = 1, result = 0;
            while (isWhitespace(c)) c = next();
            if (c == '-') {
                sign = -1;
                c = next();
            }
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = next();
            } while (!isWhitespace(c));
            return sign * result;
        }

        public long nextLong() throws IOException {
            int c = next(), sign = 1;
            long result = 0;
            while (isWhitespace(c)) c = next();
            if (c == '-') {
                sign = -1;
                c = next();
            }
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = next();
            } while (!isWhitespace(c));
            return sign * result;
        }

        public double nextDouble() throws IOException {
            int c = next(), sign = 1;
            double result = 0, factor = 1;
            while (isWhitespace(c)) c = next();
            if (c == '-') {
                sign = -1;
                c = next();
            }
            do {
                if (c == '.') {
                    c = next();
                    while (!isWhitespace(c)) {
                        result += (c - '0') / (factor *= 10);
                        c = next();
                    }
                    return result * sign;
                }
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = next();
            } while (!isWhitespace(c));
            return result * sign;
        }

        public String next() throws IOException {
            StringBuilder sb = new StringBuilder();
            int c = next();
            while (isWhitespace(c)) c = next();
            do {
                sb.append((char) c);
                c = next();
            } while (!isWhitespace(c));
            return sb.toString();
        }

        private boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}