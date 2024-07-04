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

        long optimalResult = Long.MAX_VALUE / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= d; j++) {
                optimalResult = Math.min(optimalResult, calculate(cache, sizes, i, j, d));
            }
        }

        System.out.println(optimalResult);
    }

    private static BigInteger factorial(int number) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i < number; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private static long calculate(Map<BigInteger, Integer> cache, BigInteger[] sizes, int index, int divisor, int d) {
        BigInteger target = sizes[index].divide(BigInteger.valueOf(divisor));

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        PriorityQueue<BigInteger> queue = new PriorityQueue<>(Arrays.asList(sizes));
        int result = 0;
        int count = 0;

        while (!queue.isEmpty() && count < d) {
            BigInteger current = queue.poll();
            if (current.equals(target)) {
                count++;
            } else if (current.compareTo(target) > 0) {
                count++;
                result++;
                queue.offer(current.subtract(target));
            }
        }

        if (count == d) {
            cache.put(target, result);
            return result;
        } else {
            return Long.MAX_VALUE / 2;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfProblems = scanner.nextInt();
        for (int i = 0; i < numberOfProblems; i++) {
            System.out.print("Case #" + (i + 1) + ": ");
            new Solution().solve(scanner);
        }
        scanner.close();
    }
}