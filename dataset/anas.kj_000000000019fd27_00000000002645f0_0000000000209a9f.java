 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
      
        in.nextLine(); // Read Empty Line
        for (int i = 1; i <= t; ++i) {
            
          String strData  = in.nextLine(); 
          int level=0;
          String result="";
          for(int cc=0;cc<strData.length();cc++)
          {
              int a= Integer.parseInt(String.valueOf(strData.charAt(cc)));
              while(a!=level)
              {
                if(a>level)
                {
                    result+="(";
                    level++;
                }
                else
                    if (a<level)
                    {
                     result+=")";
                    level--;
                    }
              }
              result+=String.valueOf(strData.charAt(cc));
          }
            while(level>0)
              {
               
                 
                     result+=")";
                    level--;
                    
              }
    
          System.out.println("Case #" + i + ": " + result );
        }
      }
    }