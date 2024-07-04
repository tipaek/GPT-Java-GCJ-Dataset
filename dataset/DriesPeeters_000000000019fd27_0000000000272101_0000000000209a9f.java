import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

    private static final String fileLoc = "NestingDepth/src/in/";
    private static final String[] fileNames = new String[]{"test1"};

    static class LineOfNumbers {
        public int[] numbers;
        public int length;

        public LineOfNumbers(int length) {
            this.length = length;
            numbers = new int[length];
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < length; i++) {
                b.append(numbers[i]);
            }
            return b.toString();
        }
    }

    public static void main(String[] args) throws Exception {
        curFile = 0; // current file to scan
        start(false);
    }

    static int curFile = 0;
    static LineOfNumbers[] lines;
    static int T, N, C;

    static void start(boolean isLocal) throws Exception {
        final long startTime = System.currentTimeMillis();
        // READ
        readData(isLocal);
        solve();
    }

    private static void solve() {
        for (int i = 0; i < T; i++) {
            solveLine(i);
        }
    }

    private static void solveLine(int lineId) {
        LineOfNumbers line = lines[lineId];
        StringBuilder out = new StringBuilder();
        int depth = 0;
        int currentNumber;
        for (int i = 0; i < line.length; i++) {
            currentNumber = line.numbers[i];

            if (currentNumber == depth) {
                out.append(currentNumber);
                continue;
            }

            if (currentNumber > depth) {
                int diff = currentNumber - depth;
                for (int j = 0; j < diff; j++) {
                    out.append("(");
                    ++depth;
                }
                out.append(currentNumber);
                continue;
            }

            if (currentNumber < depth) {
                int diff = depth - currentNumber;
                for (int j = 0; j < diff; j++) {
                    out.append(")");
                    --depth;
                }
                out.append(currentNumber);
                continue;
            }
        }

        // close still opened parenthesis
        while (depth > 0) {
            out.append(")");
            --depth;
        }


        printCase(lineId + 1, out.toString());
    }

    private static void printCase(int caseNr, String newline) {
        System.out.println("Case #" + caseNr + ": " + newline);
    }

    private static void readData(boolean isLocal) throws Exception {
        final InputReader in = new InputReader(isLocal ? (new FileInputStream((fileLoc + fileNames[curFile] + ".in"))) : System.in);
        T = in.readInt(); // number of test cases
        lines = new LineOfNumbers[T];
        for (int s = 0; s < T; s++) {
            String strLine = in.readLine();
            int lineLength = strLine.length();
            LineOfNumbers line = new LineOfNumbers(lineLength);
            for (int i = 0; i < lineLength; i++) {
                line.numbers[i] = Integer.parseInt("" + strLine.charAt(i));
            }

            lines[s] = line;
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
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

        public char readChar() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char) c;
        }

        public String readLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String readString() {
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

        public long readLong() {
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

        public int readInt() {
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
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public void close() {
            try {
                stream.close();
            } catch (Exception ex) {
                System.err.println("failed to close stream");
            }
        }
    }
}
