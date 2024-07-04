import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author KharYusuf
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ESAbATAd solver = new ESAbATAd();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class ESAbATAd {
        public void solve(int testNumber, FastReader s, PrintWriter w) {
            int tt = s.nextInt(), n = s.nextInt();
            int[] ans = new int[n];
            while (tt-- > 0) {
                int l = 0, r = n - 1;
                int q = 0, sameInd = -1, difInd = -1;
                while (l <= r && q < 10) {
                    ans[l] = query(l, w, s);
                    ans[r] = query(r, w, s);
                    if (ans[l] == ans[r]) sameInd = l;
                    else difInd = l;
                    l++;
                    r--;
                    q += 2;
                }
                while (l <= r) {
                    if (q % 10 == 0) {
                        q += 2;
                        if (sameInd == -1) {
                            int b2 = query(difInd, w, s);
                            query(0, w, s);
                            if (b2 != ans[difInd]) comp(ans);
                        } else if (difInd == -1) {
                            int b1 = query(sameInd, w, s);
                            query(0, w, s);
                            if (b1 != ans[sameInd]) comp(ans);
                        } else {
                            int b1 = query(sameInd, w, s);
                            int b2 = query(difInd, w, s);
                            if (ans[sameInd] != b1 && ans[difInd] != b2) comp(ans);
                            else if (ans[sameInd] == b1 && ans[difInd] != b2) rev(ans);
                            else if (ans[sameInd] != b1 && ans[difInd] == b2) revandcomp(ans);
                        }
                    } else {
                        ans[l] = query(l, w, s);
                        ans[r] = query(r, w, s);
                        if (ans[l] == ans[r]) sameInd = l;
                        else difInd = l;
                        l++;
                        r--;
                        q += 2;
                    }
                }
                for (int i : ans) w.print(i);
                w.println();
                w.flush();
                if (s.nextChar() == 'N') throw new RuntimeException("WA");
            }
        }

        void comp(int[] ans) {
            for (int i = 0; i < ans.length; i++) ans[i] ^= 1;
        }

        void rev(int[] ans) {
            int l = 0, r = ans.length - 1;
            while (l < r) {
                int t = ans[l];
                ans[l] = ans[r];
                ans[r] = t;
                l++;
                r--;
            }
        }

        void revandcomp(int[] ans) {
            for (int i = 0; i < ans.length; i++) ans[i] ^= 1;
            int l = 0, r = ans.length - 1;
            while (l < r) {
                int t = ans[l];
                ans[l] = ans[r];
                ans[r] = t;
                l++;
                r--;
            }
        }

        int query(int i, PrintWriter w, FastReader s) {
            w.println(i + 1);
            w.flush();
            return s.nextInt();
        }

    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private FastReader.SpaceCharFilter filter;

        public FastReader(InputStream stream) {
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

        public char nextChar() {

            int c = read();

            while (isSpaceChar(c))
                c = read();

            return (char) c;
        }

        public String next() {

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

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }
}

