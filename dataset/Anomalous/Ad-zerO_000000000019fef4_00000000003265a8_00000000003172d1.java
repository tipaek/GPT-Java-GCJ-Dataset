import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Solution {

    public static final long MOD = (long) Math.pow(10, 9) + 7;
    public static final double EPSILON = 0.00000000008854;
    public static final InputReader SC = new InputReader(System.in);
    public static final PrintWriter PW = new PrintWriter(System.out);

    public static boolean heightBfs(int r, int[] h, ArrayList<ArrayList<Integer>> a, int[] vis) {
        Deque<Integer> q = new LinkedList<>();
        q.add(r);
        int c = 1;
        vis[r] = 1;
        h[r] = c;
        boolean pos = true;
        while (!q.isEmpty()) {
            int l = q.size();
            while (l-- > 0) {
                int v = q.remove();
                for (int u : a.get(v)) {
                    if (vis[u] == 0) {
                        vis[u] = 1;
                        h[u] = c + 1;
                        q.add(u);
                    } else if ((h[u] & 1) == (h[v] & 1)) {
                        return false;
                    }
                }
            }
            c++;
        }
        return pos;
    }

    public static ArrayList<ArrayList<Integer>> getGraph(int n, int m) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = SC.nextInt() - 1;
            int v = SC.nextInt() - 1;
            a.get(u).add(v);
            a.get(v).add(u);
        }
        return a;
    }

    public static ArrayList<ArrayList<Pair>> getGraphWeighted(int n, int m) {
        ArrayList<ArrayList<Pair>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = SC.nextInt() - 1;
            int v = SC.nextInt() - 1;
            int w = SC.nextInt();
            a.get(u).add(new Pair(v, w));
            a.get(v).add(new Pair(u, w));
        }
        return a;
    }

    public static long pow(long x, long y, long mod) {
        long ans = 1;
        x %= mod;
        while (y > 0) {
            if ((y & 1) == 1) {
                ans = (ans * x) % mod;
            }
            y >>= 1;
            x = (x * x) % mod;
        }
        return ans;
    }

    public static void main(String[] args) {
        int q = SC.nextInt();
        for (int q0 = 1; q0 <= q; q0++) {
            int n = SC.nextInt();
            long d = SC.nextLong();
            long[] a = scanLongArray(n);
            Arrays.sort(a);
            long d1 = d;
            long min = d - 1;
            for (int i = 0; i < n; i++) {
                Long[][] v = new Long[n][2];
                for (int j = 0; j < n; j++) {
                    v[j][0] = a[j] / a[i];
                    if (a[j] % a[i] == 0) v[j][0] -= 1;
                    v[j][1] = a[j] / a[i];
                }
                Arrays.sort(v, i, n, lpair());
                long c = 0;
                long f = 0;
                d = d1;
                for (int j = i; j < n; j++) {
                    if (d - v[j][1] < 0) {
                        c += d;
                        f += d;
                        break;
                    }
                    f += v[j][1];
                    d -= v[j][1];
                    c += v[j][0];
                }
                if (d == 0) min = Math.min(min, c);
            }
            PW.println("Case #" + q0 + ": " + min);
        }
        PW.flush();
        PW.close();
    }

    public static Comparator<Integer> descendingOrder() {
        return (o1, o2) -> o2.compareTo(o1);
    }

    public static Comparator<Pair> ascendingOrderBySecond() {
        return (o1, o2) -> Long.compare(o1.j, o2.j);
    }

    static class TripletL implements Comparable<TripletL> {
        Long x, y, z;

        TripletL(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public int compareTo(TripletL o) {
            int result = x.compareTo(o.x);
            if (result == 0) result = y.compareTo(o.y);
            if (result == 0) result = z.compareTo(o.z);
            return result;
        }

        public boolean equals(Object o) {
            if (o instanceof TripletL) {
                TripletL p = (TripletL) o;
                return x.equals(p.x) && y.equals(p.y) && z.equals(p.z);
            }
            return false;
        }

        public String toString() {
            return x + " " + y + " " + z;
        }

        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }

    public static String doubleFormat(double a, int n) {
        StringBuilder s = new StringBuilder();
        while (n-- > 0) {
            s.append('0');
        }
        DecimalFormat f = new DecimalFormat("#0." + s);
        return f.format(a);
    }

    public static Comparator<Integer[]> columnComparator(int i) {
        return (o1, o2) -> o2[i].compareTo(o1[i]);
    }

    public static Comparator<Long[]> columnComparatorLong(int i) {
        return (o1, o2) -> o1[i].compareTo(o2[i]);
    }

    public static Comparator<Long[]> lpair() {
        return (o1, o2) -> {
            int result = o1[0].compareTo(o2[0]);
            if (result == 0) result = o2[1].compareTo(o1[1]);
            return result;
        };
    }

    public static Comparator<Integer[]> pair() {
        return (o1, o2) -> {
            int result = o1[0].compareTo(o2[0]);
            if (result == 0) result = o1[1].compareTo(o2[1]);
            return result;
        };
    }

    public static Comparator<Integer[]> triplet() {
        return (o1, o2) -> {
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int p = k + 1; p < 3; p++) {
                            if ((o1[i].equals(o2[k]) && o1[j].equals(o2[p])) || (o1[j].equals(o2[k]) && o1[i].equals(o2[p]))) {
                                // Do nothing
                            }
                        }
                    }
                }
            }
            int result = o1[0].compareTo(o2[0]);
            if (result == 0) result = o1[1].compareTo(o2[1]);
            if (result == 0) result = o1[2].compareTo(o2[2]);
            return result;
        };
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static int[] scanArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = SC.nextInt();
        }
        return a;
    }

    public static long[] scanLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = SC.nextLong();
        }
        return a;
    }

    public static String[] scanStrings(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = SC.nextLine();
        }
        return a;
    }
}

class Pair {
    long i, j;

    Pair(long a, long b) {
        i = a;
        j = b;
    }
}

class InputReader {

    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int snext() {
        if (numChars == -1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
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
            if (c < '0' || c > '9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = snext();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
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
            if (c < '0' || c > '9') throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = snext();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int[] nextIntArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
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
        while (isSpaceChar(c)) {
            c = snext();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = snext();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    public interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }
}