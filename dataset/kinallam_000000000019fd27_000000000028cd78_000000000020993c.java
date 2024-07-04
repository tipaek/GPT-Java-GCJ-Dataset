import java.util.*;

class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int m =0; m<testcases;m++) {
            int length = in.nextInt();
            int[][] nums = new int[length][length];
            int row = 0;
            int trace =0;
            for (int i=0; i< length; i++) {
                HashSet<Integer> set = new HashSet<Integer>();
                int temp =0;
                for (int j =0; j< length; j++) {
                    nums[i][j] = in.nextInt();
                    if (set.contains(nums[i][j])) {
                        temp ++;
                    } else {
                        set.add(nums[i][j]);
                    }

                    if (i ==j) {
                        trace = trace + nums[i][j];
                    }

                }
                if (temp > 0) {
                    row = row + 1;
                }

            }

            getTrace(nums, m+1, trace, row);
        }


    }

    public static void getTrace(int[][] nums, int testcase, int trace, int r) {


        int col  =0;

        for (int i =0; i<nums.length; i++) {
            HashSet<Integer> set = new HashSet<Integer>();
            int temp =0;
            for (int j =0; j< nums.length; j++) {
                if (set.contains(nums[j][i])) {
                    temp ++;
                } else {
                    set.add(nums[j][i]);
                }
            }
            if (temp > 0) {
                col = col + 1;
            }

        }

        System.out.println("Case #" + testcase + ": " + trace +
                " " + r + " " + col);

    }
}