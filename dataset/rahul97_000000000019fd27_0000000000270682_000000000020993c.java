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
                int[][] nums = new int[m][m]; 
                for (int j = 0; j< m; j++) {
                    for (int k = 0; k< m; k++) {
                        nums[j][k] = in.nextInt();
                    }
                }
                System.out.println("Case #" + i + ": " + extracted(nums, m));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String extracted(int[][] nums,int m) {
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        for (int j = 0; j< m; j++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int k = 0; k< m; k++) {
                if (j==k) {
                    ans1 += nums[j][k];
                }
                set.add(nums[j][k]);
            }
            if (m != set.size()) ans2++;
        }
        for (int j = 0; j< m; j++) {
            Set<Integer> set = new HashSet<Integer>();
            for (int k = 0; k< m; k++) {
                set.add(nums[k][j]);
            }
            if (m != set.size()) ans3++;
        }
        return ans1 + " " + ans2 + " "+ ans3;
    }
}