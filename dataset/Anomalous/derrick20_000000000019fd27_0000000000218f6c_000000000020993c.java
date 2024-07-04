import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastScanner sc = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int T = sc.nextInt();
        int testCase = 1;
        while (T-- > 0) {
            int N = sc.nextInt();
            int[][] grid = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            int rowCt = 0, colCt = 0, trace = 0;
            for (int i = 0; i < N; i++) {
                Set<Integer> row = new HashSet<>();
                Set<Integer> col = new HashSet<>();
                boolean rowRepeat = false, colRepeat = false;
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        trace += grid[i][j];
                    }
                    if (!row.add(grid[i][j])) {
                        rowRepeat = true;
                    }
                    if (!col.add(grid[j][i])) {
                        colRepeat = true;
                    }
                }
                if (rowRepeat) rowCt++;
                if (colRepeat) colCt++;
            }

            out.printf("Case #%d: %d %d %d\n", testCase++, trace, rowCt, colCt);
        }
        out.close();
    }

    static class FastScanner {
        private final int BUFFER_SIZE = 1 << 16;
        private final char NULL_CHAR = (char) 0;
        private final byte[] buffer = new byte[BUFFER_SIZE];
        private int bufferId = 0, bufferSize = 0;
        private char currentChar = NULL_CHAR;
        private double count = 1;
        private final BufferedInputStream inputStream;

        public FastScanner() {
            inputStream = new BufferedInputStream(System.in, BUFFER_SIZE);
        }

        public FastScanner(String fileName) {
            BufferedInputStream tempStream;
            try {
                tempStream = new BufferedInputStream(new FileInputStream(new File(fileName)), BUFFER_SIZE);
            } catch (Exception e) {
                tempStream = new BufferedInputStream(System.in, BUFFER_SIZE);
            }
            inputStream = tempStream;
        }

        private char getChar() {
            while (bufferId == bufferSize) {
                try {
                    bufferSize = inputStream.read(buffer);
                } catch (Exception e) {
                    return NULL_CHAR;
                }
                if (bufferSize == -1) return NULL_CHAR;
                bufferId = 0;
            }
            return (char) buffer[bufferId++];
        }

        public int nextInt() {
            return (int) nextLong();
        }

        public long nextLong() {
            count = 1;
            boolean negative = false;
            if (currentChar == NULL_CHAR) currentChar = getChar();
            while (currentChar < '0' || currentChar > '9') {
                if (currentChar == '-') negative = true;
                currentChar = getChar();
            }
            long result = 0;
            while (currentChar >= '0' && currentChar <= '9') {
                result = (result << 3) + (result << 1) + currentChar - '0';
                currentChar = getChar();
                count *= 10;
            }
            return negative ? -result : result;
        }

        public double nextDouble() {
            double result = nextLong();
            return currentChar != '.' ? result : result + nextLong() / count;
        }

        public String next() {
            StringBuilder result = new StringBuilder();
            while (currentChar <= 32) currentChar = getChar();
            while (currentChar > 32) {
                result.append(currentChar);
                currentChar = getChar();
            }
            return result.toString();
        }

        public boolean hasNext() {
            if (currentChar > 32) return true;
            while (true) {
                currentChar = getChar();
                if (currentChar == NULL_CHAR) return false;
                if (currentChar > 32) return true;
            }
        }
    }
}