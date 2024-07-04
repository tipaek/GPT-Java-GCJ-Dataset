import java.io.IOException;
import java.io.InputStream;
import java.util.BitSet;
import java.util.InputMismatchException;


public class Solution {

    public static void main(String[] args) {
        InputReader ir = new InputReader(System.in);
        int t = ir.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            testCase(ir, i);
        }
    }

    private static void testCase(InputReader ir, int k) {
        int n = ir.nextInt();
        int expectedResult = (n * (n + 1)) / 2;
        
        int[][] matrix = new int[n][n];
        
        // Build the matrix
        for (int i = 0; i < n; ++i) {
            matrix[i] = ir.nextIntArray(n);
        }
        
        // Compute all required information
        int trace = 0;
        int pbRow = 0;
        int pbColumn = 0;
        
        for (int i = 0; i < n; ++i) {
            BitSet bH = new BitSet(n);
            BitSet bV = new BitSet(n);
            
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    trace += matrix[i][j];
                }
                
                bH.flip(matrix[i][j]);
                bV.flip(matrix[j][i]);
            }
            
            if (bH.cardinality() != n) {
                pbRow++;
            }
            
            if (bV.cardinality() != n) {
                pbColumn++;
            }
        }
        
        System.out.println("Case #" + k + ": " + trace + " " + pbRow + " " + pbColumn);
    }
    
    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;
        
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        
        public int snext() {
            if (snumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
        
        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        
        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
        
        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
        
        public long[] nextLongArray(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }
        
        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }
        
        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }
        
        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
        
        public interface SpaceCharFilter {

            public boolean isSpaceChar(int ch);
        }
    }
}
