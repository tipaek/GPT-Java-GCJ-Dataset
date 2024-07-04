// package foregone;

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = in.nextInt();
            in.nextLine();
            for (int i = 1; i <= t; ++i) {
                int m = in.nextInt();
                int [][] nums = new int[m][2];
                for (int j = 0; j< m; j++) {
                    int s = in.nextInt();
                    int e = in.nextInt();
                    nums[j] = new int [] {s,e};
                }
                System.out.println("Case #" + i + ": " + extracted(nums, m));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String extracted(int[][] nums, int m) {
        int[][] nums1 = nums.clone();
        StringBuilder ans = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        Arrays.sort(nums, (a, b) -> Double.compare(a[0], b[0]));
        String worker = "C";
        for (int i = 0 ; i < nums.length; i++) {
            int[] curr = nums[i];
            int[] prev = null;
            if (i > 0) {
                prev = nums[i-1];
            }
            int[] past = null;
            if (i > 1) {
                past = nums[i-2];
            }
            if (prev == null || (prev[1] <= curr[0])) {
                map.put(curr[0] + "-" + curr[1], worker);
            } else if ((prev[1] >= curr[0] && past == null) || (prev[1] >= curr[0] && past[1] <= curr[0])) {
                worker = toggle(worker);
                map.put(curr[0] + "-" + curr[1], worker);
            } else {
                return "IMPOSSIBLE";
            }
        }
        for (int i = 0 ; i < nums1.length; i++) {
            ans.append(map.get(nums1[i][0] + "-" + nums1[i][1]));
        }
        return ans.toString();
    }

    private static String toggle(String worker) {
        return worker == "C" ? "J" : "C"; 
    }

}