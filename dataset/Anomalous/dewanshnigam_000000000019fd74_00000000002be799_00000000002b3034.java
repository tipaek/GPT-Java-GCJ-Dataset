import java.io.*;
import java.util.*;

public class Solution {
    public static final long MOD = 1_000_000_007L;
    public static String[] strings;
    public static char[][] charArray;

    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);
        int testCases = in.readInt();
        StringBuilder resultBuilder = new StringBuilder();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = in.readInt();
            strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = in.readString();
            }

            Arrays.sort(strings, new StringLengthComparator());

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
                char kthChar = charArray[0][i];
                boolean mismatchFound = false;
                for (int j = 1; j < n; j++) {
                    if (charArray[j][i] != '*' && charArray[j][i] != kthChar) {
                        mismatchFound = true;
                        break;
                    }
                }
                if (mismatchFound) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                resultBuilder.append("Case #").append(caseNumber).append(": *\n");
            } else {
                resultBuilder.append("Case #").append(caseNumber).append(": ").append(strings[0].substring(1)).append("\n");
            }
            caseNumber++;
        }
        out.printLine(resultBuilder);
        out.close();
    }

    static class StringLengthComparator implements Comparator<String> {
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

        public int readInt() {
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
                result = result * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
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
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
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

        public void printLine(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
            writer.println();
        }

        public void close() {
            writer.close();
        }
    }
}