import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Scheduler scheduler = new Scheduler();
        scheduler.scheduleTasks(in, out);
        out.close();
    }

    static class Scheduler {
        public void scheduleTasks(FastReader in, PrintWriter out) {
            int t = in.nextInt();
            for (int i = 1; i <= t; i++) {
                int n = in.nextInt();
                int cEnd = 0, jEnd = 0;
                boolean impossible = false;
                int[][] activities = new int[n][3];
                char[] result = new char[n];

                for (int a = 0; a < n; a++) {
                    activities[a][0] = in.nextInt();
                    activities[a][1] = in.nextInt();
                    activities[a][2] = a;
                }

                Arrays.sort(activities, Comparator.comparingInt(a -> a[0]));

                for (int[] activity : activities) {
                    int start = activity[0];
                    int end = activity[1];
                    int index = activity[2];

                    if (start >= cEnd) {
                        cEnd = end;
                        result[index] = 'C';
                    } else if (start >= jEnd) {
                        jEnd = end;
                        result[index] = 'J';
                    } else {
                        impossible = true;
                        break;
                    }
                }

                if (impossible) {
                    out.printf("Case #%d: IMPOSSIBLE\n", i);
                } else {
                    out.printf("Case #%d: %s\n", i, new String(result));
                }
            }
        }
    }

    static class FastReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[8192];
        private int curChar, numChars;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buffer[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                res = res * 10 + c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        private static boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }
}