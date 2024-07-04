import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tests = sc.nextInt();
        sc.nextLine();
        for (int test=1; test<=tests; test++) {
            int n = sc.nextInt();
            int dinners = sc.nextInt();
            long[] slices = new long[n];
            for (int i = 0; i < n; i++) slices[i] = sc.nextLong();
            System.out.println("Case #" + test + ": " + doit(dinners, slices));
        }
    }

    private static int doit(int dinners, long[] slices) {
        HashMap<Long, Integer> freq = new HashMap<>();
        for (long slice : slices) {
            freq.merge(slice, 1, Integer::sum);
        }
        return dp(dinners, freq, 0);
    }

    private static int dp(int dinners, HashMap<Long, Integer> freq, int cur) {
        if (cur >= dinners) return cur;
        int max = 0;
        for (int times : freq.values()) {
            max = Math.max(max, times);
        }
        int ret = cur + Math.max(0, dinners - max);

        for (Map.Entry<Long, Integer> entry : freq.entrySet()) {
            long num = entry.getKey();
            if (entry.getValue() > 0 && num % 2 == 0) {
                HashMap<Long, Integer> freq_new = new HashMap<>(freq);
                freq_new.put(num, freq.get(num) - 1);
                freq_new.merge(num / 2, 2, Integer::sum);
                ret = Math.min(ret, dp(dinners, freq_new, cur + 1));
            }
        }
        return ret;
    }
}
