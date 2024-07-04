import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        InputReader in = new InputReader(inputStream);
        VestigiumSolver solver = new VestigiumSolver();
        int numCases = in.readInt();
        for (int i = 1; i <= numCases; i++) {
            solver.solve(i, in);
        }
    }

    static void print(String s) {
        System.out.println(s);
    }

    static class VestigiumSolver {
        public void solve(int caseNum, InputReader in) {
            int n = in.readInt();
            int trace = 0, rowRepeats = 0, colRepeats = 0;
            int[][] matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                boolean[] rowCheck = new boolean[n + 1];
                boolean duplicateRow = false;
                for (int j = 0; j < n; j++) {
                    int value = in.readInt();
                    if (i == j) trace += value;
                    matrix[i][j] = value;
                    if (rowCheck[value]) duplicateRow = true;
                    rowCheck[value] = true;
                }
                if (duplicateRow) rowRepeats++;
            }

            for (int i = 0; i < n; i++) {
                boolean[] colCheck = new boolean[n + 1];
                boolean duplicateCol = false;
                for (int j = 0; j < n; j++) {
                    int value = matrix[j][i];
                    if (colCheck[value]) duplicateCol = true;
                    colCheck[value] = true;
                }
                if (duplicateCol) colRepeats++;
            }

            print("Case #" + caseNum + ": " + trace + " " + rowRepeats + " " + colRepeats);
        }
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buffer = new byte[1024];
        private int currentChar, numChars;
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
                result = result * 10 + c - '0';
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
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(readString());
            } catch (NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }
}