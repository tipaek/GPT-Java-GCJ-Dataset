import java.util.Scanner;
import java.util.*;

class Solution{

    public static void helper(int caseNo, String str){
        str = "0"+str+"0";
        String[] strings = str.split("");
        int[] nums = new int[str.length()];
        for(int i=0;i<nums.length;i++){
            nums[i] = Integer.valueOf(strings[i]);
        }

        String[] opens = new String[nums.length-2];
        String[] closes = new String[nums.length-2];
        Arrays.fill(opens, "");
        Arrays.fill(closes, "");
        
        for(int i=1;i<nums.length-1;i++){
            int open = nums[i] - nums[i-1];
            while(open > 0){
                opens[i-1] = opens[i-1] + '(';
                open--;
            }

            int close = nums[i] - nums[i+1];
            while(close > 0){
                closes[i-1] = closes[i-1] + ')';
                close--;
            }
        }
        String result = "";
        for(int i=0;i<opens.length;i++){
            result = result + opens[i] + String.valueOf(nums[i+1]) + closes[i];
        }
        System.out.println("Case #"+caseNo+": "+result);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        for(int n=1;n<=cases;n++){
            String str = scanner.next();
            helper(n, str);
        }
        scanner.close();
    }
}