import java.io.*;
import java.util.*;

class Solution {
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        
        int cases = sc.nextInt();
        
        for (int c = 0; c < cases; c++) {
            char[] nest = sc.next().toCharArray();
            int[] nums = new int[nest.length];
            
            for (int i = 0; i < nest.length; i++) {
              nums[i] = Integer.parseInt(nest[i] + "");
            }
            StringBuilder result1 = new StringBuilder();
            
            for (int j = 0; j < nest.length; j++) {
              StringBuilder result = new StringBuilder();
              result.append(nums[j]);
              for (int i = 0; i < nums[j]; i++) {
                result.insert(0, "(");
                result.append(")");
              }
              result1.append(result);
            }

            
            boolean done = false;
            while (!done) {
              int l = result1.toString().length();
              boolean broken = false;
              for (int i = 1; i < l; i++) {
                boolean delete = false;
                while (result1.charAt(i - 1) == ')' && result1.charAt(i) == '(') {
                  result1.delete(i-1, i + 1);
                  delete = true;
                }
                if (delete) {
                  broken = true;
                  break;
                }
              }
              if (!broken) done = true;
            }
            
            System.out.println("Case #" + (c + 1) + ": " + result1.toString());
        }
    }
}