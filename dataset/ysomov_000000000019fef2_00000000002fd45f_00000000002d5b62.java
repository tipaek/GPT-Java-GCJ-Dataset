//package codejam.y2020.r1b.a;

import java.io.*;
import java.util.*;

/**
 * @author tainic on Apr 19, 2020
 */
public class Solution {


    private static boolean LOCAL;
    static {
        try { LOCAL = "aurel".equalsIgnoreCase(System.getenv().get("USER")); } catch (Exception e){}
    }

    private static final String TEST =
        "4\n" +
        "2 3\n" +
        "-2 -3\n" +
        "3 0\n" +
        "0 -0";

    void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ti++) {
            long x = in.nextLong();
            long y = in.nextLong();

            long z = sq(x, y);
            if (z % 2 == 0) {
                out.println(String.format("Case #%d: IMPOSSIBLE", ti));
                continue;
            }

            long k = (z + 1) / 2;
            int i = exp2(k);
            long pow = (long) Math.pow(2, i);
            StringBuilder sb = new StringBuilder();
            while (x != 0 || y != 0) {
                long x2 = x + pow, y2 = y;

                char dir = 'W';
                long z2 = sq(x + pow, y);

                long z3 = sq(x - pow, y);
                if (z3 < z2) {
                    dir = 'E';
                    z2 = z3;
                    x2 = x - pow;
                    y2 = y;
                }

                z3 = sq(x, y + pow);
                if (z3 < z2) {
                    dir = 'S';
                    z2 = z3;
                    x2 = x;
                    y2 = y + pow;
                }

                z3 = sq(x, y - pow);
                if (z3 < z2) {
                    dir = 'N';
                    x2 = x;
                    y2 = y - pow;
                }

                x = x2;
                y = y2;
                sb.append(dir);
                pow /= 2;
            }

            String sol = sb.reverse().toString();

            /*long[] r = play(sol);
            System.out.println(Arrays.toString(r));*/

            out.println(String.format("Case #%d: %s", ti, sol));
        }
    }

    private long[] play(char[] ch) {
        long x = 0, y = 0;
        long pow = 1;
        for (char c : ch) {
            if (c == 'E') x += pow;
            else if (c == 'W') x -= pow;
            else if (c == 'N') y += pow;
            else y -= pow;
            pow *= 2;
        }
        return new long[]{x, y};
    }

    private long sq(long x, long y) {
        return Math.abs(x) + Math.abs(y);
    }

    // i such that 2^(i-1) < n <= 2^i
    private int exp2(long n) {
        long pow = 1;
        int i = 0;
        while (n > pow) {
            pow *= 2;
            i++;
        }
        return i;
        //return (int) Math.ceil((Math.log(n) / Math.log(2)));
    }

    //region util
    static class Util {

        private static final Random R = new Random();

        public static void sort(int[] a) {
            sort(a, 0, a.length - 1);
        }

        private static void sort(int[] a, int from, int to) {
            if (from >= to) {
                return;
            }

            // partition
            int pivotIndex = R.nextInt(to - from + 1) + from;
            int pivot = a[pivotIndex];
            // maintain this invariant, at each step i:
            // a[j] <  pivot, for j = fromIndex to lt - 1
            // a[j] == pivot, for j = lt to i - 1
            // a[j] >  pivot, for j = gt + 1 to toIndex
            int lt = from;
            int gt = to;
            int i = lt;
            while (i <= gt) {
                int cmp = a[i] - pivot;
                if (cmp < 0) {
                    swap(a, i, lt);
                    i++;
                    lt++;
                } else if (cmp > 0) {
                    swap(a, i, gt);
                    gt--;
                } else {
                    i++;
                }
            }

            // sort left and right
            sort(a, from, lt - 1);
            sort(a, gt + 1, to);
        }

        public static int findFirst(int[] a, int key) {
            return findFirstOrLast(a, key, 0, a.length - 1, -1);
        }

        public static int findLast(int[] a, int key) {
            return findFirstOrLast(a, key, 0, a.length - 1, 1);
        }

        static int findFirstOrLast(int[] a, int key, int fromIndex, int toIndex, int dir) {
            int left = fromIndex;
            int right = toIndex;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                int cmp = key - a[mid];
                if (cmp > 0) {
                    left = mid + 1;
                } else if (cmp < 0) {
                    right = mid - 1;
                } else if (dir == -1 && mid > fromIndex && a[mid - 1] == key) {
                    right = mid - 1;
                } else if (dir == 1 && mid < toIndex && a[mid + 1] == key) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return -left - 1;
        }

        public static int findFirst(long[] a, long key) {
            return findFirstOrLast(a, key, 0, a.length - 1, -1);
        }

        public static int findLast(long[] a, long key) {
            return findFirstOrLast(a, key, 0, a.length - 1, 1);
        }

        static int findFirstOrLast(long[] a, long key, int fromIndex, int toIndex, int dir) {
            int left = fromIndex;
            int right = toIndex;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                int cmp = Long.compare(key,a[mid]);
                if (cmp > 0) {
                    left = mid + 1;
                } else if (cmp < 0) {
                    right = mid - 1;
                } else if (dir == -1 && mid > fromIndex && a[mid - 1] == key) {
                    right = mid - 1;
                } else if (dir == 1 && mid < toIndex && a[mid + 1] == key) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return -left - 1;
        }

        public static <T extends Comparable<T>> int findFirst(List<T> a, T key) {
            return findFirstOrLast(a, key, 0, a.size() - 1, -1);
        }

        public static <T extends Comparable<T>> int findLast(List<T> a, T key) {
            return findFirstOrLast(a, key, 0, a.size() - 1, 1);
        }

        static <T extends Comparable<T>> int findFirstOrLast(List<T> a, T key, int fromIndex, int toIndex, int dir) {
            int left = fromIndex;
            int right = toIndex;
            while (left <= right) {
                int mid = (left + right) >>> 1;
                int cmp = key.compareTo(a.get(mid));
                if (cmp > 0) {
                    left = mid + 1;
                } else if (cmp < 0) {
                    right = mid - 1;
                } else if (dir == -1 && mid > fromIndex && a.get(mid - 1) == key) {
                    right = mid - 1;
                } else if (dir == 1 && mid < toIndex && a.get(mid + 1) == key) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
            return -left - 1;
        }

        public static void swap(int[] a, int i, int j) {
            if (i != j) {
                int ai = a[i];
                a[i] = a[j];
                a[j] = ai;
            }
        }

        public static int[] readInts(InputReader in, int k) {
            int[] a = new int[k];
            for (int i = 0; i < k; i++) {
                a[i] = in.nextInt();
            }
            return a;
        }

    }
    //endregion

    //region main
    public static void main(String[] args) throws Exception {
        long t = System.currentTimeMillis();

        try (
            InputReader in = new StreamInputReader(!LOCAL ? System.in : new ByteArrayInputStream(TEST.getBytes()));
            PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out, 2048), false)
        ) {
            new Solution().solve(in, out);
        }

        System.err.println("time: " + (System.currentTimeMillis() - t) + "ms");
    }
    //endregion

    //region fast io
    abstract static class InputReader implements AutoCloseable {

        public abstract int read();

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

        public long nextLong() {
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

        public String next() {
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

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    }

    static class StreamInputReader extends InputReader {

        private InputStream stream;
        private byte[] buf;
        private int curChar, numChars;

        public StreamInputReader(InputStream stream) {
            this(stream, 2048);
        }

        public StreamInputReader(InputStream stream, int bufSize) {
            this.stream = stream;
            this.buf = new byte[bufSize];
        }

        @Override
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

        @Override
        public void close() throws Exception {
            stream.close();
        }

    }
    //endregion

    //region imports
    //endregion

}