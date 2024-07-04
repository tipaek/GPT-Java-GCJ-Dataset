import java.util.*;

public class Solution {

    private void solve(Scanner scan) {
        int n = scan.nextInt();
        int d = scan.nextInt();

        long[] sizes = new long[n];
        for (int i = 0; i < n; i++) {
            sizes[i] = scan.nextLong();
        }

        Set<Long> uniqueSizes = new HashSet<>();
        for (long size : sizes) {
            uniqueSizes.add(size);
        }

        if (d == 2) {
            System.out.println(uniqueSizes.size() == n ? 1 : 0);
            return;
        } else if (d == 3) {
            if (uniqueSizes.size() + 2 <= n) {
                System.out.println(0);
                return;
            }
            if (uniqueSizes.size() + 1 == n && sizes[n - 2] != sizes[n - 1]) {
                System.out.println(1);
                return;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j && sizes[i] * 2 == sizes[j]) {
                        System.out.println(1);
                        return;
                    }
                }
            }
            System.out.println(2);
            return;
        }

        long best = Long.MAX_VALUE / 2;
        for (int i = 0; i < n; i++) {
            sizes[i] *= d;
        }

        Map<Long, Integer> cache = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= d; j++) {
                best = Math.min(best, findMinimumOperations(cache, sizes, i, j, d));
            }
        }

        System.out.println(best);
    }

    private static long findMinimumOperations(Map<Long, Integer> cache, long[] sizes, int i, int j, int d) {
        long target = sizes[i] / j;

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (long size : sizes) {
            queue.offer(size);
        }

        int operations = 0;
        int count = 0;
        while (!queue.isEmpty() && count < d) {
            long current = queue.poll();
            if (current == target) {
                count++;
            } else if (current > target) {
                count++;
                operations++;
                queue.offer(current - target);
            }
        }

        if (count == d) {
            cache.put(target, operations);
            return operations;
        } else {
            return Long.MAX_VALUE / 2;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count + 1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}