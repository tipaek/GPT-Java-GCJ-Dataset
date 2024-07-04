import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Reader in = new Reader();
        new Solution().solve(out, in);
        out.flush();
        out.close();
    }

    static final int MAXN = 5 * (int) 1e5 + 5;
    static final long MOD = (int) 1e9 + 7;
    static int n, t;

    void solve(PrintWriter out, Reader in) throws IOException {
        t = in.nextInt();

        for (int testCase = 1; testCase <= t; testCase++) {
            n = in.nextInt();
            List<Activity> activities = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                activities.add(new Activity(in.nextInt(), in.nextInt(), i));
            }
            Collections.sort(activities);

            char[] schedule = new char[n];
            int endC = 0, endJ = 0;
            boolean possible = true;

            for (Activity act : activities) {
                if (endC <= act.start) {
                    endC = act.end;
                    schedule[act.id] = 'C';
                } else if (endJ <= act.start) {
                    endJ = act.end;
                    schedule[act.id] = 'J';
                } else {
                    out.println("Case #" + testCase + ": IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            if (possible) {
                out.print("Case #" + testCase + ": ");
                for (char c : schedule) {
                    out.print(c);
                }
                out.println();
            }
        }
    }

    static class Activity implements Comparable<Activity> {
        int start, end, id;

        Activity(int start, int end, int id) {
            this.start = start;
            this.end = end;
            this.id = id;
        }

        public int compareTo(Activity other) {
            return Integer.compare(this.start, other.start);
        }
    }

    static class Reader {
        private final InputStream stream;
        private final byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public Reader() {
            this(System.in);
        }

        public Reader(InputStream stream) {
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
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return result.toString();
        }

        public String next() {
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

        public double nextDouble() {
            return Double.parseDouble(next());
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

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}