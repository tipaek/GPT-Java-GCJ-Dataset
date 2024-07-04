import java.util.*;

public class Solution {

    public static String solve(int[][] a, int n) {
        int res = 0, curr = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] b : a) {
            map.compute(b[0], (k, v) -> v == null ? 1 : v + 1);
            map.compute(b[1], (k, v) -> v == null ? -1 : v - 1);
        }

        for (int i : map.keySet()) {
            curr += map.get(i);
            res = Math.max(res, curr);
        }
        if (res > 2) return "IMPOSSIBLE";

        Arrays.sort(a, Comparator.comparingInt(b -> b[0]));
        StringBuilder sb = new StringBuilder();
        Map<Integer, Character> resMap = new TreeMap<>();
        int prevEnd = -1;
        for (int[] i : a) {
            if (i[0] < prevEnd) toggle();
            resMap.put(i[2], ppl);
            prevEnd = i[1];
        }
        for (int idx : resMap.keySet()) sb.append(resMap.get(idx));
        return sb.toString();
    }

    static char ppl = 'J';
    private static void toggle() {
        ppl = ppl == 'J' ? 'C' : 'J';
    }

    public static void main(String[] args) {
        Scanner in = new Scanner((System.in));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] a = new int[n][3];
            for (int j = 0; j < n; j++) {
                a[j][0] = in.nextInt();
                a[j][1] = in.nextInt();
                a[j][2] = j;
            }
            String s = solve(a, n);
            System.out.println("Case #" + i + ": " + s);
        }
    }
}