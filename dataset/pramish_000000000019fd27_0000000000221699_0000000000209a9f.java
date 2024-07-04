//PRANAV MISHRA 
import java.util.*;
import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String n;
        String result = ""; 
        int x;
        int y;
        for (int i = 1; i <= t; ++i) {         
          n = in.next();
          x = 0;
          result = "";
          while(x < n.length())
           {
            if(n.charAt(x) == '1')
             {
               result += "(" ;
               y = x;
               while(y < n.length() && n.charAt(y) == '1')
                {
                  y+=1;
                  result += "1";
                }
               result += ")";
               x = y;
             }
            if(x < n.length() && n.charAt(x) == '0')
             {
               result += "0";
             }
            x+=1;
           }
          System.out.println("Case #" + i + ": " + result);
        }
      }
    }