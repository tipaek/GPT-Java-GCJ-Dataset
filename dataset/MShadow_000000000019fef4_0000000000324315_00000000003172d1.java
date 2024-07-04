import java.util.*;

public class Solution {

    private static int solve(int n, int d, long[] a) {
        if (d == 2) {
            Set<Long> set = new HashSet<>();
            for (long aa : a) {
                if (set.contains(aa)) return 0;
                set.add(aa);
            }

            return 1;
        } else {
            Map<Long, Integer> map = new HashMap<>();
            for (long aa : a) {
                if (map.containsKey(aa) && map.get(aa) == 2) {
                    return 0;
                }
                map.compute(aa, (k, v) -> v == null ? 1 : v + 1);
            }

            for (long aa : a) {
                if (map.containsKey(aa * 2)) return 1;
            }

            return 2;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int ks = 1; ks <= T; ++ks) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            System.out.println("Case #" + ks + ": " + solve(n, d, a));
        }
    }
}