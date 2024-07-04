import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = input.nextInt();
    for (int i = 1; i <= t; ++i) {
      int x = input.nextInt();
      int y = input.nextInt();
      
      int max = Math.abs(x) + Math.abs(y);
      int maxExp = 0;
      int totalUnits = 1;
      while(totalUnits < max) {
          maxExp++;
          totalUnits += Math.pow(2, maxExp);
      }
      
      StringBuilder ans = new StringBuilder("");
      if(recurse(maxExp+1, x, y, ans)) {
          ans = ans.reverse();
          System.out.println("Case #" + i + ": " + ans.toString());   
      }
      else {
          System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
      }
      
    }
  }
  
  public static boolean recurse(int exp, int x, int y, StringBuilder ans) {
      if(exp==0) {
          if(x==0 && y==0) {
              return true;
          }
          return false;
      }
      
      if(x>0) {
          ans.append("E");
          if(recurse(exp-1, x-(int)Math.pow(2,exp-1), y, ans)) {
              return true;
          }
          ans.deleteCharAt(ans.length()-1);
      }
      else if (x<0) {
          ans.append("W");
          if(recurse(exp-1, x+(int)Math.pow(2,exp-1), y, ans)) {
              return true;
          }
          ans.deleteCharAt(ans.length()-1);
      }
      
      if(y>0) {
          ans.append("N");
          if(recurse(exp-1, x, y-(int)Math.pow(2,exp-1), ans)) {
              return true;
          }
          ans.deleteCharAt(ans.length()-1);
      }
      else if (y<0) {
          ans.append("S");
          if(recurse(exp-1, x, y+(int)Math.pow(2,exp-1), ans)) {
              return true;
          }
          ans.deleteCharAt(ans.length()-1);
      }
      
      return false;
  }
}