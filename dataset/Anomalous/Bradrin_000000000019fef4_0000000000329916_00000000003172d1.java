import java.math.BigInteger;
import java.util.*;

public class Solution {

    private void solve(Scanner scanner) {
        int n = scanner.nextInt();
        int d = scanner.nextInt();

        Map<BigInteger, Integer> cache = new HashMap<>();
        BigInteger[] sizes = new BigInteger[n];

        BigInteger multiplier = factorial(50);

        for (int i = 0; i < n; i++) {
            sizes[i] = BigInteger.valueOf(scanner.nextLong()).multiply(multiplier);
        }

        long minimumCost = Long.MAX_VALUE / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= d; j++) {
                minimumCost = Math.min(minimumCost, findMinimumCost(cache, sizes, i, j, d));
            }
        }

        System.out.println(minimumCost);
    }

    private static BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i < number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private static long findMinimumCost(Map<BigInteger, Integer> cache, BigInteger[] sizes, int index, int divisor, int targetCount) {
        BigInteger targetSize = sizes[index].divide(BigInteger.valueOf(divisor));

        if (cache.containsKey(targetSize)) {
            return cache.get(targetSize);
        }

        List<BigInteger> sortedSizes = new ArrayList<>(Arrays.asList(sizes));
        Collections.sort(sortedSizes);

        int totalCost = 0;
        int currentCount = 0;

        List<BigInteger> removableSizes = new ArrayList<>();
        for (BigInteger size : sortedSizes) {
            if (size.mod(targetSize).equals(BigInteger.ZERO)) {
                removableSizes.add(size);
                BigInteger chunks = size.divide(targetSize);
                int remainingChunks = targetCount - currentCount;
                if (chunks.intValue() <= remainingChunks) {
                    currentCount += chunks.intValue();
                    totalCost += chunks.intValue() - 1;
                } else {
                    totalCost += remainingChunks;
                    currentCount = targetCount;
                }
                if (currentCount >= targetCount) {
                    break;
                }
            }
        }

        sortedSizes.removeAll(removableSizes);
        PriorityQueue<BigInteger> sizeQueue = new PriorityQueue<>(sortedSizes);

        while (!sizeQueue.isEmpty() && currentCount < targetCount) {
            BigInteger currentSize = sizeQueue.poll();
            if (currentSize.equals(targetSize)) {
                currentCount++;
            } else if (currentSize.compareTo(targetSize) >= 0) {
                currentCount++;
                totalCost++;
                sizeQueue.offer(currentSize.subtract(targetSize));
            }
        }

        if (currentCount == targetCount) {
            cache.put(targetSize, totalCost);
            return totalCost;
        } else {
            return Long.MAX_VALUE / 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().solve(scanner);
        }
        scanner.close();
    }
}