import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            StringBuilder result = new StringBuilder();
            List<int[]> cIntervals = new ArrayList<>();
            List<int[]> jIntervals = new ArrayList<>();
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                int l = in.nextInt();
                int r = in.nextInt();
                boolean assigned = false;

                if (isNonOverlapping(cIntervals, l, r)) {
                    cIntervals.add(new int[]{l, r});
                    result.append("C");
                    assigned = true;
                } else if (isNonOverlapping(jIntervals, l, r)) {
                    jIntervals.add(new int[]{l, r});
                    result.append("J");
                    assigned = true;
                }

                if (!assigned) {
                    result = new StringBuilder("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }

            System.out.println("Case #" + tt + ": " + result.toString());
        }
    }

    private static boolean isNonOverlapping(List<int[]> intervals, int l, int r) {
        for (int[] interval : intervals) {
            if ((r > interval[0] && r < interval[1]) || (l < interval[1] && l > interval[0])) {
                return false;
            }
        }
        return true;
    }
}