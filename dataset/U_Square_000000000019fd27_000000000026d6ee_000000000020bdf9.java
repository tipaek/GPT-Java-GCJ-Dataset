
import java.util.*;
import java.io.*;

/**
 *
 * @author usquare
 */

public class Solution {

    static int mod = (int) (1e9+7);
    static InputReader in;
    static PrintWriter out;
    static boolean file = false;

    public static void main(String[] args) {

        in = new InputReader(System.in);
        out = new PrintWriter(System.out);

        int t = in.ni();

        for(int ta = 1; ta <= t; ta++){
            int n = in.ni();
            ArrayList<Pair> list = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                list.add(new Pair(in.ni(), in.ni(), i));
            }
            Collections.sort(list);
            boolean[] vis = new boolean[n];
            vis[list.get(0).i] = true;
            Pair prev = new Pair(list.get(0).x, list.get(0).y, -1);

            for(int i = 1; i < n; i++) {
                Pair curr = list.get(i);
                if(curr.x >= prev.y) {
                    vis[curr.i] = true;
                    prev.x = curr.x;
                    prev.y = curr.y;
                }
            }
//            debug(list);
//            debug(vis);

            prev.x = -1;
            prev.y = -1;

            boolean ok = true;

            for(int i = 1; i < n; i++) {
                Pair curr = list.get(i);
                if(vis[curr.i]) {
                    continue;
                }
                if(curr.x >= prev.y) {
                    prev.x = curr.x;
                    prev.y = curr.y;
                }
                else {
                    ok = false;
                    break;
                }
            }

            StringBuilder str = new StringBuilder();
            if(ok) {
                for(int i = 0; i < n; i++) {
                    if(vis[i]) str.append('C');
                    else str.append('J');
                }
            }
            else
                str.append("IMPOSSIBLE");
            out.println("Case #"+ta+": " + str.toString());
        }

        out.close();
    }

    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int i;

        Pair(int x, int y, int i) {
            this.x = x;
            this.y = y;
            this.i = i;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x != o.x)
                return Integer.compare(this.y, o.y);
            return Integer.compare(this.x, o.x);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    ", i=" + i +
                    '}';
        }
    }

    static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    static class InputReader {

        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int ni() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public long nl() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nIArr(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = ni();
            }
            return a;
        }

        public long[] nLArr(int n) {
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nl();
            }
            return a;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }

    }
}
