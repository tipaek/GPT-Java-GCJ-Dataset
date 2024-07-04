import java.io.*;
import java.util.*;

public class Solution {
    public static final long MOD = 1_000_000_007L;
    public static String[] strings;
    public static char[][] charArray;

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int t = in.readInt();
        StringBuilder sb = new StringBuilder();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = in.readInt();
            strings = new String[n];

            for (int i = 0; i < n; i++) {
                strings[i] = in.readString();
            }

            Arrays.sort(strings, new LengthComparator());

            charArray = new char[n][101];
            for (int i = 0; i < n; i++) {
                Arrays.fill(charArray[i], '*');
            }

            for (int i = 0; i < strings.length; i++) {
                int k = 100;
                for (int j = strings[i].length() - 1; j >= 0; j--) {
                    charArray[i][k--] = strings[i].charAt(j);
                }
            }

            boolean isPossible = true;
            for (int i = 100; i >= 1; i--) {
                char currentChar = charArray[0][i];
                if (currentChar == '*') {
                    break;
                }
                boolean mismatch = false;
                for (int j = 1; j < n; j++) {
                    if (charArray[j][i] != '*' && charArray[j][i] != currentChar) {
                        mismatch = true;
                        break;
                    }
                }
                if (mismatch) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                sb.append("Case #").append(caseNumber).append(": *\n");
            } else {
                Arrays.sort(strings, new LengthComparator());
                sb.append("Case #").append(caseNumber).append(": ").append(strings[0].substring(1)).append("\n");
            }
            caseNumber++;
        }

        out.printLine(sb);
        out.close();
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int pow(int a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a;
        if (a > MOD) a %= MOD;
        long aa = a;
        int product = (int) ((aa * aa) % MOD);
        int result = pow(product, b / 2);
        if ((b & 1) != 0) {
            result = (int) ((result * aa) % MOD);
        }
        return result;
    }

    static class LengthComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return b.length() - a.length();
        }
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private SpaceCharFilter filter;

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

        public int readInt() {
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

        public long readLong() {
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
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }
    }
}