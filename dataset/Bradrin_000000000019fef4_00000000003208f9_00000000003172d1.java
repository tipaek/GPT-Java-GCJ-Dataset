import java.util.*;

public class Solution {

    private void solve(Scanner scan) {
        int n = scan.nextInt();
        int d = scan.nextInt();

        Map<Long, Integer> cache = new HashMap<>();

        long[] sizes = new long[n];

        for (int i = 0; i < n; i++) {
            sizes[i] = scan.nextLong() * d;
        }

        long best = Long.MAX_VALUE / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= d; j++) {
                best = Math.min(best, solve(cache, sizes, i, j, d));
            }
        }

        System.out.println(best);
    }

    private static long solve(Map<Long, Integer> cache, long[] sizes, int i, int j, int d) {
        long target = sizes[i] / j;

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        PriorityQueue<Long> queue = new PriorityQueue<>();

        for (long s : sizes) {
            queue.offer(s);
        }

        int result = 0;
        int count = 0;
        while (!queue.isEmpty() && count < d) {
            long current = queue.poll();
            if (current == target) {
                count++;
                continue;
            }
            if (current < target) {
                continue;
            }
            count++;
            result++;
            queue.offer(current - target);
        }

        if (count == d) {
            cache.put(target, result);
            return result;
        } else {
            return Long.MAX_VALUE / 2;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int problems = scan.nextInt();
        for (int count = 0; count < problems; count++) {
            System.out.print("Case #" + (count+1) + ": ");
            new Solution().solve(scan);
        }
        scan.close();
    }
}
