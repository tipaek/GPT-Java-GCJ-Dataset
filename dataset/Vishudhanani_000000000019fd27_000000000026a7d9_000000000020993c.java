
import java.io.*;
import java.util.*;

public class CJ1 {

    public static void main(String args[]){
         Reader s = new Reader();
         int t = s.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t ; i++) {
            int n = s.nextInt();

            int a[][] = new int[n][n];

            for (int j = 0; j <n ; j++) {
                for (int k = 0; k <n ; k++) {
                    a[j][k] = s.nextInt();

                }
            }
            int trace = 0;

            int r = 0;
            int c = 0;
            for (int j = 0; j < n ; j++) {
                trace += a[j][j];

            }
            for (int j = 0; j < n ; j++) {
                int b[] = new int[n];
                for (int k = 0; k <n ; k++) {
                        b[a[j][k]-1]++;
                        if(b[a[j][k]-1] > 1){
                            r++;
                            break;
                        }
                }
            }
            for (int j = 0; j < n ; j++) {
                int b[] = new int[n];
                for (int k = 0; k <n ; k++) {
                    b[a[k][j]-1]++;
                    if(b[a[k][j]-1] > 1){
                        c++;
                        break;
                    }
                }
            }

            sb.append("Case #").append(i).append(": ").append(trace).append(" ").append(r).append(" ").append(c).append("\n");

        }

        System.out.println(sb);
    }
    static class Reader {

        private InputStream mIs;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream is) {
            mIs = is;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();

            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = mIs.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
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

    }

}
