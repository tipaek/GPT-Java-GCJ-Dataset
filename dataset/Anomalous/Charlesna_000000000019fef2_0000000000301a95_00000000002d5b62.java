import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCaseCount = in.nextInt();
        for (int i = 1; i <= testCaseCount; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            processCase(x, y, out, i);
        }
        out.flush();
        out.close();
    }

    private static void processCase(int x, int y, PrintWriter out, int caseNumber) {
        boolean isWest = x < 0;
        boolean isSouth = y < 0;
        x = Math.abs(x);
        y = Math.abs(y);

        if ((x ^ y & 1) == 0) {
            out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            return;
        }

        StringBuilder result = new StringBuilder();
        int westMoves = 0, southMoves = 0;

        for (int i = 1; i < 31 && (1 << i) <= x && (1 << i) <= y; i++) {
            int xBit = x >> i & 1;
            int yBit = y >> i & 1;

            if (xBit == 0 && yBit == 0) {
                if ((westMoves >> i & 1) == 1 || (southMoves >> i & 1) == 1) continue;

                for (int j = i - 1; j >= 0; j--) {
                    if ((x >> j & 1) == 1 || (westMoves >> j & 1) == 1) {
                        x += (1 << j);
                        westMoves += (1 << j);
                        i = j;
                        break;
                    } else if ((y >> j & 1) == 1 || (southMoves >> j & 1) == 1) {
                        y += (1 << j);
                        southMoves += (1 << j);
                        i = j;
                        break;
                    }
                }
            } else if (xBit == 1 && yBit == 1) {
                int j = i - 1;
                if ((x >> (i - 1) & 1) == 0) {
                    while ((y >> j & 1) == 1) {
                        j--;
                    }
                    j++;
                    y += (1 << j);
                    southMoves += (1 << j);
                } else {
                    while ((x >> j & 1) == 1) {
                        j--;
                    }
                    j++;
                    x += (1 << j);
                    westMoves += (1 << j);
                }
                i = j;
            }
        }

        for (int i = 0; i < 31; i++) {
            if ((westMoves >> i & 1) == 1) {
                result.append(isWest ? "E" : "W");
            } else if ((southMoves >> i & 1) == 1) {
                result.append(isSouth ? "N" : "S");
            } else if ((x >> i & 1) == 1) {
                result.append(isWest ? "W" : "E");
            } else if ((y >> i & 1) == 1) {
                result.append(isSouth ? "S" : "N");
            } else {
                break;
            }
        }

        out.println("Case #" + caseNumber + ": " + result.toString());
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
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
            while (isSpaceChar(c))
                c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                result *= 10;
                result += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                result *= 10;
                result += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return result * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                result *= 10;
                result += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return result * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    result += (c - '0') * m;
                    c = read();
                }
            }
            return result * sign;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}