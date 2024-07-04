import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.AbstractCollection;
import java.util.PriorityQueue;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.Comparator;
import java.util.Collections;
import java.util.ArrayList;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Dhanin Gupta
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
        public void solve(int testNumber, InputReader in, PrintWriter w) {
            int n = in.nextInt();
            ArrayList<pa> al = new ArrayList<>();

            char[] ans = new char[n];

            for (int i = 0; i < n; i++) {
                al.add(new pa(in.nextInt(), in.nextInt(), i));
            }

            Collections.sort(al, new myc());

            PriorityQueue<el> pq = new PriorityQueue<>(new myc1());

            pq.add(new el(0, al.get(0).en, 'C'));
            ans[al.get(0).ind] = 'C';

            pq.add(new el(1, al.get(1).en, 'J'));
            ans[al.get(1).ind] = 'J';

            int i = 2;
            int f = 1;
            while (!pq.isEmpty() && i < n) {

                pa p = al.get(i);
                el e = pq.poll();
                //w.println(i);
                //w.println(p.st+" "+p.en);
                //w.println(e.et+" "+e.ch);
                if (p.st >= e.et) {
                    ans[p.ind] = e.ch;
                    pq.add(new el(i, p.en, e.ch));
                } else {
                    f = 0;
                    break;
                }
                i++;
            }


            if (f == 0)
                w.println("Case #" + testNumber + ": IMPOSSIBLE");
            else
                w.println("Case #" + testNumber + ": " + String.valueOf(ans));

        }

        class pa {
            int st;
            int en;
            int ind;

            public pa(int a, int b, int c) {
                st = a;
                en = b;
                ind = c;
            }

        }

        class myc implements Comparator<pa> {
            public int compare(pa p1, pa p2) {
                if (p1.st < p2.st)
                    return -1;
                else if (p1.st > p2.st)
                    return 1;
                else {
                    if (p1.en < p2.en)
                        return -1;
                    else if (p1.en > p2.en)
                        return 1;
                    else
                        return 0;
                }

            }

        }

        class el {
            int ind;
            int et;
            char ch;

            public el(int a, int b, char c) {
                ind = a;
                et = b;
                ch = c;
            }

        }

        class myc1 implements Comparator<el> {
            public int compare(el e1, el e2) {
                if (e1.et > e2.et)
                    return 1;
                else if (e1.et < e2.et)
                    return -1;
                else
                    return 0;
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

