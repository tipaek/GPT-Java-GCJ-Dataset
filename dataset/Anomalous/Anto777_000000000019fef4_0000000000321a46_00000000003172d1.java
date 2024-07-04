import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.math.BigInteger;

public final class Solution {
    private BufferedReader br;
    private StringTokenizer stk;
    private static final long MOD = 998244353;

    public static void main(String[] args) {
        new Thread(null, () -> {
            try {
                new Solution().run();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }, "solution", 1 << 26).start();
    }

    public Solution() {
        stk = null;
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void run() throws Exception {
        int t = ni();
        for (int I = 1; I <= t; I++) {
            int n = ni();
            int d = ni();
            long[] slices = new long[n];
            for (int i = 0; i < n; i++) {
                slices[i] = nl();
            }
            HashSet<Long> div = new HashSet<>();
            addDivisors(slices, div);
            sortAndReverse(slices);

            int minCuts = d - 1;
            for (long num : div) {
                int cuts = getCuts(num, d, slices);
                if (cuts != -1) {
                    minCuts = Math.min(minCuts, cuts);
                }
            }

            pl("Case #" + I + ": " + minCuts);
        }
    }

    private void addDivisors(long[] slices, HashSet<Long> divisors) {
        int n = slices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                divisors.add(1L);
                divisors.add(slices[i]);
                divisors.add(gcd(slices[i], slices[j]));
            }
        }
    }

    private int getCuts(long num, int req, long[] slices) {
        int n = slices.length;
        int cuts = 0;
        int[] taken = new int[n];

        for (int i = 0; i < n; i++) {
            if (slices[i] == num) {
                taken[i] = 1;
                req--;
                if (req <= 0) return cuts;
            }
        }

        for (int i = 0; i < n; i++) {
            if (taken[i] == 1) continue;
            if (slices[i] % num == 0) {
                taken[i] = 1;
                long temp = slices[i] / num;
                if (req - temp < 0) {
                    cuts += req;
                    req = 0;
                } else {
                    req -= temp;
                    cuts += temp - 1;
                }
                if (req <= 0) return cuts;
            }
        }

        for (int i = 0; i < n; i++) {
            if (taken[i] == 1) continue;
            long temp = slices[i] / num;
            if (req - temp <= 0) {
                cuts += req;
                req = 0;
            } else {
                req -= temp;
                cuts += temp;
            }
            if (req <= 0) return cuts;
        }

        return -1; // impossible
    }

    private void sortAndReverse(long[] a) {
        Arrays.sort(a);
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            long temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    private long gcd(long a, long b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
    }

    private String nextToken() throws Exception {
        if (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine(), " ");
        }
        return stk.nextToken();
    }

    private int ni() throws Exception {
        return Integer.parseInt(nextToken());
    }

    private long nl() throws Exception {
        return Long.parseLong(nextToken());
    }

    private void pl(Object o) {
        System.out.println(o);
    }
}