import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        s.nextLine();
        for (int i=1;i<=t;i++){
            solve(s, i);
        }
    }

    private static void solve(Scanner s, int testCases) {
        String str = s.nextLine();
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        int[] nums = new int[n];
        for (int i=0;i<n;i++){
            nums[i] = Integer.parseInt(str.substring(i,i+1));
        }

        printNumber(sb, nums,0,0);

        System.out.println(String.format("Case #%d: %s", testCases, sb.toString()));
    }

    private static void printNumber(StringBuilder sb, int[] nums, int i, int d) {
        if (i == nums.length){
            for (int ix=d; ix > 0;ix--){
                sb.append(")");
            }
        }

        else if (nums[i] == d){
            sb.append(nums[i]);
            printNumber(sb, nums,i+1,d);
        }

        else if (d < nums[i]){
            for (int ix=d; ix<nums[i];ix++){
                sb.append("(");
            }
//            sb.append("(".repeat(nums[i] - d));
            sb.append(nums[i]);
            printNumber(sb, nums, i+1,nums[i]);
        }
        else if (d > nums[i]){
            for (int ix=d;ix>nums[i];ix--){
                sb.append(")");
            }
//            sb.append(")".repeat( d - nums[i]));
            sb.append(nums[i]);
            printNumber(sb, nums, i+1,nums[i]);
        }

    }

}
