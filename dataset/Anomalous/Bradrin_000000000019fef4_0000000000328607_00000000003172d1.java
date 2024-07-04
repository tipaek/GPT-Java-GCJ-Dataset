import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfProblems = scanner.nextInt();
        for (int problemIndex = 0; problemIndex < numberOfProblems; problemIndex++) {
            System.out.print("Case #" + (problemIndex + 1) + ": ");
            new Solution().solve(scanner);
        }
        scanner.close();
    }

    private void solve(Scanner scanner) {
        int numberOfSizes = scanner.nextInt();
        int requiredDivisors = scanner.nextInt();

        Map<BigInteger, Integer> cache = new HashMap<>();
        BigInteger[] sizes = new BigInteger[numberOfSizes];
        BigInteger multiplier = factorial(50);

        for (int i = 0; i < numberOfSizes; i++) {
            sizes[i] = BigInteger.valueOf(scanner.nextLong()).multiply(multiplier);
        }

        long minimumResult = Long.MAX_VALUE / 2;

        for (int i = 0; i < numberOfSizes; i++) {
            for (int j = 1; j <= requiredDivisors; j++) {
                minimumResult = Math.min(minimumResult, findSolution(cache, sizes, i, j, requiredDivisors));
            }
        }

        System.out.println(minimumResult);
    }

    private static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private static long findSolution(Map<BigInteger, Integer> cache, BigInteger[] sizes, int index, int divisor, int requiredDivisors) {
        BigInteger target = sizes[index].divide(BigInteger.valueOf(divisor));

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        List<BigInteger> sortedSizes = new ArrayList<>(Arrays.asList(sizes));
        Collections.sort(sortedSizes);

        int result = 0;
        int count = 0;

        List<BigInteger> toRemove = new ArrayList<>();
        for (BigInteger size : sortedSizes) {
            if (size.mod(target).equals(BigInteger.ZERO)) {
                toRemove.add(size);
                count += size.divide(target).intValue();
                result += size.divide(target).intValue() - 1;
                if (count >= requiredDivisors) {
                    break;
                }
            }
        }

        PriorityQueue<BigInteger> remainingSizes = new PriorityQueue<>(sortedSizes);
        remainingSizes.removeAll(toRemove);

        while (!remainingSizes.isEmpty() && count < requiredDivisors) {
            BigInteger current = remainingSizes.poll();
            if (current.equals(target)) {
                count++;
                continue;
            }
            if (current.compareTo(target) < 0) {
                continue;
            }
            count++;
            result++;
            remainingSizes.offer(current.subtract(target));
        }

        if (count == requiredDivisors) {
            cache.put(target, result);
            return result;
        } else {
            return Long.MAX_VALUE / 2;
        }
    }
}