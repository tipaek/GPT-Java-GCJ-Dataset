import java.io.*;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++) {
            solver.solve(i, in, out);
        }
        out.close();
    }
}

class ParentingPartneringReturns {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[][] intervals = new int[n][2];

        for (int i = 0; i < n; i++) {
            intervals[i][0] = in.nextInt();
            intervals[i][1] = in.nextInt();
        }

        int jmin = intervals[0][0], jmax = intervals[0][1];
        int cmin = 24 * 60 + 1, cmax = -1;
        boolean possible = true;
        StringBuilder result = new StringBuilder("C");

        for (int i = 1; i < n; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            boolean canBeC = end <= jmin || start >= jmax;
            boolean canBeJ = (i == 1) || end <= cmin || start >= cmax;

            if (canBeC) {
                result.append("C");
                jmin = Math.min(jmin, start);
                jmax = Math.max(jmax, end);
            } else if (canBeJ) {
                result.append("J");
                cmin = Math.min(cmin, start);
                cmax = Math.max(cmax, end);
            } else {
                out.println(String.format("Case #%d: IMPOSSIBLE", testNumber));
                possible = false;
                break;
            }
        }

        if (possible) {
            out.println(String.format("Case #%d: %s", testNumber, result.toString()));
        }
    }
}

class InputReader {
    private final InputStream stream;
    private final byte[] buffer = new byte[1024];
    private int curChar, numChars;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    private int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[curChar++];
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
            result = result * 10 + c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
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

    private boolean isSpaceChar(int c) {
        return !(c >= 33 && c <= 126);
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public void print(Object... objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0) {
                writer.print(' ');
            }
            writer.print(objects[i]);
        }
    }

    public void println(Object... objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }
}