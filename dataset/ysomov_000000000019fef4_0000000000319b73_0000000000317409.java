//package codejam.y2020.r1c.a;

import java.io.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

/**
 * @author tainic on May 2, 2020
 */
public class Solution {

    private static boolean LOCAL;
    static {
        try { LOCAL = "aurel".equalsIgnoreCase(System.getenv().get("USER")); } catch (Exception e){}
    }

    private static final String TEST =
        "5\n" +
        "4 4 SSSS\n" +
        "3 0 SNSS\n" +
        "2 10 NSNNSN\n" +
        "0 1 S\n" +
        "2 7 SSSSSSSS";

    void solve(InputReader in, PrintWriter out) {
        int t = in.nextInt();
        for (int ti = 1; ti <= t; ti++) {
            int x = in.nextInt();
            int y = in.nextInt();
            char[] moves = in.next().toCharArray();

            int min = Integer.MAX_VALUE;
            if (x == 0 && y == 0) {
                min = 0;
            } else {
                for (int i = 0; i < moves.length; i++) {
                    char m = moves[i];
                    if (m == 'N') {
                        y++;
                    } else if (m == 'S') {
                        y--;
                    } else if (m == 'E') {
                        x++;
                    } else {
                        x--;
                    }
                    if (Math.abs(x) + Math.abs(y) <= i + 1) {
                        min = i + 1;
                        break;
                    }
                }
            }
            out.println(String.format("Case #%d: %s", ti, (min != Integer.MAX_VALUE ? min : "IMPOSSIBLE")));
        }
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