import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int tc = 1; tc <= T; ++tc) {
            long L = sc.nextLong();
            long R = sc.nextLong();

            System.out.println(String.format("Case #%d: %s", tc, solve(L, R)));
        }

        sc.close();
    }

    static String solve(long L, long R) {
        int n = 0;

        if (L >= R) {
            int round = computeRound(L - R);
            n += round;

            L -= round * (round + 1L) / 2;
        } else {
            int round = computeRound(R - L);
            n += round;

            R -= round * (round + 1L) / 2;
        }

        if (L < R && R >= n + 1) {
            R -= n + 1;
            ++n;
        }

        int pair = computePair(n, L, R);
        L -= pair * (n + 1L) + pair * (pair - 1L);
        R -= pair * (n + 2L) + pair * (pair - 1L);
        n += pair * 2;

        if (L >= n + 1) {
            L -= n + 1;
            ++n;
        }

        return String.format("%d %d %d", n, L, R);
    }

    static int computePair(int n, long L, long R) {
        int result = -1;
        int lower = 0;
        int upper = Integer.MAX_VALUE;
        while (lower <= upper) {
            int middle = lower + (upper - lower) / 2;

            long left = middle * (n + 1L) + middle * (middle - 1L);
            long right = middle * (n + 2L) + middle * (middle - 1L);

            if (left <= L && right <= R) {
                result = middle;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return result;
    }

    static int computeRound(long diff) {
        int result = -1;
        int lower = 0;
        int upper = Integer.MAX_VALUE;
        while (lower <= upper) {
            int middle = lower + (upper - lower) / 2;

            if (middle * (middle + 1L) / 2 <= diff) {
                result = middle;
                lower = middle + 1;
            } else {
                upper = middle - 1;
            }
        }

        return result;
    }
}