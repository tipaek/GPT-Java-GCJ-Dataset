import java.util.*;

class Solution {
 
    public static void main (String args[]) {
        
        Scanner scanner = new Scanner (System.in);
        int t = scanner.nextInt ();
        
        for (int c = 0; c < t; c++) {
            
            String output = "";
            int currentDepth = 0;
            String input = scanner.next ();
            char[] nums = input.toCharArray ();
            
            for (int i = 0; i < nums.length; i++) {
                int num = Integer.valueOf(nums[i] - '0');
                while (currentDepth < num) {
                    output += "(";
                    currentDepth++;
                }
                while (currentDepth > num) {
                    output += ")";
                    currentDepth--;
                }
                output += num;
            }
            
            while (currentDepth > 0) {
                output += ")";
                currentDepth--;
            }
        
            System.out.println (
                "Case #" + (c + 1) + ": " + output
            );
        }
        
        scanner.close ();
        
    }   
    
}