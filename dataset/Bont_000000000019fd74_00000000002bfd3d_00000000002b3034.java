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
    int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int t = 1; t <= T; ++t) {
      int N = in.nextInt();
      String[] arr = new String[N];
      int biglength = 0;
      String req = "";
      String result="";
      for(int i=0;i<N;i++)
      {
          arr[i] = in.next();
          if(arr[i].length()>biglength)
          {
               req = arr[i];
               biglength = arr[i].length() ;    
          }       
      }
     // System.out.println(req);
      for(int i=0;i<N;i++)
      {
          String input = arr[i].substring(1,arr[i].length());
          String input1 = req.substring(1,req.length());
         // System.out.println(input);
          //System.out.println(input.indexOf(input1));
          if(input1.contains(input))
            {
                //System.out.println(arr[i].charAt(arr[i].length()-1));
                //System.out.println(arr[i].charAt(arr[i].length()-1));
                if(arr[i].charAt(arr[i].length()-1)==(req.charAt(req.length()-1)))
                {
                    //System.out.println("goes");
                }
                else
                {
                    result = "*";
                    break;
                }
            }
            else{
                result = "*";
                break;
            }
          
      }
         if(result!="*")
          {
              System.out.println("Case #" + (t) + ": " +req.substring(1,req.length()) );
          }
         else
         {
             System.out.println("Case #" + (t) + ": " +result);
         }
    }
  }
}
