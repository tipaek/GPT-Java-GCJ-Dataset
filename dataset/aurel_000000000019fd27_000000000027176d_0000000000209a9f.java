import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) {
        InputReader ir = new InputReader(System.in);
        int t = ir.nextInt();
        
        for (int i = 1; i <= t; ++i) {
            testCase(ir, i);
        }
    }

    private static void testCase(InputReader ir, int cas) {
        StringBuilder sb = new StringBuilder();
        String s = ir.nextLine();
        
        int currentOpen = 0;
        int currentClose = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            int digit = s.charAt(i) - '0';
            
            if (digit > currentOpen) {
                int neededPar = digit - currentOpen;
                appendOpen(sb, neededPar);
                
                currentOpen += neededPar;
                sb.append(digit);
            } else {
                int tooMuch = currentOpen - digit;
                appendClose(sb, tooMuch);
                
                currentOpen -= tooMuch;
                sb.append(digit);
            }
        }
        
        appendClose(sb, currentOpen);
        System.out.println("Case #" + cas + ": " + sb.toString());
    }
    
    private static void appendOpen(StringBuilder sb, int n) {
        for (int i = 0; i < n; ++i) {
            sb.append('(');
        }
    }
    
    private static void appendClose(StringBuilder sb, int n) {
        for (int i = 0; i < n; ++i) {
            sb.append(')');
        }
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
