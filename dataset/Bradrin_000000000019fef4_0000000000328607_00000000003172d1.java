import java.math.BigInteger;
import java.util.*;

public class Solution {

    private void solve(Scanner scan) {
        int n = scan.nextInt();
        int d = scan.nextInt();

        Map<BigInteger, Integer> cache = new HashMap<>();

        BigInteger[] sizes = new BigInteger[n];

        BigInteger mult = fact(50);

        for (int i = 0; i < n; i++) {
            sizes[i] = BigInteger.valueOf(scan.nextLong()).multiply(mult);
        }

        long best = Long.MAX_VALUE / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= d; j++) {
                best = Math.min(best, solve(cache, sizes, i, j, d));
            }
        }

        System.out.println(best);
    }

    private static BigInteger fact(int n) {
        BigInteger r = BigInteger.ONE;
        for (int i = 1; i < n; i++) {
            r = r.multiply(BigInteger.valueOf(i));
        }
        return r;
    }

    private static long solve(Map<BigInteger, Integer> cache, BigInteger[] sizes, int i, int j, int d) {
        BigInteger target = sizes[i].divide(BigInteger.valueOf(j));

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        List<BigInteger> values = new ArrayList<>();
        for (BigInteger s : sizes) {
            values.add(s);
        }
        Collections.sort(values);

        int result = 0;
        int count = 0;

        List<BigInteger> toRemove = new ArrayList<>();
        for (int k = 0; k < values.size(); k++) {
            if (values.get(k).mod(target).equals(BigInteger.ZERO)) {
                toRemove.add(values.get(k));
                count += values.get(k).divide(target).intValue();
                result += values.get(k).divide(target).intValue() - 1;
                if (count >= d) {
                    break;
                }
            }
        }

        PriorityQueue<BigInteger> queue = new PriorityQueue<>();
        for (BigInteger b : toRemove) {
            values.remove(b);
        }
        for (BigInteger b : values) {
            queue.offer(b);
        }

        while (!queue.isEmpty() && count < d) {
            BigInteger current = queue.poll();
            if (current.equals(target)) {
                count++;
                continue;
            }
            if (current.compareTo(target) < 0) {
                continue;
            }
            count++;
            result++;
            queue.offer(current.subtract(target));
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
