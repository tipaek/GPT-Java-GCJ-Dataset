import java.io.*;
import java.util.*;

public class Solution implements Runnable {

    public static void main(String[] args) {
        new Thread(null, new Solution(), "process", 1 << 26).start();
    }

    public void run() {
        FastReader scan = new FastReader();
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        Task solver = new Task();
        int t = scan.nextInt();
        for (int i = 1; i <= t; i++) {
            solver.solve(i, scan, out);
        }
        out.close();
    }

    static class Task {
        static final int INF = Integer.MAX_VALUE;
        long sea = 0;
        long n, m;

        public void solve(int testNumber, FastReader sc, PrintWriter pw) {
            n = sc.nextLong();
            m = sc.nextLong();
            long x = Math.abs(n - m);
            sea = x;
            x = search();
            if (n < m) {
                m -= sumUpTo(x);
            } else {
                n -= sumUpTo(x);
            }
            if (n <= m) {
                long move = search2(m, n, x);
                n -= squareSum((move + 1) / 2) - squareSum((x + 1) / 2);
                m -= doubleSum(move / 2) - doubleSum(x / 2);
                pw.printf("Case #%d: %d %d %d%n", testNumber, move, n, m);
            } else {
                long move = search2(n, m, x);
                m -= squareSum((move + 1) / 2) - squareSum((x + 1) / 2);
                n -= doubleSum(move / 2) - doubleSum(x / 2);
                pw.printf("Case #%d: %d %d %d%n", testNumber, move, n, m);
            }
        }

        public long search() {
            long lo = 0, hi = 1_000_000_003;
            for (int i = 0; i < 64; i++) {
                long mid = (lo + hi) / 2;
                if (sumUpTo(mid) >= sea) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            return Math.max(lo, hi);
        }

        public long search2(long n, long m, long off) {
            long lo = off, hi = 1_000_000_003;
            for (int i = 0; i < 64; i++) {
                long mid = (lo + hi) / 2;
                long odds = (mid + 1) / 2;
                long odda = (off + 1) / 2;
                long evens = mid / 2;
                long evena = off / 2;
                if (n - squareSum(odds) + squareSum(odda) >= 0 && m - doubleSum(evens) + doubleSum(evena) >= 0) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
            return lo;
        }

        long sumUpTo(long a) {
            return a * (a + 1) / 2;
        }

        long doubleSum(long a) {
            return a * (a + 1);
        }

        long squareSum(long a) {
            return a * a;
        }
    }

    static long binpow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % m;
            }
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }

    static void sort(int[] x) {
        shuffle(x);
        Arrays.sort(x);
    }

    static void sort(long[] x) {
        shuffle(x);
        Arrays.sort(x);
    }

    static class Tuple implements Comparable<Tuple> {
        int a, b;

        Tuple(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Tuple o) {
            return Integer.compare(o.b, b);
        }
    }

    static void shuffle(int[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = rand.nextInt(i + 1);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static void shuffle(long[] a) {
        Random rand = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = rand.nextInt(i + 1);
            long temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}