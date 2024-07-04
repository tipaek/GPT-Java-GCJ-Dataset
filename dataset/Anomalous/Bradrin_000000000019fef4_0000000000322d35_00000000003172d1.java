import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numProblems = scan.nextInt();
        for (int i = 0; i < numProblems; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().process(scan);
        }
        scan.close();
    }

    private void process(Scanner scan) {
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

        Arrays.sort(sizes);

        if (d == 2) {
            handleCaseD2(uniqueSizes, sizes);
        } else if (d == 3) {
            handleCaseD3(sizes);
        } else {
            handleGeneralCase(sizes, d);
        }
    }

    private void handleCaseD2(Set<Long> uniqueSizes, long[] sizes) {
        if (uniqueSizes.size() == sizes.length) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private void handleCaseD3(long[] sizes) {
        for (int i = 0; i < sizes.length - 2; i++) {
            if (sizes[i] == sizes[i + 2]) {
                System.out.println(0);
                return;
            }
        }
        for (int i = 0; i < sizes.length - 2; i++) {
            if (sizes[i] == sizes[i + 1]) {
                System.out.println(1);
                return;
            }
        }
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 0; j < sizes.length; j++) {
                if (i != j && sizes[i] * 2 == sizes[j]) {
                    System.out.println(1);
                    return;
                }
            }
        }
        System.out.println(2);
    }

    private void handleGeneralCase(long[] sizes, int d) {
        long best = Long.MAX_VALUE / 2;
        Map<Long, Integer> cache = new HashMap<>();
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] *= d;
        }
        for (int i = 0; i < sizes.length; i++) {
            for (int j = 1; j <= d; j++) {
                best = Math.min(best, findMinOperations(cache, sizes, i, j, d));
            }
        }
        System.out.println(best);
    }

    private long findMinOperations(Map<Long, Integer> cache, long[] sizes, int i, int j, int d) {
        long target = sizes[i] / j;
        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        PriorityQueue<Long> queue = new PriorityQueue<>();
        for (long size : sizes) {
            queue.offer(size);
        }

        int result = 0, count = 0;
        while (!queue.isEmpty() && count < d) {
            long current = queue.poll();
            if (current == target) {
                count++;
            } else if (current > target) {
                count++;
                result++;
                queue.offer(current - target);
            }
        }

        if (count == d) {
            cache.put(target, result);
            return result;
        } else {
            return Long.MAX_VALUE / 2;
        }
    }
}