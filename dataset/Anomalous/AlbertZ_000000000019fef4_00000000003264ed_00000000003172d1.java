import java.io.*;
import java.util.*;

public class Solution {
    private static final Scanner sc = new Scanner(System.in);
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final long MOD = 1000000000L;
    private static final double LN2 = Math.log(2);
    private long target;

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int testCases = sc.nextInt();
        for (int i = 1; i <= testCases; i++) {
            out.printf("Case #%d: %d%n", i, solution.solve());
        }
        out.flush();
        System.exit(0);
    }

    private long solve() {
        int n = sc.nextInt();
        int d = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = d * sc.nextLong();
        }
        Arrays.sort(a);

        long ans = d;
        Set<Long> used = new HashSet<>();

        for (int start = 0; start < n; start++) {
            List<Long> list = new ArrayList<>();
            for (int i = start; i < n; i++) {
                list.add(a[i]);
            }

            TreeSet<Long> factors = getFactors(a[start]);
            for (long num : factors) {
                if (!used.add(num)) continue;
                target = num;
                list.sort(new TargetComparator());
                long temp = calculateMinSteps(list, d);
                ans = Math.min(ans, temp);
            }
        }
        return ans;
    }

    private long calculateMinSteps(List<Long> list, long d) {
        int steps = 0;
        for (int i = 0; i < list.size() && d > 0; i++) {
            long current = list.get(i);
            if (current == target) {
                d -= 1;
                continue;
            }
            if (current % target == 0) {
                if (current / target <= d) {
                    d -= current / target;
                    steps += current / target - 1;
                } else {
                    steps += d;
                    d = 0;
                }
            } else {
                long max = current / target;
                steps += Math.min(d, max);
                d -= Math.min(d, max);
            }
        }
        return d == 0 ? steps : Long.MAX_VALUE;
    }

    private TreeSet<Long> getFactors(long n) {
        TreeSet<Long> factors = new TreeSet<>();
        for (long i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                factors.add(n / i);
            }
        }
        return factors;
    }

    private class TargetComparator implements Comparator<Long> {
        @Override
        public int compare(Long o1, Long o2) {
            boolean o1Divisible = o1 % target == 0;
            boolean o2Divisible = o2 % target == 0;
            if (o1Divisible && !o2Divisible) return -1;
            if (!o1Divisible && o2Divisible) return 1;
            return Long.compare(o1, o2);
        }
    }
}