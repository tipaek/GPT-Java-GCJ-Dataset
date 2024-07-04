import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int x = in.nextInt();
      int y = in.nextInt();
      String result = check(x, y, "");
      
      
      System.out.println("Case #" + i + ": " + result);
    }
  }
  public static String check(int x, int y, String res) {
    if(x==0 && y==1) {
        return res+"N";
    }
    if(x==0 && y==-1) {
        return res+"S";
    }
    if(x==1 && y==0) {
        return res+"E";
    }
    if(x==-1 && y==0) {
        return res+"W";
    }
    
    int xr = x%2;
    int yr = y%2;
    if((Math.abs(xr)==1 && Math.abs(yr)==1) || (xr==0 && yr==0)) {
        return "IMPOSSIBLE";
    }
    String res1 = "IMPOSSIBLE";
    String res2 = "IMPOSSIBLE";
    if(Math.abs(xr)==1 && yr==0) {
        res1 = check((x+1)/2, y/2, res+"W");
        res2 = check((x-1)/2, y/2, res+"E");
    } else {
        res1 = check(x/2, (y+1)/2, res+"S");
        res2 = check(x/2, (y-1)/2, res+"N");
    }
    if(res1.equals("IMPOSSIBLE") && res2.equals("IMPOSSIBLE")) {
        return "IMPOSSIBLE";
    } else if (!res1.equals("IMPOSSIBLE")) {
        return res1;
    } else {
        return res2;
    }
    
  }
}