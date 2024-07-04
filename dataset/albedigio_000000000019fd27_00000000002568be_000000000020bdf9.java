
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;

public class Solution {
    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

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

        public int readInt() {
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

        public String readString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, readInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E') {
                        return res * Math.pow(10, readInt());
                    }
                    if (c < '0' || c > '9') {
                        throw new InputMismatchException();
                    }
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
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

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    public static class Interval{
        int s, e;
        char owner;
        int id;

        Interval(int s, int e, int id){
            this.s = s;
            this.e = e;
            this.id = id;
        }

        @Override
        public String toString() {
            return "("+s+","+e +")";
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        StringBuilder sb = new StringBuilder();
        int test = in.readInt();
        for (int i = 0; i < test; i++) {
            int n = in.readInt();
            Interval intervals[] = new Interval[n];
            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < n; j++) {
                intervals[j] = new Interval(in.readInt(), in.readInt(), j);
                ans.append('A');
            }
            Arrays.sort(intervals, new Comparator<Interval>() {
                @Override
                public int compare(Interval o1, Interval o2) {
                    return Integer.compare(o1.s, o2.s);
                }
            });
            int cFreeAt = -1;
            int jFreeAt = -1;
            boolean impossible = false;
            for (int j = 0; j < n; j++) {
                Interval inter = intervals[j];
                if (cFreeAt <= inter.s) {
                    cFreeAt = inter.e;
                    inter.owner = 'C';
                    ans.replace(inter.id, inter.id+1, "C");
                } else if (jFreeAt <= inter.s) {
                    jFreeAt = inter.e;
                    inter.owner = 'J';
                    ans.replace(inter.id, inter.id+1, "J");
                } else {
                    impossible = true;
                    break;
                }
            }
            if (impossible) {
                ans = new StringBuilder("IMPOSSIBLE");
            }
            sb.append("Case #").append(i+1).append(": ").append(ans.toString()).append('\n');
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

}

