import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public final class Solution {
    private BufferedReader br;
    private StringTokenizer stk;
    private static final long MOD = 998244353;

    public static void main(String[] args) {
        new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    new Solution().run();
                } catch (Exception | Error ex) {
                    ex.printStackTrace();
                }
            }
        }, "solution", 1 << 26).start();
    }

    public Solution() {
        this.stk = null;
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    private void run() throws Exception {
        int t = nextInt();
        for (int I = 1; I <= t; I++) {
            int n = nextInt();
            int d = nextInt();
            long[] slices = new long[n];
            for (int i = 0; i < n; i++) {
                slices[i] = nextLong();
            }
            HashSet<Long> divisors = new HashSet<>();
            for (long slice : slices) {
                addDivisors(slice, divisors);
            }
            Arrays.sort(slices);
            reverseArray(slices);

            int minCuts = d - 1;
            for (long divisor : divisors) {
                int cuts = calculateCuts(divisor, d, slices);
                if (cuts != -1) {
                    minCuts = Math.min(minCuts, cuts);
                }
            }

            System.out.println("Case #" + I + ": " + minCuts);
        }
    }

    private void addDivisors(long num, HashSet<Long> divisors) {
        for (long i = 1; i <= Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                divisors.add(i);
                divisors.add(num / i);
            }
        }
    }

    private int calculateCuts(long num, int required, long[] slices) {
        int n = slices.length, cuts = 0;
        boolean[] taken = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (slices[i] == num) {
                taken[i] = true;
                required--;
                if (required <= 0) {
                    return cuts;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (taken[i]) continue;
            if (slices[i] % num == 0) {
                taken[i] = true;
                long temp = slices[i] / num;
                if (required - temp < 0) {
                    cuts += required;
                    required = 0;
                } else {
                    required -= temp;
                    cuts += temp - 1;
                }
                if (required <= 0) {
                    return cuts;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (taken[i]) continue;
            long temp = slices[i] / num;
            if (required - temp <= 0) {
                cuts += required;
                required = 0;
            } else {
                required -= temp;
                cuts += temp;
            }
            if (required <= 0) {
                return cuts;
            }
        }
        return -1;
    }

    private void reverseArray(long[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private String nextToken() throws Exception {
        while (stk == null || !stk.hasMoreTokens()) {
            stk = new StringTokenizer(br.readLine());
        }
        return stk.nextToken();
    }

    private int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }
}