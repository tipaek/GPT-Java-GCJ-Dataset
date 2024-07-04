
import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        for (int t = 1; t <= tests; ++t) {
            int len = in.nextInt();
            List<int[]> activities = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                activities.add(new int[]{start, end, i});
            }
            String result = solve(activities);

            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    static class Solver {
        List<int[]> input;
        int size;
        HashMap<String, String> cache;

        public Solver(List<int[]> input) {
            this.input = input;
            this.size = input.size();
            this.cache = new HashMap<>();
        }

        String solve() {
            return rec(0, 0, 0, "");
        }

        String rec(int idx, int endC, int endJ, String s) {
            if (idx == size) {
                return s;
            }
            String key = idx + "#" + endC + "#" + endJ;
            if (cache.containsKey(key)) return cache.get(key);
            int[] cur = input.get(idx);
            int start = cur[0];
            int end = cur[1];
            String first = IMPOSSIBLE;
            if (start >= endC) {
                first = rec(idx + 1, end, endJ, s + "C");
            }
            String second = IMPOSSIBLE;
            if (start >= endJ) {
                second = rec(idx + 1, endC, end, s + "J");
            }
            String result = IMPOSSIBLE;
            if (!first.equals(IMPOSSIBLE)) result = first;
            if (!second.equals(IMPOSSIBLE)) result = second;
            cache.put(key, result);
            return result;
        }
    }

    private static String solve(List<int[]> input) {
        Collections.sort(input, Comparator.comparingInt((int[] o) -> o[1]).thenComparingInt(o -> o[0]));
        String res = new Solver(input).solve();
        if (res.equals(IMPOSSIBLE)) return IMPOSSIBLE;
        char[] arr = new char[res.length()];
        for (int i = 0; i < arr.length; i++) {
            int[] tmp = input.get(i);
            arr[tmp[2]] = res.charAt(i);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            sb.append(ch);
        }
        return sb.toString();
    }
}