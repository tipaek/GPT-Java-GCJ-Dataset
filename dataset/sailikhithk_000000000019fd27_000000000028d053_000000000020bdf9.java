import java.io.*;
import java.util.InputMismatchException;

class Contest {

    boolean submit = false;
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

    boolean[] t1;
    boolean[] t2;

    private void solve(int k, InputReader in, PrintWriter out) throws IOException
    {
        int tasks = in.nextInt();
        t1 = new boolean[1441];
        t2 = new boolean[1441];

        int[][] taskTime = new int[tasks][2];
        StringBuilder output = new StringBuilder();
        boolean isInvalid = false;

        for (int i=0; i< tasks; i++) {
            taskTime[i][0] = in.nextInt();
            taskTime[i][1] = in.nextInt();
        }

        System.out.print("Case #" + k + ": ");
        for (int i=0; i< tasks; i++) {
            if(isT1AvailbleToSchedule(taskTime[i][0], taskTime[i][1])) {
                scheduleTaskInT1(taskTime[i][0], taskTime[i][1]);
                output.append("C");
            } else if (isT2AvailbleToSchedule(taskTime[i][0], taskTime[i][1])) {
                scheduleTaskInT2(taskTime[i][0], taskTime[i][1]);
                output.append("J");
            } else {
                System.out.println("IMPOSSIBLE");
                isInvalid = true;
                break;
            }
        }

        if (!isInvalid) {
            System.out.println(output.toString());
        }
    }

    private boolean isT1AvailbleToSchedule(int startTime, int endTime) {
        for (int i=startTime; i<endTime; i++) {
            if (t1[i] == true) {
                return false;
            }
        }

        return true;
    }

    private void scheduleTaskInT1(int startTime, int endTime) {
        for (int i=startTime; i<endTime; i++) {
            t1[i] = true;
        }
    }

    private boolean isT2AvailbleToSchedule(int startTime, int endTime) {
        for (int i=startTime; i<endTime; i++) {
            if (t2[i] == true) {
                return false;
            }
        }

        return true;
    }

    private void scheduleTaskInT2(int startTime, int endTime) {
        for (int i=startTime; i<endTime; i++) {
            t2[i] = true;
        }
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