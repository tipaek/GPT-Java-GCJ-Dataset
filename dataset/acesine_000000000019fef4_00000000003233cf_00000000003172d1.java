
import java.util.*;

public class Solution {
    Scanner in = new Scanner(System.in);

    long solve(int n, int d) {
        long[] a = new long[n];
        for (int i=0;i<n;i++) a[i] = in.nextLong();
        Arrays.sort(a);
        if (d == 2) {
            for (int i=1;i<n;i++) {
                if (a[i] == a[i-1]) return 0;
            }
            return 1;
        } else if (d == 3) {
            if (n == 1) return 2;
            if (n == 2) {
                if (a[1] == 2 * a[0]) return 1;
                return 2;
            }
            Map<Long, Integer> cnt = new HashMap<>();
            for (int i=0;i<n;i++) {
                int c = cnt.getOrDefault(a[i], 0) + 1;
                if (c >= 3) return 0;
                cnt.put(a[i], c);
            }
            int r = 2;
            for (int i=n-2;i>=0;i--) {
                if (cnt.containsKey(2 * a[i])) return 1;
                r = Math.min(r, 3 - cnt.get(a[i]));
            }
            return r;
        }
        return n;
    }

    void run() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            System.out.println(String.format("Case #%d: %d", t, solve(in.nextInt(), in.nextInt())));
        }
    }

    public static void main(String[] args) {
        new Solution().run();
    }
}
