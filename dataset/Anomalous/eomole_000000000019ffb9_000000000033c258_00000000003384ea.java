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
            return String.format("Output{ans=%d, L=%d, R=%d}", ans, L, R);
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int t = 1; t <= T; t++) {
                long L = sc.nextLong();
                long R = sc.nextLong();
                Output output = calculateOutput(L, R);
                System.out.printf("Case #%d: %d %d %d%n", t, output.ans, output.L, output.R);
            }
        }
    }

    public static Output calculateOutput(long L, long R) {
        long ans = 0;
        if (L > R) {
            long n = (long) Math.floor((Math.sqrt(8 * (L - R) + 1) - 1) * 0.5 + 1e-9);
            ans += n;
            L -= n * (n + 1) / 2;
        }
        if (L < R) {
            long n = (long) Math.floor((Math.sqrt(8 * (R - L) + 1) - 1) * 0.5 + 1e-9);
            ans += n;
            R -= n * (n + 1) / 2;
        }
        if (L < R) {
            R -= ++ans;
        }
        long ln = (long) Math.floor((Math.sqrt(ans * ans + 4 * L) - ans) * 0.5 + 1e-9);
        long rn = (long) Math.floor((Math.sqrt((ans + 1) * (ans + 1) + 4 * R) - ans - 1) * 0.5 + 1e-9);
        L -= ln * (ans + ln);
        R -= rn * (ans + 1 + rn);
        ans += ln + rn;
        return new Output(ans, L, R);
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
        A.main(args);
    }
}