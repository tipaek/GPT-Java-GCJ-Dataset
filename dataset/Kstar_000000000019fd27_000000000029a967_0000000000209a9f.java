import java.util.*;
import java.io.*;

public class Solution 
{
  public static void main (String [] args) throws IOException{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(in.readLine());
    for(int i=1; i <= testCases; i++)
    {
      String s = in.readLine();
      int [] array = new int [s.length()+2];
      for(int x =0; x< s.length(); x++)
      {
        array[x+1] = (int)(s.charAt(x) - '0');
      }
      System.out.print("Case #" + i + ": ");
      for(int x =1; x<= s.length(); x++)
      {
        if((array[x] - array[x-1])<0)
        {
          for(int c=0; c < (array[x-1]-array[x]); c++)
          {
            System.out.print(")");
          }
        }
        else 
        {
          for(int c=0; c < (array[x]-array[x-1]); c++)
          {
            System.out.print("(");
          }
        }
        System.out.print(array[x]);
      }              
      for(int c=0; c < (array[s.length()]-array[s.length()+1]); c++)
      {
         System.out.print(")");
      }
      System.out.println();
    }
  }
}