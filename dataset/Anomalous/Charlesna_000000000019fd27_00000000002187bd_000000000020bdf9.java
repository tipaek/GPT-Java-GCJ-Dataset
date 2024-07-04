import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    @Override
    public void run() {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] intervals = new int[n][2];
            for (int j = 0; j < n; j++) {
                intervals[j][0] = in.nextInt();
                intervals[j][1] = in.nextInt();
            }
            processIntervals(intervals, out, i);
        }
        out.flush();
        out.close();
    }

    private static void processIntervals(int[][] intervals, PrintWriter out, int testCaseNumber) {
        char[] schedule = new char[intervals.length];
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            indexMap.put(intervals[i][0] + " " + intervals[i][1], i);
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int endJ = 0, endC = 0;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int originalIndex = indexMap.get(start + " " + end);

            if (endJ <= start && endC <= start) {
                if (endJ > endC) {
                    schedule[originalIndex] = 'J';
                    endJ = end;
                } else {
                    schedule[originalIndex] = 'C';
                    endC = end;
                }
            } else if (endJ <= start) {
                schedule[originalIndex] = 'J';
                endJ = end;
            } else if (endC <= start) {
                schedule[originalIndex] = 'C';
                endC = end;
            } else {
                out.println("Case #" + testCaseNumber + ": IMPOSSIBLE");
                return;
            }
        }

        out.println("Case #" + testCaseNumber + ": " + new String(schedule));
    }

    static class InputReader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        private int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = stream.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new InputMismatchException();
            }
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            long result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            double result = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return result * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            }
            if (c == '.') {
                c = read();
                double fraction = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return result * Math.pow(10, nextInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    fraction /= 10;
                    result += (c - '0') * fraction;
                    c = read();
                }
            }
            return result * sign;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }
    }

    public static void main(String[] args) {
        new Thread(null, new Solution(), "Main", 1 << 27).start();
    }
}