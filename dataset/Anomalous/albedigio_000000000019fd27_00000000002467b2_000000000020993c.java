import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;

public class Solution {
    private static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentIndex;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentIndex >= numChars) {
                currentIndex = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentIndex++];
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
                result = result * 10 + (c - '0');
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

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return result * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return result * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    result += (c - '0') * m;
                    c = read();
                }
            }
            return result * sign;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        private boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int testCases = in.readInt();
        
        for (int i = 0; i < testCases; i++) {
            int n = in.readInt();
            HashMap<Integer, HashSet<Integer>> rowSets = new HashMap<>(n);
            HashMap<Integer, HashSet<Integer>> colSets = new HashMap<>(n);
            int trace = 0;

            for (int row = 0; row < n; row++) {
                rowSets.put(row, new HashSet<>(n));
                for (int col = 0; col < n; col++) {
                    int value = in.readInt();
                    if (row == 0) {
                        colSets.put(col, new HashSet<>(n));
                    }
                    rowSets.get(row).add(value);
                    colSets.get(col).add(value);
                    if (row == col) {
                        trace += value;
                    }
                }
            }

            int duplicateRows = 0;
            int duplicateCols = 0;
            for (int j = 0; j < n; j++) {
                if (rowSets.get(j).size() != n) {
                    duplicateRows++;
                }
                if (colSets.get(j).size() != n) {
                    duplicateCols++;
                }
            }

            sb.append("Case #").append(i + 1).append(": ").append(trace).append(" ").append(duplicateRows).append(" ").append(duplicateCols).append('\n');
        }
        System.out.print(sb);
    }
}