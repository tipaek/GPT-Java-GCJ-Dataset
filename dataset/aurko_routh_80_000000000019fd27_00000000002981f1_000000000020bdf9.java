import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args) {
        FastScanner in = new FastScanner(System.in);
        int tc = in.nextInt();
        for(int cc = 1;  cc <= tc; cc++) {
            int n = in.nextInt();

            Interval[] intervals = new Interval[n];

            for(int i = 0; i < n; i++) {
                intervals[i] = new Interval(in.nextInt(),in.nextInt(),i);
            }

            Arrays.sort(intervals);
            boolean[] ans = new boolean[n];

            ans[intervals[0].id]  = true;

            ArrayList<Interval> oth = new ArrayList<>();
            int e = intervals[0].e;
            for(int i = 1; i < n; i++) {
                if(intervals[i].s >= e) {
                    ans[intervals[i].id] = true;
                    e = intervals[i].e;
                } else {
                    oth.add(intervals[i]);
                }
            }

            boolean imp = false;
            Collections.sort(oth);

            for(int i = 1; i < oth.size(); i++) {
                if(oth.get(i).s < oth.get(i-1).e)
                    imp = true;
            }

            StringBuilder sb  = new StringBuilder();
            if(imp) {
                sb.append("IMPOSSIBLE");
            } else {
                for(int i = 0; i < n; i++) {
                    if(ans[i])
                        sb.append("C");
                    else
                        sb.append("J");
                }
            }

            System.out.printf("Case #%d: %s%n",cc,sb.toString());
        }

    }

    static class Interval implements Comparable<Interval> {
        int s, e, id;

        public Interval(int s, int e, int id) {
            this.s = s;
            this.e = e;
            this.id = id;
        }

        @Override
        public int compareTo(Interval o) {
            return s-o.s;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "s=" + s +
                    ", e=" + e +
                    ", id=" + id +
                    '}';
        }
    }



    static class FastScanner {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars ;

        public FastScanner(InputStream stream) {
            this.stream = stream;
        }

        int read() {
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

        boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        boolean isEndline(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        String nextLine() {
            int c = read();
            while (isEndline(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndline(c));
            return res.toString();
        }
    }

}

