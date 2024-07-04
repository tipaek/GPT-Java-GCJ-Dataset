import java.util.*;
import java.io.*;

public class Solution {
    
    private String addDepthParathesis(String str) {
        String newStr = "";
        String holdingChar = "0";
          String LastholdingChar = "0";
        for ( int i = 0; i < str.length(); i++ ) {
            String temp = String.valueOf(str.charAt(i));
            int dif = 0;
            if ( Integer.parseInt(holdingChar) != Integer.parseInt(temp) && Integer.parseInt(holdingChar) != 0 ) {
                dif = Integer.parseInt(holdingChar) - Integer.parseInt(temp);
                for ( int j = 0; j < dif; j++ ) {
                    newStr  += ")";
                }
            }
            holdingChar = String.valueOf(str.charAt(i));
            if ( Integer.parseInt(holdingChar) != Integer.parseInt(LastholdingChar) ) {
                for ( int j = 0; j < Integer.parseInt(holdingChar) - Integer.parseInt(LastholdingChar); j++ ) {
                    newStr  += "(";
                }
            }
            LastholdingChar = String.valueOf(str.charAt(i));
            newStr += holdingChar;
        }
        if ( Integer.parseInt(holdingChar) > 0 ) {
            for ( int j = 0; j < Integer.parseInt(holdingChar); j++ ) {
                newStr  += ")";
            }
        }
        
        return newStr;
    }
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    Solution sol = new Solution();
    int cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= cases; ++i) {
      String str = in.next();
      String addedParatesis = sol.addDepthParathesis(str);
      System.out.println("Case #" + i + ": " + addedParatesis);
      // System.exit(0);
    }
  }
}