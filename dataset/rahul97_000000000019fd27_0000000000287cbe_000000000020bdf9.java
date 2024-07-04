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
        int partnerend = 0;
        int c = 0, j=0;
        for (int i = 0 ; i < nums.length; i++) {
            int[] curr = nums[i];
            // System.out.print(curr[0]+","+curr[1] + " "  + partnerend + "   ");
            if (i == 0) {
                map.put(curr[0] + "-" + curr[1], "C");
                c = curr[1];
            } else if (i == 1) {
                map.put(curr[0] + "-" + curr[1], "J");
                j = curr[1];
            } else {
                if (curr[0] >= c) {
                    map.put(curr[0] + "-" + curr[1], "C");
                    c = curr[1];
                } else if (curr[0] >= j) {
                    map.put(curr[0] + "-" + curr[1], "J");
                    j = curr[1];
                } else {
                    return "IMPOSSIBLE";
                }
            }
            // int[] prev = null;
            // if (i > 0) {
            //     prev = nums[i-1];
            // }
            // if (prev == null || (prev[1] <= curr[0])) {
            //     map.put(curr[0] + "-" + curr[1], worker);
            //     System.out.println( "ans -> " + worker);
            // } else if ((prev[1] > curr[0] && partnerend <= curr[0])) {
            //     worker = toggle(worker);
            //     map.put(curr[0] + "-" + curr[1], worker);
            //     partnerend = prev[1];
            //     System.out.println( "ans -> " + worker);
            // } else {
            //     return "IMPOSSIBLE";
            // }
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