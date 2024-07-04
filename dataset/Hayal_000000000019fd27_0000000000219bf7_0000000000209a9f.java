
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tt = scan.nextInt();
        scan.nextLine();
        for (int t = 0; t <tt ; t++) {
            char[] nm = scan.nextLine().toCharArray();
            int[] nums = new int[nm.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (int)nm[i] - 48;
            }
            String ans = "";
            int len = nm.length;
            int count = 0;
            int left;
            //ifff
            for (int j = 0; j < nums[0] - count; j++) {
                ans = ans.concat("(");
            }           
            count+=nums[0];
            left = count;
            ans = ans.concat(String.valueOf(nums[0]));
            for (int i = 1; i <len ; i++) {
            if(nums[i]>count){
                for (int j = 0; j < nums[i] - count; j++) {
                    ans = ans.concat("(");
                }
                ans = ans.concat(String.valueOf(nums[i]));
                left+=nums[i]-count;
                count=nums[i];
            }
            else if(nums[i]<count){
                for (int j = 0; j <count-nums[i]; j++) {
                    ans = ans.concat(")");
                }
                ans = ans.concat(String.valueOf(nums[i]));
                left-=(count-nums[i]);
                count=nums[i];
            }
            else
                ans = ans.concat(String.valueOf(nums[i]));
            }
            for (int j = 0; j <left; j++) {
                ans = ans.concat(")");
            }
            System.out.println("Case #"+(t+1)+": " + ans);
        }

    }
}

