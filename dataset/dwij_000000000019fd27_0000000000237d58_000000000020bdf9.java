import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author dwij
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int T, InputReader in, OutputWriter out) {
            int n = in.nextInt();

            int[][] arr = new int[n][];

            for (int i = 0; i < n; i++) {
                int a = in.nextInt();
                int b = in.nextInt();
                arr[i] = new int[]{a, b};
            }

            List<ParentingPartneringReturns.Job> jList = new ArrayList<>();
            List<ParentingPartneringReturns.Job> cList = new ArrayList<>();
            cList.add(new ParentingPartneringReturns.Job(arr[0][0], arr[0][1]));

            boolean found = true;
            StringBuilder sb = new StringBuilder();
            sb.append("C");
            for (int i = 1; i < n; i++) {
                int a = arr[i][0];
                int b = arr[i][1];

                if (ParentingPartneringReturns.Job.isNotOverLapping(cList, a, b)) {
                    sb.append("C");
                    cList.add(new ParentingPartneringReturns.Job(a, b));
                } else if (ParentingPartneringReturns.Job.isNotOverLapping(jList, a, b)) {
                    sb.append("J");
                    jList.add(new ParentingPartneringReturns.Job(a, b));
                } else {
                    out.println(String.format("Case #%d: IMPOSSIBLE", T));
                    found = false;
                    break;
                }

            }

            if (found) out.println(String.format("Case #%d: %s", T, sb.toString()));


        }

        static class Job {
            int s;
            int e;

            Job(int s, int e) {
                this.s = s;
                this.e = e;
            }

            static boolean isNotOverLapping(List<ParentingPartneringReturns.Job> jobs, int a, int b) {
                for (ParentingPartneringReturns.Job job : jobs) {
                    if (!(b <= job.s || a >= job.e)) {
                        return false;
                    }
                }

                return true;
            }

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
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

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
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

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                if (Character.isValidCodePoint(c)) {
                    res.appendCodePoint(c);
                }
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String next() {
            return nextString();
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

    }
}

