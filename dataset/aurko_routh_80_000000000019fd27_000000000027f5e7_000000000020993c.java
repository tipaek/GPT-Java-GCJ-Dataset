import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int tc = in.nextInt();
        for(int cc = 1;  cc <= tc; cc++) {
            int n= in.nextInt();

            int[][] mat = new int[n][n];

            int k = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    mat[i][j] = in.nextInt()-1;
                    if(i == j)
                        k += mat[i][j]+1;
                }
            }

            int tR = 0;
            int tC  = 0;

            for(int i = 0; i < n; i++) {
                boolean[] rVis = new boolean[n];
                boolean[] cVis = new boolean[n];

                boolean r = false;
                boolean c = false;

                for(int j = 0; j < n; j++) {
                    if(rVis[mat[j][i]]) {
                        r = true;
                    }
                    if(cVis[mat[i][j]]) {
                        c = true;
                    }
                    rVis[mat[j][i]] = true;
                    cVis[mat[i][j]] = true;
                }

                if(r)
                    tR++;
                if(c)
                    tC++;
            }


            System.out.printf("Case #%d: %d %d %d%n",cc,k,tC,tR);
        }

    }



    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars ;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
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

        String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }

}

