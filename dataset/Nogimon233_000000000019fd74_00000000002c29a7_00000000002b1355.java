import java.util.*;
import java.io.*;

public class Solution {

    static int ans = 0;
    static int[] dir1 = {1,-1,0,0};
    static int[] dir2 = {0, 0, 1, -1};
    public static void main(String[] args) {
        //.out.println("codejam");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            int r = in.nextInt();
            int c = in.nextInt();
            int[][] nums = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    nums[j][k] = in.nextInt();
                }
            }
            String ans = solve(nums);
            System.out.println("Case #" + i + ": " + ans);
        }
    }

    private static String solve(int[][] nums) {
        ans = 0;
        boolean result = true;
        while(result) {
            result = round(nums);
            //for (int i = 0; i < nums.length; i++) {System.out.println(Arrays.toString(nums[i])); }
        }
        return String.valueOf(ans);
    }

    private static boolean round(int[][] nums) {
        int r = nums.length;
        int c = nums[0].length;
        int[][] ave = new int[r][c];
        int[][] time = new int[r][c];
        for (int i = 1; i < r-1; i++) {
            for (int j = 1; j < c-1; j++) {
                time[i][j] = 4;
            }
        }
        for (int i = 1; i < r-1; i++) {
            time[i][0] = 3;
            time[i][c-1] = 3;
        }
        for (int j = 1; j < c-1; j++) {
            time[0][j] = 3;
            time[r-1][j] = 3;
        }
        time[0][0] = 2;
        time[0][c-1] = 2;
        time[r-1][0] = 2;
        time[r-1][c-1] = 2;

        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (nums[i][j] != -1) {
                    sum += nums[i][j];
                    add(nums, ave, time, i, j);
                }
            }
        }
        ans += sum;

        boolean change = false;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (time[i][j] == 0 || nums[i][j] == -1) {
                    continue;
                }
                if (nums[i][j] * time[i][j] < ave[i][j]) {
                    nums[i][j] = -1;
                    change = true;
                }
            }
        }
        return change;

    }

    private static void add(int[][] nums, int[][] ave, int[][] time, int i, int j) {
        time[i][j] = 4;
        boolean found = false;
        for (int ii = i-1; ii >= 0; ii--) {
            if (nums[ii][j] != -1) {
                ave[ii][j] += nums[i][j];
                found = true;
                break;
            }
        }
        if (!found) {
            time[i][j]--;
        }

        found = false;
        for (int ii = i+1; ii < nums.length; ii++) {
            if (nums[ii][j] != -1) {
                ave[ii][j] += nums[i][j];
                found = true;
                break;
            }
        }
        if (!found) {
            time[i][j]--;
        }

        found = false;
        for (int jj = j-1; jj >= 0; jj--) {
            if (nums[i][jj] != -1) {
                ave[i][jj] += nums[i][j];
                found = true;
                break;
            }
        }
        if (!found) {
            time[i][j]--;
        }

        found = false;
        for (int jj = j+1; jj < nums[0].length; jj++) {
            if (nums[i][jj] != -1) {
                ave[i][jj] += nums[i][j];
                found = true;
                break;
            }
        }
        if (!found) {
            time[i][j]--;
        }

    }

}




