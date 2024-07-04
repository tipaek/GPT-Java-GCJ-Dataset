import java.util.*;

public class Solution {
    private final Scanner in = new Scanner(System.in);

    private long solve(int n, int d) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        Arrays.sort(a);

        if (d == 2) {
            for (int i = 1; i < n; i++) {
                if (a[i] == a[i - 1]) {
                    return 0;
                }
            }
            return 1;
        } else if (d == 3) {
            if (n == 1) {
                return 2;
            }
            if (n == 2) {
                if (a[1] == 2 * a[0]) {
                    return 1;
                }
                return 2;
            }

            Map<Long, Integer> countMap = new HashMap<>();
            for (long value : a) {
                int count = countMap.getOrDefault(value, 0) + 1;
                if (count >= 3) {
                    return 0;
                }
                countMap.put(value, count);
            }

            int result = 2;
            for (int i = n - 2; i >= 0; i--) {
                if (countMap.containsKey(2 * a[i])) {
                    return 1;
                }
                result = Math.min(result, 3 - countMap.get(a[i]));
            }
            return result;
        }

        return n;
    }

    private void run() {
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            int d = in.nextInt();
            System.out.printf("Case #%d: %d%n", t, solve(n, d));
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}