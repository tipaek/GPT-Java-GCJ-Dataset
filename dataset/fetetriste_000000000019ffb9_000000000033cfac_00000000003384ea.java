import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.SplittableRandom;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        A_IncrementalHouseOfPancakes solver = new A_IncrementalHouseOfPancakes();
        solver.solve(1, in, out);
        out.close();
    }

    static class A_IncrementalHouseOfPancakes {
        final long BIG = (long) (1e18 + 100);

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
//        if (true) {
            if (false) {
                SplittableRandom random = new SplittableRandom(0);
                final int R = 1000;
                for (int test = 0; test < 1000; test++) {
                    long l = random.nextLong(1, R);
                    long r = random.nextLong(1, R);
                    Sol u = slow(l, r);
                    Sol v = fast(l, r);
                    if (!u.equals(v)) {
                        System.out.println(l + " " + r);
                        System.out.println("expected: " + u);
                        System.out.println("received: " + v);
                        throw new AssertionError();
                    }
                }
            }

            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                long l = in.nextLong();
                long r = in.nextLong();
                Sol sol = fast(l, r);
                out.printf("Case #%d: %d %d %d\n", test, sol.customers, sol.l, sol.r);
            }
        }

        private Sol slow(long l, long r) {
            long c = 0;
            for (int i = 1; ; i++) {
                if (l >= r && l >= i) {
                    l -= i;
                    ++c;
                } else if (r >= i) {
                    r -= i;
                    ++c;
                } else {
                    break;
                }
            }
            return new Sol(c, l, r);
        }

        private Sol fast(long l, long r) {
            long c = toCover(1, Math.abs(r - l));
            if (l >= r) {
                l -= sumArithm(1, c);
            } else {
                r -= sumArithm(1, c);
            }
            if (l >= r) {
                if (l >= c + 1) {
                    ++c;
                    l -= c;
                } else {
                    return new Sol(c, l, r);
                }
            }

            if (l >= r) {
                throw new AssertionError();
            }

            long left = 0;
            long right = l + r + 1;
            while (right - left > 1) {
                long mid = left + (right - left) / 2;
                long u = sumArithmSameParity(c + 1, c + mid);
                long v = sumArithm(c + 1, c + mid) - u;
                if (r >= u && l >= v) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            {
                long mid = left;
                long u = sumArithmSameParity(c + 1, c + mid);
                long v = sumArithm(c + 1, c + mid) - u;
                c += mid;
                r -= u;
                l -= v;
            }
            return new Sol(c, l, r);
        }

        private long toCover(long first, long need) {
            long l = first - 1;
            long r = first + need;
            while (r - l > 1) {
                long m = l + (r - l) / 2;
                long s = sumArithm(first, m);
                if (s <= need) {
                    l = m;
                } else {
                    r = m;
                }
            }
            // sum of [first, l] is <= need
            // sum of [first, l+1] is > need
            return l;
        }

        private long sumArithm(long a, long b) {
            // a + ... + b
            if (a > b) {
                return 0;
            }
            BigInteger A = BigInteger.valueOf(a);
            BigInteger B = BigInteger.valueOf(b);
            BigInteger res = A.add(B);
            BigInteger num = B.subtract(A).add(BigInteger.ONE);
            res = res.multiply(num);
            res = res.shiftRight(1);
            if (res.compareTo(BigInteger.valueOf(BIG)) >= 0) {
                return BIG;
            }
            return res.longValue();
        }

        private long sumArithmSameParity(long a, long b) {
            // a + ... + b, all same parity as a
            if (a % 2 != b % 2) {
                --b;
            }
            if (a > b) {
                return 0;
            }
            BigInteger A = BigInteger.valueOf(a);
            BigInteger B = BigInteger.valueOf(b);
            BigInteger res = A.add(B);
            BigInteger num = B.subtract(A).add(BigInteger.ONE);
            num = num.add(BigInteger.ONE).shiftRight(1);
            res = res.multiply(num);
            res = res.shiftRight(1);
            if (res.compareTo(BigInteger.valueOf(BIG)) >= 0) {
                return BIG;
            }
            return res.longValue();
        }

        class Sol {
            long customers;
            long l;
            long r;

            Sol(long customers, long l, long r) {
                this.customers = customers;
                this.l = l;
                this.r = r;
            }

            public boolean equals(Object obj) {
                Sol o = (Sol) obj;
                return customers == o.customers && l == o.l && r == o.r;
            }

            public String toString() {
                return customers + " " + l + " " + r;
            }

        }

    }

    static class FastScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public FastScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

