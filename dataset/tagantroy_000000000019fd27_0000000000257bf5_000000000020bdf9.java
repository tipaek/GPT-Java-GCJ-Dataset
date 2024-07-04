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
                activities.add(new int[]{start, end});
            }
            String result = solve(activities);

            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    static class Solver {
        List<int[]> input;
        int size;

        public Solver(List<int[]> input) {
            this.input = input;
            this.size = input.size();
        }

        String solve() {
            return rec(0, 0, 0, "");
        }

        String rec(int idx, int endC, int endJ, String s) {
            if (idx == size) {
                return s;
            }
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
            if (!first.equals(IMPOSSIBLE)) return first;
            if (!second.equals(IMPOSSIBLE)) return second;
            return IMPOSSIBLE;
        }
    }

    private static String solve(List<int[]> input) {
        Collections.sort(input, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        return new Solver(input).solve();
    }
}