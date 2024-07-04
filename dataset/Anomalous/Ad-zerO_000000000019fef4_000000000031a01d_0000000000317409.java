import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Solution {
    public static final long MOD = 1_000_000_007L;
    public static final double EPSILON = 0.00000000008854;
    public static final InputReader sc = new InputReader(System.in);
    public static final PrintWriter pw = new PrintWriter(System.out);

    public static boolean heightBfs(int r, int[] h, ArrayList<ArrayList<Integer>> a, int[] vis) {
        Deque<Integer> q = new LinkedList<>();
        q.add(r);
        int c = 1;
        vis[r] = 1;
        h[r] = c;
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
        return true;
    }

    public static ArrayList<ArrayList<Integer>> getGraph(int n, int m) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
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
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            int w = sc.nextInt();
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
        int q = sc.nextInt();
        for (int q0 = 0; q0 < q; q0++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.readString();
            int min = Integer.MAX_VALUE;
            if (x == 0 && y == 0) {
                min = 0;
            }
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'S': y -= 1; break;
                    case 'N': y += 1; break;
                    case 'E': x += 1; break;
                    case 'W': x -= 1; break;
                }
                int t = Math.abs(x) + Math.abs(y);
                if (t <= i + 1) {
                    min = Math.min(min, i + 1);
                }
            }
            if (min == Integer.MAX_VALUE) {
                System.out.println("Case #" + q0 + ": IMPOSSIBLE");
            } else {
                System.out.println("Case #" + q0 + ": " + min);
            }
        }
        pw.flush();
        pw.close();
    }

    public static Comparator<Integer> descendingOrder() {
        return Comparator.reverseOrder();
    }

    public static Comparator<Pair> ascendingOrder() {
        return Comparator.comparingLong(o -> o.j);
    }

    static class TripletL implements Comparable<TripletL> {
        Long x, y, z;

        TripletL(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(TripletL o) {
            int result = x.compareTo(o.x);
            if (result == 0) result = y.compareTo(o.y);
            if (result == 0) result = z.compareTo(o.z);
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof TripletL) {
                TripletL p = (TripletL) o;
                return x.equals(p.x) && y.equals(p.y) && z.equals(p.z);
            }
            return false;
        }

        @Override
        public String toString() {
            return x + " " + y + " " + z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }

    public static String doubleFormat(double a, int n) {
        StringBuilder pattern = new StringBuilder("#0.");
        for (int i = 0; i < n; i++) {
            pattern.append('0');
        }
        DecimalFormat f = new DecimalFormat(pattern.toString());
        return f.format(a);
    }

    public static Comparator<Integer[]> columnComparator(int i, boolean ascending) {
        return (o1, o2) -> ascending ? o1[i].compareTo(o2[i]) : o2[i].compareTo(o1[i]);
    }

    public static Comparator<Long[]> columnComparatorLong(int i, boolean ascending) {
        return (o1, o2) -> ascending ? o1[i].compareTo(o2[i]) : o2[i].compareTo(o1[i]);
    }

    public static Comparator<Integer[]> pairComparator() {
        return (o1, o2) -> {
            int result = o1[0].compareTo(o2[0]);
            if (result == 0) result = o1[1].compareTo(o2[1]);
            return result;
        };
    }

    public static Comparator<Integer[]> tripletComparator() {
        return (o1, o2) -> {
            for (int i = 0; i < 3; i++) {
                int result = o1[i].compareTo(o2[i]);
                if (result != 0) return result;
            }
            return 0;
        };
    }

    public static String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public static int[] scanArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        return a;
    }

    public static long[] scanLongArray(int n) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        return a;
    }

    public static String[] scanStrings(int n) {
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLine();
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
    private int curChar, snumChars;
    private SpaceCharFilter filter;

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
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = res * 10 + c - '0';
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
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = res * 10 + c - '0';
            c = snext();
        } while (!isSpaceChar(c));
        return res * sgn;
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
        while (isSpaceChar(c)) c = snext();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = snext();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        return filter != null ? filter.isSpaceChar(c) : c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    public interface SpaceCharFilter {
        boolean isSpaceChar(int ch);
    }
}