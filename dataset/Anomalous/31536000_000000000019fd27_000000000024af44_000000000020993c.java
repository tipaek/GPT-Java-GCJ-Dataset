import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        new Solution();
    }

    public Solution() {
        FastScanner scanner = new FastScanner();
        int testCases = scanner.nextInt();
        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            int trace = calculateTrace(matrix, n);
            int rowDuplicates = countRowDuplicates(matrix, n);
            int colDuplicates = countColDuplicates(matrix, n);
            System.out.printf("Case #%d: %d %d %d%n", caseNum, trace, rowDuplicates, colDuplicates);
        }
    }

    private int calculateTrace(int[][] matrix, int size) {
        int trace = 0;
        for (int i = 0; i < size; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    private int countRowDuplicates(int[][] matrix, int size) {
        int duplicateRows = 0;
        for (int i = 0; i < size; i++) {
            Set<Integer> rowSet = new HashSet<>();
            for (int j = 0; j < size; j++) {
                rowSet.add(matrix[i][j]);
            }
            if (rowSet.size() != size) {
                duplicateRows++;
            }
        }
        return duplicateRows;
    }

    private int countColDuplicates(int[][] matrix, int size) {
        int duplicateCols = 0;
        for (int j = 0; j < size; j++) {
            Set<Integer> colSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                colSet.add(matrix[i][j]);
            }
            if (colSet.size() != size) {
                duplicateCols++;
            }
        }
        return duplicateCols;
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            }
            ptr = 0;
            try {
                buflen = in.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return buflen > 0;
        }

        private int readByte() {
            return hasNextByte() ? buffer[ptr++] : -1;
        }

        private static boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr])) {
                ptr++;
            }
            return hasNextByte();
        }

        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            long number = 0;
            boolean isNegative = false;
            int b = readByte();
            if (b == '-') {
                isNegative = true;
                b = readByte();
            }
            if (b < '0' || b > '9') {
                throw new NumberFormatException();
            }
            while (true) {
                if ('0' <= b && b <= '9') {
                    number = number * 10 + (b - '0');
                } else if (b == -1 || !isPrintableChar(b)) {
                    return isNegative ? -number : number;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        public int nextInt() {
            long number = nextLong();
            if (number < Integer.MIN_VALUE || number > Integer.MAX_VALUE) {
                throw new NumberFormatException();
            }
            return (int) number;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}