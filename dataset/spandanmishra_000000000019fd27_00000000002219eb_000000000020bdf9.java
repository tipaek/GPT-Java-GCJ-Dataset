import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Spandan Mishra
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        solver.solve(1, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader in, PrintWriter out) {
            int T = in.readInt();
            testNumber = 1;
            StringBuilder sb = new StringBuilder();
            while (T-- > 0) {
                int n = in.readInt();
                ParentingPartneringReturns.Time[] a = new ParentingPartneringReturns.Time[n];
                for (int i = 0; i < n; i++)
                    a[i] = new ParentingPartneringReturns.Time(in.readInt(), in.readInt());

                Arrays.sort(a, new Comparator<ParentingPartneringReturns.Time>() {

                    public int compare(ParentingPartneringReturns.Time o1, ParentingPartneringReturns.Time o2) {
                        if (o1.st <= o2.st)
                            return -1;
                        return 1;
                    }
                });

                int s1 = 0, e1 = 0, s2 = 0, e2 = 0;
                StringBuilder res = new StringBuilder();
                res.append('J');
                s1 = a[0].st;
                e1 = a[0].ed;

                int stmp, etmp;
                boolean possible = true;
                for (int i = 1; i < n; i++) {
                    stmp = a[i].st;
                    etmp = a[i].ed;

                    if (s1 == 0 && e1 == 0) {
                        res.append('J');
                        s1 = stmp;
                        e1 = etmp;
                    } else if (s2 == 0 && e2 == 0) {
                        res.append('C');
                        s2 = stmp;
                        e2 = etmp;
                    } else if (stmp >= e1 || stmp >= e2) {
                        if (stmp >= e1) {
                            res.append('J');
                            s1 = stmp;
                            e1 = etmp;
                        } else if (stmp >= e2) {
                            res.append('C');
                            s2 = stmp;
                            e2 = etmp;
                        }
                    } else {
                        possible = false;
                        break;
                    }
                }

                if (!possible)
                    sb.append("Case #" + testNumber++ + ": " + "IMPOSSIBLE");
                else
                    sb.append("Case #" + testNumber++ + ": " + res);

                sb.append("\n");
            }

            System.out.print(sb);
        }

        private static class Time {
            int st;
            int ed;

            public Time(int st, int ed) {
                this.st = st;
                this.ed = ed;
            }

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
            if (numChars == -1)
                throw new RuntimeException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new RuntimeException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
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
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }
}

