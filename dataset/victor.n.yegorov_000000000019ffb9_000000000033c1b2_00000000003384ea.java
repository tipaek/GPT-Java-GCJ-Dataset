import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        debug();
//        test();
        release();
    }

    private static void release() {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= t; ++i) {
            String output = solve(sc.nextLong(), sc.nextLong());
            sb.append("Case #").append(i).append(": ").append(output).append("\n");
        }
        System.out.print(sb);
    }

    private static void debug() {
        for (int i = 0; i < 1000; i++) {
            for (int j = 0; j < 1000; j++) {
                long l = i + 1, r = j + 1;
                String sNaive = solveNaive(l, r);
                String s = solve(l, r);
                if (!s.equals(sNaive)) {
                    System.out.printf("%d %d, expected: %s, actual: %s%n", l, r, sNaive, s);
                    return;
                }
            }
        }
    }

    private static void test() {
        Random rnd = new Random();
        final long u = 1000000000000000000L;
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            long l = Math.abs(rnd.nextLong()) % u + 1;
            long r = Math.abs(rnd.nextLong()) % u + 1;
            solve(l, r);
        }
        System.out.println((System.currentTimeMillis() - time));
    }

    private static String solveNaive(long l, long r) {
        int k = 1;
        while (l >= k || r >= k) {
            if (l >= r) {
                l -= k;
            } else {
                r -= k;
            }
            ++k;
        }
        return String.format("%d %d %d", k - 1, l, r);
    }

    private static String solve(long l, long r) {
        long d = Math.abs(l - r) << 1;
        long k = (long) Math.sqrt(d) - 1;
        while (k * (k + 1) <= d) {
            ++k;
        }

        d = k * (k - 1) >> 1;
        if (l >= r) {
            l -= d;
        } else {
            r -= d;
        }

        boolean stop = false;
        if (l < r) {
            if (r >= k) {
                r -= k;
                ++k;
            } else {
                stop = true;
            }
        }

        if (!stop) {
            long p = (long) ((Math.sqrt(k * k + 4 * l) - k) / 2);
            while (l >= (k + p - 1) * p) {
                ++p;
            }

            --p;
            l -= (k + p - 1) * p;
            r -= (k + p) * p;
            k += p << 1;
            if (r < 0) {
                --k;
                r += k;
            }
        }

        return String.format("%d %d %d", k - 1, l, r);
    }
}