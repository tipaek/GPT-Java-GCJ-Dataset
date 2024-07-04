import java.util.Scanner;

class A {
    static class Output {
        final long ans, L, R;

        public Output(long ans, long l, long r) {
            this.ans = ans;
            L = l;
            R = r;
        }

        @Override
        public String toString() {
            return "Output{" +
                    "ans=" + ans +
                    ", L=" + L +
                    ", R=" + R +
                    '}';
        }
    }

    public static void main(String... args) throws Exception {
        try (final Scanner sc = new Scanner(System.in)) {
            final int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                long L = sc.nextLong();
                long R = sc.nextLong();
                final Output output = large(L, R);
//                System.out.println(small2(L, R));
//                System.out.println(output);
                System.out.printf("Case #%s: %d %d %d\n", t, output.ans, output.L, output.R);
            }
        }
    }

    public static Output small(long L, long R) {
        long ans = 0;
        while (ans < L || ans < R) {
            if (L >= R) {
                L -= ++ans;
            } else {
                R -= ++ans;
            }
        }
        return new Output(ans, L, R);
    }

    public static Output small2(long L, long R) {
        long ans = 0;
        if (L > R) {
            final long n = (long) Math.floor((Math.sqrt(8 * (L - R) + 1) - 1) * .5 + 1e-9);
            ans += n;
            L -= n * (n + 1) / 2;
        }
        if (L < R) {
            final long n = (long) Math.floor((Math.sqrt(8 * (R - L) + 1) - 1) * .5 + 1e-9);
            ans += n;
            R -= n * (n + 1) / 2;
        }
        if (L < R) {
            R -= ++ans;
        }
        System.out.println(ans + " " + L + " " + R);
        while (ans < L || ans < R) {
            if (L >= R) {
                L -= ++ans;
                System.out.print('L');
            } else {
                R -= ++ans;
                System.out.print('R');
            }
        }
        System.out.println();
        return new Output(ans, L, R);
    }

    public static Output large(long L, long R) {
        long ans = 0;
        if (L > R) {
            final long n = (long) Math.floor((Math.sqrt(8 * (L - R) + 1) - 1) * .5 + 1e-9);
            ans += n;
            L -= n * (n + 1) / 2;
        }
        if (L < R) {
            final long n = (long) Math.floor((Math.sqrt(8 * (R - L) + 1) - 1) * .5 + 1e-9);
            ans += n;
            R -= n * (n + 1) / 2;
        }
        if (L < R) {
            R -= ++ans;
        }
        final long ln = (long) Math.floor((Math.sqrt(ans * ans + 4 * L) - ans) * .5 + 1e-9);
        final long rn = (long) Math.floor((Math.sqrt((ans + 1) * (ans + 1) + 4 * R) - ans - 1) * .5 + 1e-9);
        L -= ln * (ans + ln);
        R -= rn * (ans + 1 + rn);
        ans += ln + rn;
        return new Output(ans, L, R);
    }
}

public class Solution {
    public static void main(String...args) throws Exception {
        A.main();
    }
}
