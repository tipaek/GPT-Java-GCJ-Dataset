import java.util.*;

public class Solution {

    private void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();

        Map<Long, Integer> cache = new HashMap<>();
        long[] sizes = new long[n];

        for (int i = 0; i < n; i++) {
            sizes[i] = scanner.nextLong() * d;
        }

        long bestResult = Long.MAX_VALUE / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= d; j++) {
                bestResult = Math.min(bestResult, computeResult(cache, sizes, i, j, d));
            }
        }

        System.out.println(bestResult);
    }

    private static long computeResult(Map<Long, Integer> cache, long[] sizes, int index, int divisor, int d) {
        long target = sizes[index] / divisor;

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (long size : sizes) {
            queue.offer(size);
        }

        int result = 0;
        int matchCount = 0;
        while (!queue.isEmpty() && matchCount < d) {
            long current = queue.poll();
            if (current == target) {
                matchCount++;
                continue;
            }
            if (current < target) {
                continue;
            }
            matchCount++;
            result++;
            queue.offer(current - target);
        }

        if (matchCount == d) {
            cache.put(target, result);
            return result;
        } else {
            return Long.MAX_VALUE / 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int problemCount = scanner.nextInt();
        for (int i = 0; i < problemCount; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().solve(scanner);
        }
        scanner.close();
    }
}