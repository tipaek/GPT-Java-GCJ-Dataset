import java.util.*;
import java.io.*;

public class Solution {
    public static final boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        PrintWriter pw = new PrintWriter(System.out);
        FastScan sc = new FastScan();

        int cases = sc.nextInt();

        for (int t = 1; t <= cases; t++) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            boolean flipped = l == r;

            if (l < r) {
                flipped = !flipped;
                long temp = l;
                l = r;
                r = temp;
            }

            long lo = 0;
            long hi = 2_000_000_000;

            while (lo < hi) {
                long mid = (lo + hi + 1) / 2;

                if (slice(0, mid) > l - r) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }

            l -= slice(0, lo);
            long next = lo;

            if (next % 2 == 1) {
                if (next > l) {
                    pw.printf("Case #%d: %d %d %d\n", t, next - 1, flipped ? r : l, flipped ? l : r);
                    continue;
                }

                flipped = !flipped ^ (l == r);
                l -= next;
                next++;
                long temp = l;
                l = r;
                r = temp;
            }

            lo = next / 2;
            hi = 1_000_000_000;

            while (lo < hi) {
                long mid = (lo + hi + 1) / 2;
                long value = mid * 2;

                if (eslice(Math.max(next - 2, 0), value) > l || oslice(Math.max(next - 1, 0), value + 1) > r) {
                    hi = mid - 1;
                } else {
                    lo = mid;
                }
            }

            long value = lo * 2;
            l -= eslice(next, value);
            r -= oslice(next + 1, value + 1);
            next = value;

            while (true) {
                if (next % 2 == 0) {
                    if (next > l) {
                        pw.printf("Case #%d: %d %d %d\n", t, next - 1, flipped ? r : l, flipped ? l : r);
                        break;
                    } else {
                        l -= next;
                    }
                } else {
                    if (next > r) {
                        pw.printf("Case #%d: %d %d %d\n", t, next - 1, flipped ? r : l, flipped ? l : r);
                        break;
                    } else {
                        r -= next;
                    }
                }
                next++;
            }
        }

        pw.close();
        sc.close();
    }

    static long slice(long a, long b) {
        b--;
        a--;
        a = Math.max(a, 0);
        return (b * (b + 1) - a * (a + 1)) / 2;
    }

    static long eslice(long a, long b) {
        a /= 2;
        b /= 2;
        return slice(a, b) * 2;
    }

    static long oslice(long a, long b) {
        a /= 2;
        b /= 2;
        return slice(a, b) * 2 + (b - a);
    }

    public static void debug(Object obj, String end) {
        if (DEBUG) {
            if (obj instanceof boolean[]) {
                System.out.print(Arrays.toString((boolean[]) obj));
            } else if (obj instanceof byte[]) {
                System.out.print(Arrays.toString((byte[]) obj));
            } else if (obj instanceof short[]) {
                System.out.print(Arrays.toString((short[]) obj));
            } else if (obj instanceof char[]) {
                System.out.print(Arrays.toString((char[]) obj));
            } else if (obj instanceof int[]) {
                System.out.print(Arrays.toString((int[]) obj));
            } else if (obj instanceof long[]) {
                System.out.print(Arrays.toString((long[]) obj));
            } else if (obj instanceof float[]) {
                System.out.print(Arrays.toString((float[]) obj));
            } else if (obj instanceof double[]) {
                System.out.print(Arrays.toString((double[]) obj));
            } else if (obj instanceof Object[]) {
                debug((Object[]) obj);
            } else {
                System.out.print(obj);
            }
            System.out.print(end);
        }
    }

    public static void debug(Object... args) {
        if (DEBUG) {
            System.out.print("#");
            for (Object arg : args) {
                debug(arg, " ");
            }
            System.out.println();
        }
    }

    public static void debug(Suspended sus) {
        if (DEBUG) {
            debug(sus.eval());
        }
    }

    public static void debugGrid(int[][] grid) {
        if (DEBUG) {
            for (int[] row : grid) {
                System.out.print("#");
                for (int cell : row) {
                    System.out.print(String.format("%3d ", cell));
                }
                System.out.println();
            }
        }
    }

    static class FastScan {
        BufferedReader br;
        StringTokenizer st;

        public FastScan() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine(), " ");
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public void close() throws IOException {
            br.close();
        }
    }
}

interface Suspended {
    Object eval();
}