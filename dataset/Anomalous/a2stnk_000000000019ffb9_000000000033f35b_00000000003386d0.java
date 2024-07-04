import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            for (int i = 0; i < T; i++) {
                System.out.printf("Case #%d: ", i + 1);
                solve(sc);
            }
        }
    }

    static void solve(Scanner sc) {
        int N = sc.nextInt();
        long[] x = new long[N];
        long[] y = new long[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        if (N <= 4) {
            System.out.println(N);
            return;
        }

        int maxPoints = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                Map<Long, Integer> map = new HashMap<>();
                if (x[i] == x[j]) {
                    for (int k = 0; k < N; k++) {
                        map.merge(x[k], 1, Integer::sum);
                    }
                } else {
                    for (int k = 0; k < N; k++) {
                        long v1 = y[k] * (x[j] - x[i]) - x[k] * (y[j] - y[i]);
                        long v2 = x[j] - x[i];
                        long gcd = gcd(v1, v2);
                        v1 /= gcd;
                        v2 /= gcd;
                        long v = (v1 * modInverse(v2)) % MOD;
                        map.merge(v, 1, Integer::sum);
                    }
                }
                maxPoints = Math.max(maxPoints, calculateMaxPoints(N, map));
            }
        }

        System.out.println(maxPoints);
    }

    static int calculateMaxPoints(int N, Map<Long, Integer> map) {
        Integer[] values = map.values().toArray(new Integer[0]);
        Arrays.sort(values);

        int singleCount = 0;
        int oddCount = 0;
        for (int size : values) {
            if (size % 2 == 1) {
                if (size == 1) {
                    singleCount++;
                } else {
                    oddCount++;
                }
            }
        }

        singleCount += oddCount % 2;
        return N - Math.max(0, singleCount - 2);
    }

    static long gcd(long a, long b) {
        return a == 0 ? b : gcd(b % a, a);
    }

    static final long MOD = 1000000007;

    static long modInverse(long a) {
        return power(a, MOD - 2);
    }

    static long power(long a, long b) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) != 0) {
                result = (result * a) % MOD;
            }
            b >>= 1;
            a = (a * a) % MOD;
        }
        return result;
    }
}