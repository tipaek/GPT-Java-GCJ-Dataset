import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {

    static class Shift {
        final long x, y;

        Shift(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + Long.hashCode(x);
            result = prime * result + Long.hashCode(y);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Shift other = (Shift) obj;
            return x == other.x && y == other.y;
        }
    }

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static void solve() throws Exception {
        int n = scanInt();
        long d = scanLong();
        long[] x = new long[n], y = new long[n];
        for (int i = 0; i < n; i++) {
            long xx = scanLong(), yy = scanLong();
            x[i] = xx + yy;
            y[i] = xx - yy;
        }

        TreeSet<Long> xs = new TreeSet<>(), ys = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    xs.add(x[i] + x[j] - x[k] - d);
                    xs.add(x[i] + x[j] - x[k] + d);
                    ys.add(y[i] + y[j] - y[k] - d);
                    ys.add(y[i] + y[j] - y[k] + d);
                }
            }
        }

        long[] xss = convertSetToArray(xs);
        long[] yss = convertSetToArray(ys);

        long total = 0;
        long dist = 0;

        for (int xi = 0; xi < xss.length - 1; xi++) {
            for (int yi = 0; yi < yss.length - 1; yi++) {
                long cx = xss[xi], cy = yss[yi];
                HashSet<Shift> shifts = new HashSet<>();
                int p1 = -1;
                for (int i = 0; i < n; i++) {
                    if (isWithinBounds(x[i], cx, d) && isWithinBounds(y[i], cy, d)) {
                        shifts.add(new Shift(x[i] - cx, y[i] - cy));
                        p1 = i;
                    }
                }
                if (p1 < 0) continue;

                long area = (xss[xi + 1] - xss[xi]) * (yss[yi + 1] - yss[yi]);
                total += area;
                if (isAreaValid(n, x, y, cx, cy, d, p1, shifts)) continue;
                dist += area;
            }
        }

        long gcd = gcd(total, dist);
        total /= gcd;
        dist /= gcd;
        printCase();
        out.println(dist + " " + total);
    }

    static boolean isWithinBounds(long value, long center, long d) {
        return value > center - d && value <= center + d;
    }

    static boolean isAreaValid(int n, long[] x, long[] y, long cx, long cy, long d, int p1, HashSet<Shift> shifts) {
        for (int p2 = 0; p2 < n; p2++) {
            if (p2 == p1) continue;
            long nx = cx + x[p2] - x[p1];
            long ny = cy + y[p2] - y[p1];
            int nShifts2 = 0;
            for (int i = 0; i < n; i++) {
                if (isWithinBounds(x[i], nx, d) && isWithinBounds(y[i], ny, d)) {
                    if (shifts.contains(new Shift(x[i] - nx, y[i] - ny))) {
                        ++nShifts2;
                    } else {
                        return true;
                    }
                }
            }
            if (nShifts2 == shifts.size()) {
                return true;
            }
        }
        return false;
    }

    static long[] convertSetToArray(TreeSet<Long> set) {
        int size = set.size();
        long[] array = new long[size];
        Iterator<Long> it = set.iterator();
        for (int i = 0; i < size; i++) {
            array[i] = it.next();
        }
        return array;
    }

    static int scanInt() throws IOException {
        return Integer.parseInt(scanString());
    }

    static long scanLong() throws IOException {
        return Long.parseLong(scanString());
    }

    static String scanString() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            int tests = scanInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}