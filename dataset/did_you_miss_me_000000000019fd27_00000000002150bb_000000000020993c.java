import java.io.*;
import java.util.*;
import java.lang.*;


class Solution implements Runnable {
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
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

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static void main(String args[]) throws Exception {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }

    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        int t = in.nextInt();
        int temp = t;
        while(t-- != 0){

            int n = in.nextInt();
            int a[][] = new int[n][n];

            for (int i = 0; i < n; i++ ){
                for (int j = 0; j < n; j++){
                    a[i][j] = in.nextInt();
                }
            }

            long trace = 0;
            for (int i = 0; i < n; i++ ){
                trace += a[i][i];
            }

            long repeatedRows = 0;
            int[] rowFreq = new int[n+1];
            for (int i = 0; i < n; i++){

                for (int j = 0; j < rowFreq.length; j++) {
                    rowFreq[j] = 0;
                }


                for (int j = 0; j < n; j++) {
                    rowFreq[a[i][j]]++;
                }

                for (int j = 0; j < rowFreq.length; j++) {
                    if (rowFreq[j] > 1){
                        repeatedRows++;
                        break;
                    }
                }

//                for (int j = 0; j < rowFreq.length; j++) {
//                    w.println(j + " " + rowFreq[j]);
//                }
            }

            long repeatedCols = 0;
            int[] colFreq = new int[n+1];
            for (int i = 0; i < n; i++){

                for (int j = 0; j < colFreq.length; j++) {
                    colFreq[j] = 0;
                }


                for (int j = 0; j < n; j++) {
                    colFreq[a[j][i]]++;
                }

                for (int j = 0; j < colFreq.length; j++) {
                    if (colFreq[j] > 1){
                        repeatedCols++;
                        break;
                    }
                }

//                for (int j = 0; j < colFreq.length; j++) {
//                    w.println(j + " " + colFreq[j]);
//                }
            }


            int caseNo = temp - t;
            w.println("Case #"+caseNo+": " + trace + " " + repeatedRows + " " +repeatedCols);
        }

        w.flush();
        w.close();
    }

    public static long gcd(long a, long b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
