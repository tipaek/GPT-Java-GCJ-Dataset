
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.InputMismatchException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author EndUser
 */
public class Solution {
    
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        BufferedWriter w = new BufferedWriter(new OutputStreamWriter(System.out));
        int limit = 30;
        
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            String s = in.nextLine();
            StringBuilder output = new StringBuilder();
            int currentHeight = 0;
            for (int j = 0; j < s.length(); j++) {
                int height  = s.charAt(j) - '0';
                char c = ')';
                if (height > currentHeight) {
                    c = '(';
                }
                for (int k = 0; k < Math.abs(height - currentHeight); k++) {
                    output.append(c);
                }
                output.append(s.charAt(j));
                currentHeight = height;
            }
            
            for (int j = 0; j < currentHeight; j++) {
                output.append(')');
            }
            
            w.write("Case #" + i + ": " + output);
            w.newLine();
        }
        w.close();
    }
    
    
    public static boolean checkDuplicatedRow(int[][] a, int n, int i) {
        int[] count = new int[n + 1];
        for (int j = 0; j < n; j++) {
            if (count[a[i][j]] != 0) {
                return true;
            }
            count[a[i][j]] += 1;
        }
        return false;
    }

    public static boolean checkDuplicatedColumn(int[][] a, int n, int i) {
        int[] count = new int[n + 1];
        for (int j = 0; j < n; j++) {
            if (count[a[j][i]] != 0) {
                return true;
            }
            count[a[j][i]] += 1;
        }
        return false;
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
