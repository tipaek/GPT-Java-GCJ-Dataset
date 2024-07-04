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
      
      String[] ans = new String[1];
      ans[0] = "";
      if(recurse(maxExp+1, x, y, ans)) {
          StringBuilder ii = new StringBuilder(ans[0]);
          ii = ii.reverse();
          System.out.println("Case #" + i + ": " + ii.toString());   
      }
      else {
          System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
      }
      
    }
  }
  
  public static boolean recurse(int exp, int x, int y, String[] ans) {
      if(exp==0) {
          if(x==0 && y==0) {
              return true;
          }
          return false;
      }
      
      if(x>0) {
          ans[0] += "E";
          if(recurse(exp-1, x-(int)Math.pow(2,exp-1), y, ans)) {
              return true;
          }
          ans[0] = ans[0].substring(0, ans[0].length()-1);
      }
      else if (x<0) {
          ans[0] += "W";
          if(recurse(exp-1, x+(int)Math.pow(2,exp-1), y, ans)) {
              return true;
          }
          ans[0] = ans[0].substring(0, ans[0].length()-1);
      }
      
      if(y>0) {
          ans[0] += "N";
          if(recurse(exp-1, x, y-(int)Math.pow(2,exp-1), ans)) {
              return true;
          }
          ans[0] = ans[0].substring(0, ans[0].length()-1);
      }
      else if (y<0) {
          ans[0] += "S";
          if(recurse(exp-1, x, y+(int)Math.pow(2,exp-1), ans)) {
              return true;
          }
          ans[0] = ans[0].substring(0, ans[0].length()-1);
      }
      
      return false;
  }
}