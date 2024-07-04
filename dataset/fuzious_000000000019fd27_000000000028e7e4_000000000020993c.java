/*
    by Fuzious
    9/26/2019
*/

import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        InputReader sc = new InputReader(System.in);
        int TC = sc.nextInt();
        for (int tc = 0; tc < TC; tc++) {
            int N=sc.nextInt();
            int[][] arr=new int[N][N];
            long row=0;
            int col=0;
            int dia=0;
            for (int i = 0; i < N; i++) {
                HashSet<Integer> HS=new HashSet<>();
                for (int j = 0; j < N; j++) {
                    arr[i][j]=sc.nextInt();
                    HS.add(arr[i][j]);
                }
                if(HS.size()<N)
                    row++;
            }
            for (int i = 0; i < N; i++) {
                HashSet<Integer> HS=new HashSet<>();
                for (int j = 0; j < N; j++) {
                    HS.add(arr[j][i]);
                }
                if(HS.size()<N)
                    col++;
            }
            for (int i = 0; i < N; i++) {
                dia+=arr[i][i];
            }
            out.println("Case #"+(tc+1)+": "+dia+" "+row+" "+col);
        }
        out.close();
    }


    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    static int mod = 1000000000 + 7;
    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
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
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
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
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
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
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public double nextDouble() {
            return (Double.parseDouble(readString()));
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
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
