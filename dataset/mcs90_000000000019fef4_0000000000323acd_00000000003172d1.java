import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Objects;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        OversizedPancakes solver = new OversizedPancakes();
        int testCount = Integer.parseInt(in.next());
        for (int i = 1; i <= testCount; i++)
            solver.solve(i, in, out);
        out.close();
    }

    static class OversizedPancakes {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int D = in.nextInt();
            long[] A = new long[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.nextLong();
            }

            int res = solve(N, D, A);
            out.println(String.format("Case #%d: %d", testNumber, res));
        }

        private int solve(int N, int D, long[] A) {
            Arrays.sort(A);

            Set<OversizedPancakes.Fraction> targetSizes = new HashSet<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < D; j++) {
                    OversizedPancakes.Fraction f = new OversizedPancakes.Fraction(A[i], j + 1);
                    targetSizes.add(f);
                }
            }

            int res = D - 1;
            for (OversizedPancakes.Fraction t : targetSizes) {
                int fulls = 0;
                long fullD = 0;
                long partialD = 0;
                for (int i = 0; i < N; ++i) {
                    long d = A[i] * t.y / t.x;
                    if (A[i] * t.y == t.x * d) {
                        fullD += d;
                        fulls++;
                        if (fullD >= D) {
                            if (fullD > D) --fulls;
                            res = Math.min(res, D - fulls);
                            break;
                        }
                    } else {
                        partialD += d;
                    }
                }
                if (fullD < D && fullD + partialD >= D) {
                    res = Math.min(res, D - fulls);
                }
            }

            return res;
        }

        static class Fraction implements Comparable<OversizedPancakes.Fraction> {
            long x;
            long y;

            Fraction(long x, long y) {
                long g = gcd(x, y);
                this.x = x / g;
                this.y = y / g;
            }

            long gcd(long x, long y) {
                return y == 0 ? x : gcd(y, x % y);
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                OversizedPancakes.Fraction fraction = (OversizedPancakes.Fraction) o;
                return x == fraction.x &&
                        y == fraction.y;
            }

            public int hashCode() {
                return Objects.hash(x, y);
            }

            public int compareTo(OversizedPancakes.Fraction fraction) {
                return Long.compare(x * fraction.y, y * fraction.x);
            }

            public String toString() {
                return "Fraction{" + x + "/" + y + '}';
            }

        }

    }
}

