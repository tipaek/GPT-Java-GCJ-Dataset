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
      for(int i=0;i<N;i++)
      {
          String input = arr[i].substring(1,arr[i].length());
          if(input.indexOf(req.substring(1,req.length()))==1)
            {
                if(arr[i].charAt(arr[i].length()-1)==req.charAt(arr[i].length()-1))
                {}
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
              System.out.println("Case #" + (t) + ": " +result );
          }
         else
         {
             System.out.println("Case #" + (t) + ": " + "*");
         }
    }
  }
}