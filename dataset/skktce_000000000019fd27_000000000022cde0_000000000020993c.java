import java.io.*;
import java.util.InputMismatchException;

class Contest {

    boolean submit = true;
    boolean isTestCase = true;

    public Contest() throws IOException
    {
        //input
        InputReader in;
        if(!submit)
            in = new InputReader(new FileInputStream("src/input.txt"));
        else
            in = new InputReader(System.in);

        //output
        PrintWriter out = new PrintWriter(System.out);
        int T;
        if(isTestCase)
            T = in.nextInt();
        else
            T=1;

        for(int caseNo = 1; caseNo <= T; caseNo++)
            solve(caseNo, in, out);

        out.close();
    }

    private void solve(int caseNo, InputReader in, PrintWriter out) throws IOException
    {
        // Get Rows
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        int[][] colSet = new int[n][n];
        boolean[] isRepeatingCol = new boolean[n];
        int[] rowSet = new int[n];
        boolean isRepeatingRow = false;

        int diagSum = 0;
        int repeatingRow = 0;
        int repeatingCol = 0;

        for (int i = 0; i < n; i++) {
            for (int j=0; j<n; j++) {
                int val = in.nextInt();
                if (i==j) {
                    diagSum += val;
                }

                if (rowSet[val-1] == -1) {
                    isRepeatingRow = true;
                } else {
                    rowSet[val-1] = -1;
                }

                if (colSet[j][val-1] == -1) {
                    isRepeatingCol[j] = true;
                } else {
                    colSet[j][val-1] = -1;
                }

                arr[i][j] = val;
            }

            if (isRepeatingRow) {
                repeatingRow++;
            }

            isRepeatingRow = false;
            rowSet = new int[n];
        }

        for (int i=0; i<n; i++) {
            if (isRepeatingCol[i]) {
                repeatingCol ++;
            }
        }

        out.println(String.format("Case #%d: %d %d %d", caseNo, diagSum, repeatingRow, repeatingCol));
    }

    public static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }



        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public interface SpaceCharFilter {

            public boolean isSpaceChar(int ch);
        }

        public String next() {
            return nextString();
        }

        public String nextString() {
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

        public Long nextLong() {
            return Long.parseLong(nextString());
        }

        public Double nextDouble() {
            return Double.parseDouble(nextString());
        }
    }

    public static void main(String args[]) throws IOException {
        new Contest();
    }
}