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
        TreeMap<Long, Integer> freq = new TreeMap<>();
        for (long slice : slices) {
            freq.merge(slice, 1, Integer::sum);
        }
        return dp(dinners, freq, 0);
    }

    private static int dp(int dinners, TreeMap<Long, Integer> freq, int cur) {
        if (cur >= dinners) return cur;
        int max = 0;
        for (int times : freq.values()) {
            max = Math.max(max, times);
        }
        int ret = cur + Math.max(0, dinners - max);

        List<Map.Entry<Long, Integer>> list = new ArrayList<>(freq.entrySet());
        for (int i = 0; i < list.size() - 1; i++) {
            long ikey = list.get(i).getKey();
            for (int j = i + 1; j < list.size(); j++) {
                long jkey = list.get(j).getKey();
                if (ikey > jkey && ikey % jkey == 0) {
                    TreeMap<Long, Integer> freq_new = new TreeMap<>(freq);
                    freq_new.put(ikey, freq_new.get(ikey) - 1);
                    freq_new.merge(ikey / 2, 2, Integer::sum);
                    ret = Math.min(ret, dp(dinners, freq_new, cur + 1));
                } else if (jkey > ikey && jkey % ikey == 0) {
                    TreeMap<Long, Integer> freq_new = new TreeMap<>(freq);
                    freq_new.put(jkey, freq_new.get(jkey) - 1);
                    freq_new.merge(jkey / 2, 2, Integer::sum);
                    ret = Math.min(ret, dp(dinners, freq_new, cur + 1));
                }
            }
        }
        return ret;
    }
}
