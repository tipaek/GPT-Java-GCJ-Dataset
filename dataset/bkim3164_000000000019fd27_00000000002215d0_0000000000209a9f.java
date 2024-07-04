import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Case #" + (i+1) + ": ");
            solve(in);
            System.out.println();
        }
        in.close();

    }
    static void solve(Scanner in){
        String s = in.next();
        String[] split = s.split("");
        int[] nums = new int[split.length];
       String answers = "";
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        int openP = nums[0];
        int closeP = openP;
        //Starting with the open parenthesis
        if(openP!=0){
        for (int i = 0; i < openP; i++) {
            answers += "(";
        }
        answers += openP;
        }
        else{
            answers += "0";
        }
        //Going through the rest of the list
        int difference = 0;
        f1 : for (int i = 1; i < nums.length; i++) {
            //Next number is greater than previous number
            if(nums[i] > nums[i-1]){
                difference = nums[i] - nums[i-1];
                for (int j = 0; j < difference; j++) {
                    answers += "(";
                }
                answers +=  nums[i];
                for (int j = 0; j < difference; j++) {
                    answers += ")";
                }
            }
            //Next number is less than previous number
            else if(nums[i] < nums[i-1]){
                difference = nums[i-1] - nums[i];
                for (int j = 0; j < difference; j++) {
                    answers += ")";
                    closeP--;
                }
                answers += nums[i];
            }
            else if(nums[i] == nums[i-1]){
                answers += nums[i];
                continue f1;
                
            }
        }
        // Close the remaining paratnehsis
        for (int i = 0; i < closeP; i++) {
            answers += ")";
        }
        System.out.println(answers);

        
    }

}