import java.util.*;

public class Solution {
    private final Scanner scanner = new Scanner(System.in);

    private long solve(int n, int d) {
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
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
                return (a[1] == 2 * a[0]) ? 1 : 2;
            }

            Map<Long, Integer> countMap = new HashMap<>();
            for (long value : a) {
                int count = countMap.getOrDefault(value, 0) + 1;
                if (count >= d) {
                    return 0;
                }
                countMap.put(value, count);
            }

            for (int i = n - 1; i >= 0; i--) {
                if (countMap.containsKey(2 * a[i])) {
                    return 1;
                }
            }

            int result = d - 1;
            for (int i = n - 3; i >= 0; i--) {
                result = Math.min(result, 3 - countMap.get(a[i]));
            }
            return result;
        }
        return n;
    }

    private void run() {
        int testCases = scanner.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.printf("Case #%d: %d%n", t, solve(n, d));
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}