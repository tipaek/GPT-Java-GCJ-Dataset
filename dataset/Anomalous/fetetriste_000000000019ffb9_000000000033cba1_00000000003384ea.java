import java.io.*;
import java.util.StringTokenizer;
import java.util.SplittableRandom;
import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        PancakeSolver solver = new PancakeSolver();
        solver.solve(1, in, out);
        out.close();
    }

    static class PancakeSolver {
        private static final long BIG = (long) (1e18 + 100);

        public void solve(int testNumber, FastScanner in, PrintWriter out) {
            if (false) {
                performSanityCheck();
            }

            int numTests = in.nextInt();
            for (int test = 1; test <= numTests; test++) {
                long l = in.nextLong();
                long r = in.nextLong();
                PancakeSolution sol = fastSolution(l, r);
                out.printf("Case #%d: %d %d %d\n", test, sol.customers, sol.l, sol.r);
            }
        }

        private void performSanityCheck() {
            SplittableRandom random = new SplittableRandom(0);
            final int R = 1000;
            for (int test = 0; test < 1000; test++) {
                long l = random.nextLong(1, R);
                long r = random.nextLong(1, R);
                PancakeSolution slowResult = slowSolution(l, r);
                PancakeSolution fastResult = fastSolution(l, r);
                if (!slowResult.equals(fastResult)) {
                    System.out.println(l + " " + r);
                    System.out.println("expected: " + slowResult);
                    System.out.println("received: " + fastResult);
                    throw new AssertionError();
                }
            }
        }

        private PancakeSolution slowSolution(long l, long r) {
            long customers = 0;
            for (int i = 1; ; i++) {
                if (l >= r && l >= i) {
                    l -= i;
                    customers++;
                } else if (r >= i) {
                    r -= i;
                    customers++;
                } else {
                    break;
                }
            }
            return new PancakeSolution(customers, l, r);
        }

        private PancakeSolution fastSolution(long l, long r) {
            long customers = calculateStepsToCover(1, Math.abs(r - l));
            if (l >= r) {
                l -= sumArithmeticSeries(1, customers);
            } else {
                r -= sumArithmeticSeries(1, customers);
            }
            if (l >= r) {
                if (l >= customers + 1) {
                    customers++;
                    l -= customers;
                } else {
                    return new PancakeSolution(customers, l, r);
                }
            }

            if (l >= r) {
                throw new AssertionError();
            }

            long left = 0;
            long right = l + r + 1;
            while (right - left > 1) {
                long mid = left + (right - left) / 2;
                long u = sumSameParitySeries(customers + 1, customers + mid);
                long v = sumArithmeticSeries(customers + 1, customers + mid) - u;
                if (r >= u && l >= v) {
                    left = mid;
                } else {
                    right = mid;
                }
            }

            long mid = left;
            long u = sumSameParitySeries(customers + 1, customers + mid);
            long v = sumArithmeticSeries(customers + 1, customers + mid) - u;
            customers += mid;
            r -= u;
            l -= v;

            return new PancakeSolution(customers, l, r);
        }

        private long calculateStepsToCover(long first, long need) {
            long l = first - 1;
            long r = first + need;
            while (r - l > 1) {
                long m = l + (r - l) / 2;
                long s = sumArithmeticSeries(first, m);
                if (s <= need) {
                    l = m;
                } else {
                    r = m;
                }
            }
            return l;
        }

        private long sumArithmeticSeries(long a, long b) {
            if (a > b) {
                return 0;
            }
            BigInteger A = BigInteger.valueOf(a);
            BigInteger B = BigInteger.valueOf(b);
            BigInteger sum = A.add(B).multiply(B.subtract(A).add(BigInteger.ONE)).shiftRight(1);
            return sum.compareTo(BigInteger.valueOf(BIG)) >= 0 ? BIG : sum.longValue();
        }

        private long sumSameParitySeries(long a, long b) {
            if (a % 2 != b % 2) {
                b--;
            }
            if (a > b) {
                return 0;
            }
            BigInteger A = BigInteger.valueOf(a);
            BigInteger B = BigInteger.valueOf(b);
            BigInteger sum = A.add(B).multiply(B.subtract(A).add(BigInteger.ONE).add(BigInteger.ONE).shiftRight(1)).shiftRight(1);
            return sum.compareTo(BigInteger.valueOf(BIG)) >= 0 ? BIG : sum.longValue();
        }

        static class PancakeSolution {
            long customers;
            long l;
            long r;

            PancakeSolution(long customers, long l, long r) {
                this.customers = customers;
                this.l = l;
                this.r = r;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                PancakeSolution that = (PancakeSolution) obj;
                return customers == that.customers && l == that.l && r == that.r;
            }

            @Override
            public String toString() {
                return customers + " " + l + " " + r;
            }
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}