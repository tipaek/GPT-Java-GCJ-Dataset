import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;

public class Solution {

    private static InputReader in;
    private static PrintWriter out;

    public static void main(String[] args) throws IOException {
        // Initialize input and output
        new Solution();
        
        // Read number of test cases
        int tests = in.readInt();
        for (int te = 1; te <= tests; te++) {
            int n = in.readInt();
            int[][] tasks = new int[n][2];

            // Read tasks
            for (int i = 0; i < n; i++) {
                tasks[i][0] = in.readInt();
                tasks[i][1] = in.readInt();
            }

            int ans = -1;
            // Check all possible assignments
            for (int i = 0; i < (1 << n); i++) {
                if (isValidAssignment(i, tasks)) {
                    ans = i;
                    break;
                }
            }
            out.println("Case #" + te + ": " + getAssignmentString(ans, tasks));
        }
        
        // Close output
        end();
    }

    private static boolean isValidAssignment(int assignment, int[][] tasks) {
        boolean[][] timeSlots = new boolean[24 * 60 + 1][2];
        for (int t = 0; t < tasks.length; t++) {
            int person = (assignment >> t) % 2;
            for (int i = tasks[t][0]; i < tasks[t][1]; i++) {
                if (timeSlots[i][person]) return false;
                timeSlots[i][person] = true;
            }
        }
        return true;
    }

    private static String getAssignmentString(int assignment, int[][] tasks) {
        if (assignment == -1) return "IMPOSSIBLE";
        StringBuilder result = new StringBuilder();
        for (int t = 0; t < tasks.length; t++) {
            result.append((assignment >> t) % 2 == 0 ? 'C' : 'J');
        }
        return result.toString();
    }

    public Solution() throws IOException {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out);
    }

    private static void end() throws IOException {
        out.flush();
        out.close();
        System.exit(0);
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') throw new InputMismatchException();
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) c = read();
            StringBuilder result = new StringBuilder();
            do {
                result.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return result.toString();
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while (c != '\n' && c != -1) {
                if (c != '\r') buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while (s.trim().length() == 0) s = readLine0();
            return s;
        }

        public SpaceCharFilter getFilter() {
            return filter;
        }

        public void setFilter(SpaceCharFilter filter) {
            this.filter = filter;
        }
    }

    private interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }
}