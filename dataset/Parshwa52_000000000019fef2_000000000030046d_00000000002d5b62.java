import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int x= in.nextInt();
          int y = in.nextInt();
          int sum=Math.abs(x)+Math.abs(y);
          if(sum%2==0)
          System.out.println("Case #" + i + ": IMPOSSIBLE");
          else
          {
              System.out.println("Case #" + i + ": " +"SEN");
          }
          
        }
      }
    }