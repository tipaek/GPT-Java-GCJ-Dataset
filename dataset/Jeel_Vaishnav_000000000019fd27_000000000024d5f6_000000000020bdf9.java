import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Comparator;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jeel Vaishnav
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ParentingPartneringReturns solver = new ParentingPartneringReturns();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ParentingPartneringReturns {
        public void solve(int testNumber, InputReader sc, PrintWriter out) {
            int n = sc.nextInt();

            Activity a[] = new Activity[n];
            for (int i = 0; i < n; ++i)
                a[i] = new Activity(i, sc.nextInt(), sc.nextInt());

            Arrays.sort(a, new Comparator<Activity>() {

                public int compare(Activity o1, Activity o2) {
                    if (o1.l < o2.l)
                        return -1;
                    if (o1.l > o2.l)
                        return 1;
                    return 0;
                }
            });

            int flag = 0;
            int time1 = 0, time2 = 0;
            char ans[] = new char[n];
            for (int i = 0; i < n; ++i) {
                if (time1 <= a[i].l) {
                    ans[a[i].ind] = 'C';
                    time1 = a[i].r;
                } else if (time2 <= a[i].l) {
                    ans[a[i].ind] = 'J';
                    time2 = a[i].r;
                } else {
                    flag = 1;
                    break;
                }
            }

            if (flag == 1)
                out.println("Case #" + testNumber + ": IMPOSSIBLE");
            else
                out.println("Case #" + testNumber + ": " + new String(ans));
        }

        class Activity {
            int ind;
            int l;
            int r;

            Activity(int a, int b, int c) {
                ind = a;
                l = b;
                r = c;

            }

        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

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
}

