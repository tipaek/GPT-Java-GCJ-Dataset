import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        input.nextLine();
        for(int i = 0; i < t; i++) {
            String temp = input.nextLine();
            int[] nums = new int[temp.length()];
            for(int k = 0; k < temp.length(); k++) {
                nums[k] = Integer.parseInt(temp.substring(k, k + 1));
            }
            String real = "";
            if(nums[0] == 0) {
                real += 0;
            } else {
                for(int k = 0; k < nums[0]; k++) {
                    real += "(";
                }
                real += nums[0];
            }
            for(int k = 1; k < nums.length; k++) {
                if(nums[k] == 0) {
                    for(int h = 0; h < nums[k - 1]; h++) {
                        real += ")";
                    }
                    real += "0";
                } else if(nums[k] > nums[k - 1]) {
                    for(int h = 0; h < nums[k] - nums[k - 1]; h++) {
                        real += "(";
                    }
                    real += nums[k];
                } else if(nums[k] < nums[k - 1]) {
                    for(int h = 0; h < nums[k - 1] - nums[k]; h++) {
                        real += ")";
                    }
                    real += nums[k];
                } else if(nums[k] == nums[k - 1]) {
                    real += nums[k];
                }
            }
            for(int k = 0; k < nums[nums.length - 1]; k++) {
                real += ")";
            }
            System.out.println("Case #" + (i + 1) + ": " + real);
        }
    }
}
