/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int x = in.nextInt();
          int y = in.nextInt();
          String str = in.next();
          int j = 0;
          boolean result = false;
          int req = 0;
          while(j<str.length())
          {
              if(str.charAt(j)=='N')
                  y = y+1;
              else if(str.charAt(j)=='S')
                  y = y - 1;
              else if(str.charAt(j)=='E')
                  x = x+1;
              else if(str.charAt(j)=='W')
                  x = x-1;
              j++;      
               if(Math.abs(x)+Math.abs(y)<=j)
                    {
                        result = true;
                     req = j;
                    break;
                    }
          }
          if(result)
                 System.out.println("Case #" + i + ": " +req);
          else
             System.out.println("Case #" + i + ": " +"IMPOSSIBLE");
        }
      }
    }
